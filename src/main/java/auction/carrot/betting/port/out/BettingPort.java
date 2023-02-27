package auction.carrot.betting.port.out;

import auction.carrot.betting.domain.Betting;

import java.util.List;

public interface BettingPort {

    Betting createBetting(Betting betting);

    void updateBetting(final Long bettingSeq, Betting updateBetting);

    void cancelBetting(final Long bettingSeq);

    Betting getBettingOne(final Long bettingSeq);

    List<Betting> getBettings();
}