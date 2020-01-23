package be.sanderdms.employer.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("be.sanderdms")
public class WebMvcConfig  implements WebMvcConfigurer{
	
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	    .addResourceHandler("/assets/images/**")
	    .addResourceLocations("/resources/tabler/assets/images/");
	    
	    registry
	    .addResourceHandler("/assets/css/**")
	    .addResourceLocations("/resources/tabler/assets/css/");
	    
	    registry
	    .addResourceHandler("/assets/fonts/**")
	    .addResourceLocations("/resources/tabler/assets/fonts/");
	    
	    registry
	    .addResourceHandler("/assets/js/**")
	    .addResourceLocations("/resources/tabler/assets/js/");
	    
	    registry
	    .addResourceHandler("/assets/plugins/**")
	    .addResourceLocations("/resources/tabler/assets/plugins/");
	    
	  }

	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		 configurer.enable();
	  }

	  


	  //https://medium.com/@skywalkerhunter/charset-challenge-for-spring-boot-thymeleaf-mysql-internationalization-7ff91b5f2dfe
	

	@Bean(name= "viewResolver")
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	  
	  

	
	
	
}
