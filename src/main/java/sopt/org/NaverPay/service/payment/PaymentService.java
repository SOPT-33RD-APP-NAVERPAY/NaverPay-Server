package sopt.org.NaverPay.service.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.NaverPay.controller.payment.dto.response.BrandDto;
import sopt.org.NaverPay.controller.payment.dto.response.PaymentResponseDto;
import sopt.org.NaverPay.controller.payment.dto.response.NearByBrandDto;
import sopt.org.NaverPay.controller.payment.dto.response.OnSitePaymentBrandDto;
import sopt.org.NaverPay.domain.brand.Brand;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.global.exception.CustomException;
import sopt.org.NaverPay.global.exception.ErrorType;
import sopt.org.NaverPay.repository.brand.BrandRepository;
import sopt.org.NaverPay.repository.user.UserRepository;

import java.util.List;

@Slf4j   // 서버 로그 남기기
@Service   // 서비스 빈이다
@RequiredArgsConstructor   // private final로 선언된 필드는 자동으로 주입해줌, 편하게 빈 주입하기 위해 쓰는 어노테이션
@Transactional(readOnly = true)
public class PaymentService {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;

    public PaymentResponseDto getPlace(Long userId) {
        User user = findUserById(userId);

        // near by dto list
        List<Brand> nearByBrandList = brandRepository.findRandomSixBrands();
        List<NearByBrandDto> nearByBrandDtoList = nearByBrandList.stream().map(NearByBrandDto::of).toList();

        // brand dto list
        List<Brand> brandList = brandRepository.findRandomSixBrands();
        List<BrandDto> brandDtoList = brandList.stream().map(BrandDto::of).toList();

        // on site payment dto list
        List<Brand> onSiteBrandList = brandRepository.findRandomSixBrands();
        List<OnSitePaymentBrandDto> onSitePaymentBrandDtoList = onSiteBrandList.stream().map(OnSitePaymentBrandDto::of).toList();

        return PaymentResponseDto.of(brandDtoList, nearByBrandDtoList, onSitePaymentBrandDtoList, user);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorType.NOT_FOUND_USER)
        );
    }


}
