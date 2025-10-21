package eurekaexercise.fooditem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "eurekaexercise.fooditem")
public class FooditemApplication {
    public static void main(String[] args) {
        SpringApplication.run(FooditemApplication.class, args);
    }
}
