package sej.springexample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = {"sej.springexample.service"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Service.class)})
@Import(MyBatisConfig.class)
public class ServiceConfig {
}
