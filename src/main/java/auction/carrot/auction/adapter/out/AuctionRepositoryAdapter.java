package auction.carrot.auction.adapter.out;

import auction.carrot.auction.adapter.out.repository.AuctionRepository;
import auction.carrot.auction.domain.Auction;
import auction.carrot.auction.port.out.AuctionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "auctionRepositoryAdapter")
@RequiredArgsConstructor
public class AuctionRepositoryAdapter implements AuctionPort {

    private final AuctionRepository repository;

    @Override
    public Auction createAuction(Auction auction) {
        return repository.save(auction);
    }

    @Override
    public void updateAuction(final Long auctionId, Auction updateAuction) {
        Auction auction = repository.findById(auctionId).orElseThrow(
                () -> new NullPointerException());
        auction.change(updateAuction.getAuctionBettingCost(), updateAuction.getAuctionCompetitionFirst());
    }

    @Override
    public void deleteAuction(final Long auctionId) {
        repository.deleteById(auctionId);
    }

    @Override
    public List<Auction> getAuctions() {
        return repository.findAll();
    }

    @Override
    public Auction getAuctionOne(final Long auctionId) {
        return repository.findById(auctionId).orElseThrow(
                () -> new NullPointerException());
    }
}
