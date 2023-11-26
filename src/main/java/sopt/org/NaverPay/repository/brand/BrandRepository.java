package sopt.org.NaverPay.repository.brand;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sopt.org.NaverPay.domain.brand.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(value = "SELECT * FROM brand ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Brand> findRandomThreeBrands();

    @Query(value = "SELECT * FROM brand ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<Brand> findRandomFourBrands();

    @Query(value = "SELECT * FROM brand ORDER BY RAND() LIMIT 6", nativeQuery = true)
    List<Brand> findRandomSixBrands();

}
