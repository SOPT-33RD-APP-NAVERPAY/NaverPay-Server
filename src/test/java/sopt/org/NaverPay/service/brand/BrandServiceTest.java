package sopt.org.NaverPay.service.brand;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.repository.brand.BrandLikeRepository;
import sopt.org.NaverPay.repository.brand.BrandRepository;
import sopt.org.NaverPay.repository.user.UserRepository;

@SpringBootTest
class BrandServiceTest {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandLikeRepository brandLikeRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("혜택 브랜드 내역 출력 시, 브랜드 찜 하기 여부가 제대로 반영되어 조회된다.")
    void showListWithBrandLike() {
        User user = userRepository.findById(1L).get();
        Brand brand1 = brandRepository.findById(1L).get();
        Brand brand2 = brandRepository.findById(3L).get();

        assertThat(brandLikeRepository.existsBrandLikeByBrandAndUser(brand1, user)).isTrue();
        assertThat(brandLikeRepository.existsBrandLikeByBrandAndUser(brand2, user)).isFalse();
//        assertThat(user.getBrandLikeList().contains(brand1)).isTrue();
//        assertThat(user.getBrandLikeList().contains(brand2)).isFalse();
    }

}