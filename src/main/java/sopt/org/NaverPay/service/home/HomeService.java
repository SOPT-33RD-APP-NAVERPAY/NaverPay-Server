package sopt.org.NaverPay.service.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.NaverPay.controller.home.dto.reponse.BrandDto;
import sopt.org.NaverPay.controller.home.dto.reponse.HomeResponseDto;
import sopt.org.NaverPay.controller.home.dto.reponse.OnsitePaymentDto;
import sopt.org.NaverPay.controller.payment.dto.response.PaymentResponseDto;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.payment.Payment;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.global.exception.CustomException;
import sopt.org.NaverPay.global.exception.ErrorType;
import sopt.org.NaverPay.repository.brand.BrandRepository;
import sopt.org.NaverPay.repository.payment.PaymentRepository;
import sopt.org.NaverPay.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final BrandRepository brandRepository;

    public HomeResponseDto getHome(Long userId) {
        User user = findUserById(userId);
        List<Payment> paymentList = paymentRepository.findByUserOrderByCreatedAt(user);
        if(paymentList.isEmpty()) {
            throw new CustomException(ErrorType.INTERNAL_SERVER_ERROR);
        }
        Payment payment = paymentList.get(0);   // 생성순으로 내림차순 정렬했을 떄 가장 위에 있는 결제 내역
        OnsitePaymentDto onsitePaymentDto = OnsitePaymentDto.of(payment.getBrand(), payment);

        // 랜덤 브랜드 4개를 찾아서 각각의 브랜드를 dto로 변환
        List<Brand> brandList = brandRepository.findRandomFourBrands();
        List<BrandDto> brandDtoList = brandList.stream().map(BrandDto::of).toList();

        return HomeResponseDto.of(user, onsitePaymentDto, brandDtoList);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorType.NOT_FOUND_USER)
        );
    }



}
