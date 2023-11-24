package sopt.org.NaverPay.repository.user;

import static sopt.org.NaverPay.global.exception.ErrorType.NOT_FOUND_USER;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.NaverPay.domain.user.User;
import sopt.org.NaverPay.global.exception.CustomException;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new CustomException(NOT_FOUND_USER)
        );
    }
}
