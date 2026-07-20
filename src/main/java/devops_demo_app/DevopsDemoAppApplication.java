package devops_demo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevopsDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsDemoAppApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "🚀 Welcome to DevOps CI/CD Pipeline! Built by Awinash Kamble";
    }
}