package njuics.demos.petsalon;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import njuics.demos.petsalon.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}