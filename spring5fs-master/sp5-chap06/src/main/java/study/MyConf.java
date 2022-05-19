package study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {
	
	@Bean
	public AA aa() {
		return new AA();
	}
	
	@Bean(initMethod = "initMe", destroyMethod = "desMe")
	public BB bb() {
		return new BB();
	}
}
