package sopt.org.NaverPay.domain.payment;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.NaverPay.domain.basetime.BaseTimeEntity;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.user.User;

@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Payment extends BaseTimeEntity {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;
    // 한 명의 유저가 여러 개의 Payment를 가질 수 있어서 @ManyToOne 연관 간계를 사용,
    // No Constraint는 외래 키 제약을 생성 하지 않는 것을 의미하는데 연관된 엔티티가 삭제되어도 해당 필드에 null을 허용함

    @OneToOne
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Brand brand;
    // 한 개의 브랜드는 한 개의 Payment를 가질 수 있어서 @OneToOne 연관 관계를 사용

}
