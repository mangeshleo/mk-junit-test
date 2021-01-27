package springcore_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
    public AreaCalculator getAreaCalculator() {
        return new AreaCalculator();
    }

}
