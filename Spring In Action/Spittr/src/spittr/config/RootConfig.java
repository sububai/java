package spittr.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages= {"spitter"},
		excludeFilters= {@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
		/* another MultipartResolver
		 * 
		 * CommonsMultipartResolver multipartResolver = new CommonsMutipartResolver();
		 * multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/upload"));
		 * return multipartResolver;
		 */

	}
}
