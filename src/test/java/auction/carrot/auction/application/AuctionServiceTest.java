package auction.carrot.auction.application;

import auction.carrot.auction.domain.Auction;
import auction.carrot.auction.port.out.AuctionPort;
import auction.carrot.betting.application.BettingService;
import auction.carrot.member.Member;
import auction.carrot.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AuctionServiceTest {

    @Autowired
    AuctionPort port;

    @Autowired
    MemberRepository repository;

    @Autowired
    BettingService bettingService;

    @Test
    @Rollback(value = false)
    @DisplayName("유저/경매 정보 생성")
    @Transactional
    void save() {
        //given
        Member member1 = new Member("example1.com");
        Member member2 = new Member("example2.com");
        Member member3 = new Member("example3.com");

        Auction auction1 = new Auction(1L, "owner1", "iPad-Mini-5", 500L, "", true);
        Auction auction2 = new Auction(2L, "owner2", "Galaxy-9S", 1500L, "", true);

        //when
        repository.save(member1);
        repository.save(member2);
        repository.save(member3);

        port.createAuction(auction1);
        port.createAuction(auction2);

        //Betting betting1 = new Betting(1L, 1L, 550L, "example1.com");
        //bettingService.createBetting(betting1);

        //Betting betting2 = new Betting(2L, 1L, 450L, "example2.com");
        //bettingService.createBetting(betting2);

        //Betting betting3 = new Betting(3L, 2L, 1600L, "example3.com");
        //bettingService.createBetting(betting3);

        //then
        //Assertions.assertThat(auction1.getAuctionBettingCost()).isEqualTo(betting1.getBettingCost());
        //Assertions.assertThat(auction1.getAuctionCompetitionFirst()).isEqualTo(betting1.getEmail());
        //Assertions.assertThat(auction1.getAuctionCompetitionFirst()).isEqualTo(member1.getEmail());
    }

}
