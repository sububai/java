package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")
public class ExpressiveConfig {
	@Autowired
	Environment env;
	
	@Bean
	public BlankDisc disc() {
		return new BlankDisc(env.getProperty("disc.title", "Rattle and Hum"),
				env.getProperty("disc.artist", "U2"));
	}
}
