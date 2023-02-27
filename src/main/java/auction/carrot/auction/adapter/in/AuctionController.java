package auction.carrot.auction.adapter.in;

import auction.carrot.auction.adapter.in.command.AuctionCommand;
import auction.carrot.auction.adapter.in.mapper.AuctionMapper;
import auction.carrot.auction.domain.Auction;
import auction.carrot.auction.port.in.AuctionUseCase;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/auctions")
@RestController
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionUseCase auctionUseCase;

    @ApiOperation(value = "경매 정보 생성")
    @PostMapping
    public ResponseEntity<AuctionCommand> createAuction(@RequestBody AuctionCommand command){
        AuctionMapper mapper = new AuctionMapper();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDomain("c", auctionUseCase.createAuction(mapper.toEntity(command))));
    }

    @PatchMapping("/{auctionId}")
    public ResponseEntity<Void> updateAuction(@PathVariable final Long auctionId, @RequestBody AuctionCommand command){
        AuctionMapper mapper = new AuctionMapper();
        auctionUseCase.updateAuction(auctionId, mapper.toEntity(command));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{auctionId}")
    public ResponseEntity<Void> deleteAuction(@PathVariable final Long auctionId){
        auctionUseCase.deleteAuction(auctionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Auction>> getAuctions(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(auctionUseCase.getAuctions());
    }

    @GetMapping("/{auctionId}")
    public ResponseEntity<AuctionCommand> getAuctionOne(@PathVariable final Long auctionId){
        AuctionMapper mapper = new AuctionMapper();
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toReadDomain(auctionUseCase.getAuctionOne(auctionId)));
    }

}
