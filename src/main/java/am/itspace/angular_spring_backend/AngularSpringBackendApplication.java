package am.itspace.angular_spring_backend;

import am.itspace.angular_spring_backend.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@Import(CorsConfig.class)
@CrossOrigin(origins = "http://localhost:4200")
public class AngularSpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngularSpringBackendApplication.class, args);
    }

}
