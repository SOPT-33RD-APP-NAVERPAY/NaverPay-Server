package sopt.org.NaverPay.controller.point;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.NaverPay.controller.point.dto.response.PointResponseDto;
import sopt.org.NaverPay.global.exception.ApiResponse;
import sopt.org.NaverPay.global.exception.SuccessType;
import sopt.org.NaverPay.service.point.PointService;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;
    private static final String CUSTOM_AUTH_ID = "X-Auth-id";  // 상수(static final)로 관리

    @GetMapping("/point")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PointResponseDto> getPoint(@RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        return ApiResponse.success(SuccessType.GET_POINT_SUCCESS, pointService.getPoint(userId));
    }
}
