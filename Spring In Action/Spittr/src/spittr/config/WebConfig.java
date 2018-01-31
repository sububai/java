package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="spittr.web, spittr.data")
public class WebConfig extends WebMvcConfigurerAdapter {
/*	JSP视图解析*/
  	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}
	
/*	 @Bean    
     public ITemplateResolver  templateResolver() {    
         SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();    
         templateResolver.setTemplateMode("HTML5");    
         templateResolver.setPrefix("/WEB-INF/templates/");    
         templateResolver.setSuffix(".html");    
         templateResolver.setCharacterEncoding("utf-8");
         templateResolver.setCacheable(false);    
         return templateResolver;   
     }    
     
     
     @Bean    
     public SpringTemplateEngine templateEngine(ITemplateResolver  templateResolver) {    
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();    
             templateEngine.setTemplateResolver(templateResolver);    
             return templateEngine;    
     }    
     
     
     @Bean    
//   public ViewResolver  viewResolver() {    
     public ThymeleafViewResolver  viewResolver(TemplateEngine templateEngine) {      
         ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();    
         viewResolver.setTemplateEngine(templateEngine);    
         viewResolver.setCharacterEncoding("utf-8");    
         return viewResolver;    
     }    */
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
