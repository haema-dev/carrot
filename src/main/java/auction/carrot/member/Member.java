package auction.carrot.member;

import auction.carrot.auction.domain.Auction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member /*extends BaseTimeEntity*/ {

    @Id
    @Column(name = "email", nullable = false, updatable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "email")
    private Auction auction;

    public Member(String email) {
        this.email = email;
    }
}
