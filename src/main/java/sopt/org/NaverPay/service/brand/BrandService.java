package sopt.org.NaverPay.service.brand;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sopt.org.NaverPay.controller.brand.dto.response.GetBenefitBrandResponseDto;
import sopt.org.NaverPay.controller.brand.dto.response.GetRecommendBrandResponseDto;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.repository.brand.BrandRepository;
import sopt.org.NaverPay.repository.user.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;

    // 혜택 브랜드 리스트 조회
    public GetBenefitBrandResponseDto getBenefitBrands(Long userId) {
        User user = userRepository.findByIdOrThrow(userId);
        List<Brand> brandList = brandRepository.findRandomThreeBrands();

        log.info("랜덤 3개의 브랜드 리스트 추출: {}", brandList.size());

        return GetBenefitBrandResponseDto.of(user, brandList);
    }

    // 혜택 추천 브랜드 리스트 조회
    public GetRecommendBrandResponseDto getRecommendBrands() {
        List<Brand> brandList = brandRepository.findRandomFourBrands();
        return GetRecommendBrandResponseDto.of(brandList);
    }
}
