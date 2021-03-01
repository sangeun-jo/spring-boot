package sej.springexample.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sej.springexample.service.ConsoleHello;
import sej.springexample.service.HelloService;

@Configuration
@ConditionalOnClass(HelloService.class)
public class HelloServiceAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService() {
        return new ConsoleHello();
    }
}
