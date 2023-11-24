package sopt.org.NaverPay.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.NaverPay.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
