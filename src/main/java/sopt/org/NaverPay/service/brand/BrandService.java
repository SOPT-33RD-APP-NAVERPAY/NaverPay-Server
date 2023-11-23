package sopt.org.NaverPay.service.brand;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.NaverPay.controller.brand.dto.response.BrandLikeResponseDto;
import sopt.org.NaverPay.controller.brand.dto.response.GetBenefitBrandResponseDto;
import sopt.org.NaverPay.controller.brand.dto.response.GetRecommendBrandResponseDto;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.brand.BrandLike;
import sopt.org.NaverPay.domain.brand.BrandLikeId;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.global.exception.CustomException;
import sopt.org.NaverPay.global.exception.ErrorType;
import sopt.org.NaverPay.repository.brand.BrandLikeRepository;
import sopt.org.NaverPay.repository.brand.BrandRepository;
import sopt.org.NaverPay.repository.user.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandLikeRepository brandLikeRepository;
    private final UserRepository userRepository;

    // 혜택 브랜드 리스트 조회
    public GetBenefitBrandResponseDto getBenefitBrands(Long userId) {
        User user = findUserById(userId);
        List<Brand> brandList = brandRepository.findRandomThreeBrands();

        log.info("랜덤 3개의 브랜드 리스트 추출: {}", brandList.size());

        return GetBenefitBrandResponseDto.of(user, brandList);
    }

    // 혜택 추천 브랜드 리스트 조회
    public GetRecommendBrandResponseDto getRecommendBrands() {
        List<Brand> brandList = brandRepository.findRandomFourBrands();
        return GetRecommendBrandResponseDto.of(brandList);
    }

    // 브랜드 찜하기 등록
    @Transactional
    public BrandLikeResponseDto likeBrand(Long userId, Long brandId) {
        User user = findUserById(userId);
        Brand brand = findBrandById(brandId);

        BrandLikeId brandLikeId = BrandLikeId.builder()
                .brandId(brandId)
                .userId(userId)
                .build();

        BrandLike brandLike = BrandLike.builder()
                .brandLikeId(brandLikeId)
                .brand(brand)
                .user(user)
                .build();

        if (brandLikeRepository.findByBrandLikeId(brandLikeId).isPresent()) {
            throw new CustomException(ErrorType.ALREADY_LIKE_BRAND);
        }

        brandLikeRepository.save(brandLike);
        return BrandLikeResponseDto.of(brandLike, true);
    }

    @Transactional
    public BrandLikeResponseDto dislikeBrand(Long userId, Long brandId) {
        BrandLike brandLike = getBrandLikeById(BrandLikeId.builder()
                .userId(userId)
                .brandId(brandId)
                .build());
        brandLikeRepository.delete(brandLike);
        return BrandLikeResponseDto.of(brandLike, false);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorType.NOT_FOUND_USER)
        );
    }

    private Brand findBrandById(Long brandId) {
        return brandRepository.findById(brandId).orElseThrow(
                () -> new CustomException(ErrorType.NOT_FOUND_BRAND)
        );
    }

    private BrandLike getBrandLikeById(BrandLikeId brandLikeId) {
        return brandLikeRepository.findByBrandLikeId(brandLikeId).orElseThrow(
                () -> new CustomException(ErrorType.NOT_FOUND_BRAND_LIKE)
        );
    }
}
