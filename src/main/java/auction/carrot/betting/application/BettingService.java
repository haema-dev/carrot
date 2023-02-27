package auction.carrot.betting.application;

import auction.carrot.auction.adapter.out.repository.AuctionRepository;
import auction.carrot.auction.domain.Auction;
import auction.carrot.auction.port.in.AuctionUseCase;
import auction.carrot.auction.port.out.AuctionPort;
import auction.carrot.betting.adapter.out.repository.BettingRepository;
import auction.carrot.betting.domain.Betting;
import auction.carrot.betting.port.in.BettingUseCase;
import auction.carrot.betting.port.out.BettingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class BettingService implements BettingUseCase {

    private final BettingPort port;

    @Override
    public Betting createBetting(Betting betting) {
        return port.createBetting(betting);
    }

    @Override
    public void updateBetting(Long bettingSeq, Betting updateBetting) {
        port.updateBetting(bettingSeq, updateBetting);
    }

    @Override
    public void cancelBetting(Long bettingSeq) {
        port.cancelBetting(bettingSeq);
    }

    @Override
    public Betting getBettingOne(Long bettingSeq) {
        return port.getBettingOne(bettingSeq);
    }

    @Override
    public List<Betting> getBettings() {
        return port.getBettings();
    }
}
