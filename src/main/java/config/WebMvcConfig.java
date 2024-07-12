package config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset("UTF-8");//인코딩방식
        resolver.setContentType("text/html; charset=UTF-8"); //던지는 파일 형식
        resolver.setPrefix("classpath:/templates/"); //classpath:  : 프로젝트 경로
        resolver.setSuffix(".html");

        registry.viewResolver(resolver);//뷰 리졸버 등록
    }
}
