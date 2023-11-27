package sopt.org.NaverPay.controller.home;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.NaverPay.controller.home.dto.reponse.HomeResponseDto;
import sopt.org.NaverPay.global.exception.ApiResponse;
import sopt.org.NaverPay.global.exception.SuccessType;
import sopt.org.NaverPay.service.home.HomeService;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private static final String CUSTOM_AUTH_ID = "X-Auth-id";  // 상수(static final)로 관리

    @GetMapping("/")
    public ApiResponse<HomeResponseDto> getHome(@RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        return ApiResponse.success(SuccessType.GET_HOME_SUCCESS, homeService.getHome(userId));
    }
}
