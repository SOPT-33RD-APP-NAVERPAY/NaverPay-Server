package sopt.org.NaverPay.controller.brand.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.user.User;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetBenefitBrandResponseDto {

    private String userName;
    private Integer userPoint;
    private List<BrandDto> brandList;

    public static GetBenefitBrandResponseDto of(User user, List<BrandDto> brandDtoList) {
        return GetBenefitBrandResponseDto.builder()
                .userName(user.getName())
                .userPoint(user.getTotalSaving())
                .brandList(brandDtoList)
                .build();
    }
}
