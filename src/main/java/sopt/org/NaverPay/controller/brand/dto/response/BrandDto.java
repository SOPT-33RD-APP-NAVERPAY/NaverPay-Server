package sopt.org.NaverPay.controller.brand.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BrandDto {

    private Long id;
    private String name;
    private String logoImgUrl;
    private String discountContent;
    private String discountType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isBrandLike;

    public static BrandDto of(Brand brand, Boolean isBrandLike) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .logoImgUrl(brand.getLogoImgUrl())
                .discountContent(brand.getDiscountContent())
                .discountType(brand.getDiscountType().getValue())
                .isBrandLike(isBrandLike)
                .build();
    }
}
