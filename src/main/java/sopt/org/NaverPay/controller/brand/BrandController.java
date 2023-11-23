package sopt.org.NaverPay.controller.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.NaverPay.controller.brand.dto.response.GetBenefitBrandResponseDto;
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
}
