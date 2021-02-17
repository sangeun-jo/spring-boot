package info.thecodinglive.config;

import info.thecodinglive.controller.ExecuteTimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ExecuteTimeInterceptor executeTimeInterceptor() {
        return new ExecuteTimeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //인덱스 페이지("/")제외하고 나머지 경로에 전부 인터셉터 적용
        registry.addInterceptor(executeTimeInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/", "/assets/")
        .setCachePeriod(60 * 60 * 24 * 365) //캐시 주기 1년
        .resourceChain(true) //밑에 줄 사용할 수 있도록 설정
        .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**")); //내가 추가한 리솔버
    }

    //페이지(html 등)와 url 연결만 필요할 경우 이렇게...
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

}
