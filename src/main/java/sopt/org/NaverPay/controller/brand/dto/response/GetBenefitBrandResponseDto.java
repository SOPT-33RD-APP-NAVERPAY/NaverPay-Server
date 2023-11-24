package sopt.org.NaverPay.controller.brand.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.user.User;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetBenefitBrandResponseDto {

    private String userName;
    private Integer userPoint;
    private List<BrandDto> brandList;

    public static GetBenefitBrandResponseDto of(User user, List<Brand> brandList) {
        return GetBenefitBrandResponseDto.builder()
                .userName(user.getName())
                .userPoint(user.getTotalSaving())
                .brandList(brandList.stream().map(b -> BrandDto.of(b, user.getBrandLikeList().contains(b))).collect(Collectors.toList()))
                .build();
    }
}
