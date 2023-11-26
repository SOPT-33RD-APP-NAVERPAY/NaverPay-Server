package sopt.org.NaverPay.controller.payment.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NearByBrandDto {

    /**
    snake : hello_world
     camel : helloWorld
     logoImgUrl -> logo_img_url

     */

    private Long id;
    private String name;
    private String logoImgUrl;
    private int distance;

    public static NearByBrandDto of(Brand brand) {
        return NearByBrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .logoImgUrl(brand.getLogoImgUrl())
                .distance(brand.getDistance())
                .build();
    }


}
