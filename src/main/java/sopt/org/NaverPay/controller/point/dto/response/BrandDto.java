package sopt.org.NaverPay.controller.point.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.common.BaseTimeEntity;
import sopt.org.NaverPay.domain.point.Point;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.time.LocalDateTime;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BrandDto {

    private Long id;
    private String name;
    private int saving;
    private String payment_date;

    public static BrandDto of(Brand brand, Point point) {
        // brand == point.getBrand()
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .saving(point.getSaving())
                .payment_date(point.getCreatedAt().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))) // 출력 형식 수정
                .build();
    }
}
