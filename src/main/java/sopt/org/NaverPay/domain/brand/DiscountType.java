package sopt.org.NaverPay.domain.brand;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum DiscountType {

    TEN_PERCENT("10%"),
    DOUBLE_BENEFIT("더블혜택"),
    TEN_THOUSAND_WON("1만원");

    private final String value;
}
