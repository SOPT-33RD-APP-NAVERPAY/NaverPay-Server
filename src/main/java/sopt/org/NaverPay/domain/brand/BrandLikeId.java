package sopt.org.NaverPay.domain.brand;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BrandLikeId implements Serializable {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long brandId;

    @Builder
    private BrandLikeId(Long userId, Long brandId) {
        this.userId = userId;
        this.brandId = brandId;
    }
}
