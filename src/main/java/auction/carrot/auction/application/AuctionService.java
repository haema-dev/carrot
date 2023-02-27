package auction.carrot.auction.application;

import auction.carrot.auction.domain.Auction;
import auction.carrot.auction.port.in.AuctionUseCase;
import auction.carrot.auction.port.out.AuctionPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuctionService implements AuctionUseCase {

    private final AuctionPort port;

    @Override
    public Auction createAuction(Auction auction) {
        return port.createAuction(auction);
    }

    @Override
    public void updateAuction(final Long auctionId, Auction updateAuction) {
        port.updateAuction(auctionId, updateAuction);
    }

    @Override
    public void deleteAuction(Long auctionId) {
        port.deleteAuction(auctionId);
    }

    @Override
    public Auction getAuctionOne(final Long auctionId) {
        return port.getAuctionOne(auctionId);
    }

    @Override
    public List<Auction> getAuctions() {
        return port.getAuctions();
    }

}
