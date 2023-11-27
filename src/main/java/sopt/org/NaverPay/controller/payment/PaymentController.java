package sopt.org.NaverPay.controller.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.NaverPay.controller.brand.dto.response.BrandDto;
import sopt.org.NaverPay.controller.payment.dto.response.DataDto;
import sopt.org.NaverPay.global.exception.ApiResponse;
import sopt.org.NaverPay.global.exception.SuccessType;
import sopt.org.NaverPay.service.payment.PaymentService;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private static final String CUSTOM_AUTH_ID = "X-Auth-id";  // 상수(static final)로 관리

    @GetMapping("/place")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<DataDto> getPlace(@RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        return ApiResponse.success(SuccessType.GET_PLACE_SUCCESS, paymentService.getPlace(userId));
    }
}
