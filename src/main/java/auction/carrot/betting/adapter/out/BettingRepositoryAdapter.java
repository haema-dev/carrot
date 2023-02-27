package auction.carrot.betting.adapter.out;

import auction.carrot.auction.adapter.out.repository.AuctionRepository;
import auction.carrot.auction.domain.Auction;
import auction.carrot.betting.adapter.out.repository.BettingRepository;
import auction.carrot.betting.domain.Betting;
import auction.carrot.betting.port.out.BettingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "bettingRepositoryAdapter")
@RequiredArgsConstructor
public class BettingRepositoryAdapter implements BettingPort {

    private final BettingRepository bettingRepository;
    private final AuctionRepository auctionRepository;

    @Override
    public Betting createBetting(Betting betting) {
        return bettingRepository.save(betting);
    }

    @Override
    public void updateBetting(final Long bettingSeq, Betting updateBetting) {
        Betting betting = bettingRepository.findById(bettingSeq).orElseThrow(
                () -> new NullPointerException());
        betting.change(updateBetting.getBettingCost(), updateBetting.getEmail());

        Auction findAuction = auctionRepository.findById(betting.getAuctionId())
                .orElseThrow(() -> new NullPointerException());

        if(betting.getBettingCost() > findAuction.getAuctionBettingCost()) {
            findAuction.change(betting.getBettingCost(), betting.getEmail());
        }
    }

    @Override
    public void cancelBetting(final Long bettingSeq) {
        bettingRepository.findById(bettingSeq);
    }

    @Override
    public List<Betting> getBettings() {
        return bettingRepository.findAll();
    }

    @Override
    public Betting getBettingOne(final Long auctionId) {
        return bettingRepository.findById(auctionId).orElseThrow(
                () -> new NullPointerException());
    }
}
