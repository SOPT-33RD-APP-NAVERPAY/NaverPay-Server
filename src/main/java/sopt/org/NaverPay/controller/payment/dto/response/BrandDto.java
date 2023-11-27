package sopt.org.NaverPay.controller.payment.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BrandDto {

    private Long id;
    private String logoImgUrl;   // logoImgUrl -> logo_img_url

    public static BrandDto of(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .logoImgUrl(brand.getLogoImgUrl())
                .build();
    }
}
