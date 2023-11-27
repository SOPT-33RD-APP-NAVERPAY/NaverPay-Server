package sopt.org.NaverPay.controller.home.dto.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.user.User;

import java.util.List;

@Getter
@Builder
public class HomeResponseDto {

    @JsonProperty("user_point")
    private int userPoint;

    @JsonProperty("onsite_payment")
    private OnsitePaymentDto onsitePaymentDto;

    @JsonProperty("brand_list")
    private List<BrandDto> brandDtoList;

    public static HomeResponseDto of(User user, OnsitePaymentDto onsitePaymentDto, List<BrandDto> brandDtoList) {
        return HomeResponseDto.builder()
                .userPoint(user.getTotalSaving())
                .onsitePaymentDto(onsitePaymentDto)
                .brandDtoList(brandDtoList)
                .build();
    }
}
