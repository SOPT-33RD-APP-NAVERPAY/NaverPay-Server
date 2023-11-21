package sopt.org.NaverPay.domain.brand;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.NaverPay.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BrandLike {

    @EmbeddedId
    private BrandLikeId brandLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("brandId")
    @JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Brand brand;

    @Builder
    public BrandLike(BrandLikeId brandLikeId, User user, Brand brand) {
        this.brandLikeId = brandLikeId;
        this.user = user;
        this.brand = brand;
    }
}
