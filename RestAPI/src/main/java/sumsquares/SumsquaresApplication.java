package sumsquares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "controller", "service" })
@SpringBootApplication
public class SumsquaresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SumsquaresApplication.class, args);
	}
}
