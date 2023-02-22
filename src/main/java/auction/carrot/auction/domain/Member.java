package auction.carrot.auction.domain;

import auction.carrot.common.global.BaseTimeEntity;
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
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "email", nullable = false, updatable = false)
    private String email;

}
