package sopt.org.NaverPay.repository.point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.org.NaverPay.domain.point.Point;
import sopt.org.NaverPay.domain.point.PointType;
import sopt.org.NaverPay.domain.user.User;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findByUser(User user);
    List<Point> findByUserAndPointType(User user, PointType pointType);

    List<Point> findTop3ByUserOrderBySavingDesc(User user);

}
