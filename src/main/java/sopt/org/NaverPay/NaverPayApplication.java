package sopt.org.NaverPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NaverPayApplication
{

	public static void main(String[] args) {
		SpringApplication.run(NaverPayApplication.class, args);
	}

}
