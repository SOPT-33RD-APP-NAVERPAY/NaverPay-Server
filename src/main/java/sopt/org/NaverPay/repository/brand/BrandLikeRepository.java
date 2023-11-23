package sopt.org.NaverPay.repository.brand;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.NaverPay.domain.brand.BrandLike;
import sopt.org.NaverPay.domain.brand.BrandLikeId;

public interface BrandLikeRepository extends JpaRepository<BrandLike, BrandLikeId> {

    Optional<BrandLike> findByBrandLikeId(BrandLikeId brandLikeId);
}
