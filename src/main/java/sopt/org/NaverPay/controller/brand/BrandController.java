package sopt.org.NaverPay.controller.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.NaverPay.controller.brand.dto.response.BrandLikeResponseDto;
import sopt.org.NaverPay.controller.brand.dto.response.GetBenefitBrandResponseDto;
import sopt.org.NaverPay.controller.brand.dto.response.GetRecommendBrandResponseDto;
import sopt.org.NaverPay.global.exception.ApiResponse;
import sopt.org.NaverPay.global.exception.SuccessType;
import sopt.org.NaverPay.service.brand.BrandService;

@RestController
@RequestMapping("/benefit")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    private static final String CUSTOM_AUTH_ID = "X-Auth-id";  // 상수(static final)로 관리

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetBenefitBrandResponseDto> getBenefitBrands(@RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        return ApiResponse.success(SuccessType.GET_BENEFIT_BRAND_LIST_SUCCESS, brandService.getBenefitBrands(userId));
    }

    @GetMapping("/recommend")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetRecommendBrandResponseDto> getRecommendBrands(@RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        return ApiResponse.success(SuccessType.GET_RECOMMEND_BRAND_LIST_SUCCESS, brandService.getRecommendBrands(userId));
    }

    @PostMapping("/like/{brandId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<BrandLikeResponseDto> likeBrand(@RequestHeader(CUSTOM_AUTH_ID) Long userId, @PathVariable Long brandId) {
        return ApiResponse.success(SuccessType.BRAND_LIKE_SUCCESS, brandService.likeBrand(userId, brandId));
    }

    @DeleteMapping("/like/{brandId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<BrandLikeResponseDto> dislikeBrand(@RequestHeader(CUSTOM_AUTH_ID) Long userId, @PathVariable Long brandId) {
        return ApiResponse.success(SuccessType.BRAND_DISLIKE_SUCCESS, brandService.dislikeBrand(userId, brandId));
    }
}
