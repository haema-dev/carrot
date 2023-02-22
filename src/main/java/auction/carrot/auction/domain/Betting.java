package auction.carrot.auction.domain;

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
@SequenceGenerator(name = "betting_seq_generator",
                   sequenceName = "betting_seq",
                   initialValue = 1, allocationSize = 1)
public class Betting {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "betting_seq_generator")
    @Column(name = "betting_seq", nullable = false, updatable = false)
    private String betting_seq;

    @Column(name = "auction_id", nullable = false, updatable = false)
    @NotBlank
    private String auction_id;

    @Column(name = "betting_cost", nullable = false)
    @NotBlank
    private String betting_cost;

    @Column(name = "email", nullable = false, updatable = false)
    @NotBlank
    private String email;
}
