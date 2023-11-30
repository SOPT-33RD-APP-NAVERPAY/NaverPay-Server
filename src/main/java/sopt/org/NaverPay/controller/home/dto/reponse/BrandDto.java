package sopt.org.NaverPay.controller.home.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;

@Getter
@Builder
public class BrandDto {

    private Long id;
    private String name;
    private String place;

    @JsonProperty("logo_img_url")
    private String logoImgUrl;

    @JsonProperty("discount_content")
    private String discountContent;

    public static BrandDto of(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .place(brand.getPlace() == null ? " " : brand.getPlace())
                .logoImgUrl(brand.getLogoImgUrl())
                .discountContent(brand.getDiscountContent())
                .build();
    }
}
