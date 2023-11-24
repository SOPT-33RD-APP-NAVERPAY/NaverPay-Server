package sopt.org.NaverPay.domain.point;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum PointType {

        BASIC("기본"),
        MEMBERSHIP("멤버쉽"),
        REVIEW("리뷰"),
        PAYMENT_METHOD("결제수단");

        private final String value;
}

