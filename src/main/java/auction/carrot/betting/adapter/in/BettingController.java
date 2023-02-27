package auction.carrot.betting.adapter.in;

import auction.carrot.betting.adapter.in.command.BettingCommand;
import auction.carrot.betting.adapter.in.mapper.BettingMapper;
import auction.carrot.betting.application.BettingService;
import auction.carrot.betting.domain.Betting;
import auction.carrot.member.Member;
import auction.carrot.betting.port.in.BettingUseCase;
import auction.carrot.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/bettings")
@RestController
@RequiredArgsConstructor
public class BettingController {

    private final BettingUseCase bettingUseCase;
    private final MemberRepository memberRepository;
    private final BettingService bettingService;

    @PostMapping
    public ResponseEntity<BettingCommand> createBetting(@RequestBody BettingCommand command){
        BettingMapper mapper = new BettingMapper();

        Member member1 = new Member("example1.com");
        Member member2 = new Member("example2.com");
        Member member3 = new Member("example3.com");
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDomain("c", bettingUseCase.createBetting(mapper.toEntity(command))));
    }

    @PatchMapping("/{bettingSeq}")
    public ResponseEntity<Void> updateBetting(@PathVariable final Long bettingSeq, @RequestBody BettingCommand command){
        BettingMapper mapper = new BettingMapper();
        bettingUseCase.updateBetting(bettingSeq, mapper.toEntity(command));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{bettingSeq}")
    public ResponseEntity<Void> cancelBetting(@PathVariable final Long bettingSeq){
        bettingUseCase.cancelBetting(bettingSeq);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Betting>> getBettings(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(bettingUseCase.getBettings());
    }

    @GetMapping("/{bettingSeq}")
    public ResponseEntity<BettingCommand> getBettingOne(@PathVariable final Long bettingSeq){
        BettingMapper mapper = new BettingMapper();
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toReadDomain(bettingUseCase.getBettingOne(bettingSeq)));
    }

}
