package sopt.org.NaverPay.service.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.NaverPay.controller.payment.dto.response.PaymentResponseDto;
import sopt.org.NaverPay.controller.point.dto.response.BrandDto;
import sopt.org.NaverPay.controller.point.dto.response.PointResponseDto;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.point.Point;
import sopt.org.NaverPay.domain.point.PointType;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.global.exception.CustomException;
import sopt.org.NaverPay.global.exception.ErrorType;
import sopt.org.NaverPay.repository.point.PointRepository;
import sopt.org.NaverPay.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PointService {

    private final PointRepository pointRepository;
    private final UserRepository userRepository;

    public PointResponseDto getPoint(Long userId) {
        User user = findUserById(userId);

        // basic 포인트 총합
        int basicPoint = 0;
        List<Point> basicPointList = pointRepository.findByUserAndPointType(user, PointType.BASIC);
        for (Point point : basicPointList) {
            basicPoint += point.getSaving();
        }

        // 멤버십 포인트 총합
        int membershipPoint = 0;
        List<Point> membershipPointList = pointRepository.findByUserAndPointType(user, PointType.MEMBERSHIP);
        for (Point point : membershipPointList) {
            membershipPoint += point.getSaving();
        }

        // 리뷰 포인트 총합
        int reviewPoint = 0;
        List<Point> reviewPointList = pointRepository.findByUserAndPointType(user, PointType.REVIEW);
        for (Point point : reviewPointList) {
            reviewPoint += point.getSaving();
        }

        // 결제수단 포인트 총합
        int paymentPoint = 0;
        List<Point> paymentMethodPointList = pointRepository.findByUserAndPointType(user, PointType.PAYMENT_METHOD);
        for (Point point : paymentMethodPointList) {
            paymentPoint += point.getSaving();
        }

        // userId = 1인 유저가 결제한 point 내역의 브랜드들
        List<Point> pointList = pointRepository.findByUser(user);
        // user - 1, brand - 1, saving 2000, creadAT
        // user - 1, bread - 2, saving 3000, creadAT
        //..
        // TODO 3개만 뽑아야 한다면 어떤 기준으로 해야 하는지
        List<BrandDto> brandDtoList = new ArrayList<>();
        for (Point point : pointList) {
            BrandDto brandDto = BrandDto.of(point.getBrand(), point);
            brandDtoList.add(brandDto);
        }

        return PointResponseDto.of(user, basicPoint, membershipPoint, paymentPoint, reviewPoint, brandDtoList);

    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorType.NOT_FOUND_USER)
        );
    }

}
