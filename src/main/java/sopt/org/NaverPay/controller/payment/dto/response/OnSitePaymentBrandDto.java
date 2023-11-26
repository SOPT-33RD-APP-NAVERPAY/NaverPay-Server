package sopt.org.NaverPay.controller.payment.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OnSitePaymentBrandDto {


    private Long id;
    private String name;
    private String logoImgUrl;

    public static OnSitePaymentBrandDto of(Brand brand) {
        return OnSitePaymentBrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .logoImgUrl(brand.getLogoImgUrl())
                .build();
    }
}
