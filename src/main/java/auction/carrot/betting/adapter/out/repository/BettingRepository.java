package auction.carrot.betting.adapter.out.repository;

import auction.carrot.betting.domain.Betting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BettingRepository extends JpaRepository<Betting, Long> {
}
