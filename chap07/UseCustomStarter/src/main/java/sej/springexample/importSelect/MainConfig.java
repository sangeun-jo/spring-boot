package sej.springexample.importSelect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoMyModule("someValue")
public class MainConfig {
    @Bean
    public UseMyBean useMean() {
        return new UseMyBean();
    }
}
