package sopt.org.NaverPay.controller.brand.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetRecommendBrandResponseDto {

    private List<BrandDto> brandList;

    public static GetRecommendBrandResponseDto of(List<Brand> brandList) {
        return GetRecommendBrandResponseDto.builder()
                .brandList(brandList.stream().map(b -> BrandDto.of(b, null)).collect(Collectors.toList()))
                .build();
    }
}
