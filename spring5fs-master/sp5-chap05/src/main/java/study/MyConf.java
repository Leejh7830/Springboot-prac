package study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

import studybean.AA;
import studynobean.NoBean;

@Configuration
@ComponentScan(basePackages = {"studybean"},
	excludeFilters = 
	@Filter(type = FilterType.ANNOTATION, classes = NoBean.class)
)
	
public class MyConf {
	
	@Bean
	public AA aa() {
		return new AA();
	}
}
