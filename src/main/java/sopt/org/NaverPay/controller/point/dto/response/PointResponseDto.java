package sopt.org.NaverPay.controller.point.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.controller.payment.dto.response.NearByBrandDto;
import sopt.org.NaverPay.controller.payment.dto.response.OnSitePaymentBrandDto;
import sopt.org.NaverPay.controller.payment.dto.response.PaymentResponseDto;
import sopt.org.NaverPay.domain.point.Point;
import sopt.org.NaverPay.domain.user.User;

import java.util.List;

@Getter
@Builder
public class PointResponseDto {

    @JsonProperty("user_point")
    private int userPoint;

    @JsonProperty("basic_point")
    private int basicPoint;

    @JsonProperty("membership_point")
    private int membershipPoint;

    @JsonProperty("review_point")
    private int reviewPoint;

    @JsonProperty("payment_method_point")
    private int paymentMethodPoint;

    @JsonProperty("brand_list")
    private List<BrandDto> brandDtoList;

    public static PointResponseDto of(User user, int basicPoint, int membershipPoint, int paymentMethodPoint, int reviewPoint, List<BrandDto> brandDtoList) {
        return PointResponseDto.builder()
                .userPoint(user.getTotalSaving())
                .basicPoint(basicPoint)
                .membershipPoint(membershipPoint)
                .reviewPoint(reviewPoint)
                .paymentMethodPoint(paymentMethodPoint)
                .brandDtoList(brandDtoList)
                .build();
    }
}
