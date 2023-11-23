package sopt.org.NaverPay.controller.brand.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.BrandLike;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BrandLikeResponseDto {

    private Long brandId;
    private Boolean isBrandLike;

    public static BrandLikeResponseDto of(BrandLike brandLike, Boolean isBrandLike) {
        return BrandLikeResponseDto.builder()
                .brandId(brandLike.getBrand().getId())
                .isBrandLike(isBrandLike)
                .build();
    }
}
