package hello.my_projectV1;

import hello.my_projectV1.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(Config.class)
@SpringBootApplication
public class MyProjectV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectV1Application.class, args);
	}

}
