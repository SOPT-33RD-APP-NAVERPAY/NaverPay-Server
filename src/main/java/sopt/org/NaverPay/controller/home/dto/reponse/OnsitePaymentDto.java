package sopt.org.NaverPay.controller.home.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.payment.Payment;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Getter
@Builder
public class OnsitePaymentDto {

    private Long id;
    private String name;
    private String place;

    @JsonProperty("logo_img_url")
    private String logoImgUrl;
    private int amount;
    @JsonProperty("payment_date")
    private String paymentDate;

    public static OnsitePaymentDto of(Brand brand, Payment payment) {
        // brand == payment.getBrand();
        return OnsitePaymentDto.builder()
                .id(payment.getId())
                .name(brand.getName())
                .place(brand.getPlace())
                .logoImgUrl(brand.getLogoImgUrl())
                .amount(payment.getAmount())
                .paymentDate(payment.getCreatedAt().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)))
                .build();
    }
}
