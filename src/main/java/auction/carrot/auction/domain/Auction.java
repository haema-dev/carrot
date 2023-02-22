package auction.carrot.auction.domain;

import auction.carrot.common.global.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Getter
@Builder
@ToString
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class Auction extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id", nullable = false, updatable = false)
    private Long auctionNo;

    @Column(name = "auction_item_owner", nullable = false, updatable = false)
    @NotBlank
    private String auctionItemOwner;

    @Column(name = "auction_item_name", nullable = false, updatable = false)
    @NotBlank
    private String auctionItemName;

    @Column(name = "auction_betting_cost", nullable = false, updatable = false)
    @NotBlank
    private Long auctionBettingCost;

    @Column(name = "auction_competition_first")
    @NotBlank
    private String auctionCompetitionFirst;

    @Column(name = "auction_status", nullable = false, updatable = false)
    @NotBlank
    private boolean auctionStatus = false;

    public void change(String auctionCompetitionFirst) {
        this.auctionCompetitionFirst = auctionCompetitionFirst;
    }

}
