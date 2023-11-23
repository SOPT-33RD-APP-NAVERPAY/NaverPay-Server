package sopt.org.NaverPay.domain.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.NaverPay.domain.brand.BrandLike;
import sopt.org.NaverPay.domain.brand.BrandLikeId;
import sopt.org.NaverPay.domain.common.BaseTimeEntity;
import sopt.org.NaverPay.domain.payment.Payment;
import sopt.org.NaverPay.domain.point.Point;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`user`")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int totalSaving = 0;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Payment> paymentList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Point> pointList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<BrandLike> brandLikeList = new ArrayList<>();

    public void updatePoint(int saving) {
        this.totalSaving += saving;
    }

    public void addBrandLike(BrandLike brandLike) {
        this.brandLikeList.add(brandLike);
    }

    public void deleteBrandLike(BrandLike brandLike) {
        this.brandLikeList.remove(brandLike);
    }
}
