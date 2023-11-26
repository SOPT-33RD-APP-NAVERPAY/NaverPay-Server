package sopt.org.NaverPay.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.NaverPay.domain.payment.Payment;
import sopt.org.NaverPay.domain.user.User;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByUserOrderByCreatedAt(User user);
}
