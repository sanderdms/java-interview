package be.sanderdms.employer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
	    .addResourceHandler("/images/**")
	    .addResourceLocations("/resources/img/");
	    
	    registry
	    .addResourceHandler("/css/**")
	    .addResourceLocations("/resources/css/");
	    
	  }

	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	      configurer.enable();
	  }
	

	@Bean(name= "viewResolver")
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
