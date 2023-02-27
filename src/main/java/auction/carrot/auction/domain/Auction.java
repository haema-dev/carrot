package auction.carrot.auction.domain;

import auction.carrot.member.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Getter
@ToString
@DynamicUpdate
@NoArgsConstructor
public class Auction /*extends BaseTimeEntity*/ {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id", updatable = false)
    private Long auctionNo;

    @Column(name = "auction_item_owner", nullable = false, updatable = false)
    private String auctionItemOwner;

    @Column(name = "auction_item_name", nullable = false, updatable = false)
    private String auctionItemName;

    @Column(name = "auction_betting_cost", nullable = false)
    private Long auctionBettingCost;

    @Column(name = "auction_competition_first")
    private String auctionCompetitionFirst;

    @Column(name = "auction_status", nullable = false)
    private Boolean auctionStatus;

    @OneToOne(mappedBy = "auction", cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_competition_first")
    private Member member = new Member();


    @Builder
    public Auction(Long auctionNo, String auctionItemOwner, String auctionItemName
            , long auctionBettingCost, String auctionCompetitionFirst, Boolean auctionStatus) {
        this.auctionNo = auctionNo;
        this.auctionItemOwner = auctionItemOwner;
        this.auctionItemName = auctionItemName;
        this.auctionBettingCost = auctionBettingCost;
        this.auctionCompetitionFirst = auctionCompetitionFirst;
        this.auctionStatus = auctionStatus;
    }

    public void change(Long auctionBettingCost,String auctionCompetitionFirst) {
        this.auctionBettingCost = auctionBettingCost;
        this.auctionCompetitionFirst = auctionCompetitionFirst;
    }

}
