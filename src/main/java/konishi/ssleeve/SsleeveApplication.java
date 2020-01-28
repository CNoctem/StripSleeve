package konishi.ssleeve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SsleeveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsleeveApplication.class, args);
	}

}
