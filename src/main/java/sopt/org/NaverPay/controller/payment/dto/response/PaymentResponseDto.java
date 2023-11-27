package sopt.org.NaverPay.controller.payment.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.user.User;

import java.util.List;

@Getter
@Builder
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentResponseDto {

    @JsonProperty("user_name")
    private String userName;   // 사용자 이름

    @JsonProperty("nearbyplace_list")
    private List<NearByBrandDto> nearByBrandDtoList;   // near by dto list

    @JsonProperty("brand_list")
    private List<BrandDto> brandDtoList;   // dto list

    @JsonProperty("onsitepayment_list")
    private List<OnSitePaymentBrandDto> onSitePaymentBrandDtoList;   // on site dto list

    public static PaymentResponseDto of(List<BrandDto> brandDtoList, List<NearByBrandDto> nearByBrandDtoList, List<OnSitePaymentBrandDto> onSitePaymentBrandDtoList, User user) {
        return PaymentResponseDto.builder()
                .brandDtoList(brandDtoList)
                .nearByBrandDtoList(nearByBrandDtoList)
                .onSitePaymentBrandDtoList(onSitePaymentBrandDtoList)
                .userName(user.getName())   // ex. 남희주
                .build();
    }

}
