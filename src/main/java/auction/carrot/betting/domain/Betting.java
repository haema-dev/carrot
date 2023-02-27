package auction.carrot.betting.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Builder
@ToString
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "betting_seq_generator",
                   sequenceName = "betting_seq",
                   initialValue = 1, allocationSize = 1)
public class Betting {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "betting_seq_generator")
    @Column(name = "betting_seq", updatable = false)
    private Long bettingSeq;

    @Column(name = "auction_id", nullable = false, updatable = false)
    private Long auctionId;

    @Column(name = "betting_cost", nullable = false)
    private Long bettingCost;

    @Column(name = "email", nullable = false, updatable = false)
    private String email;

    @Column(name = "betting_status")
    private boolean bettingStatus = false;

    public void change(Long bettingCost, String email) {
        this.bettingCost = bettingCost;
        this.email = email;
    }
}
