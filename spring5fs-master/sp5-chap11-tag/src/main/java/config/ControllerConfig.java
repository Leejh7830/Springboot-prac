package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import form.FormController;

@Configuration
@ComponentScan({"board","home"})
public class ControllerConfig {

	@Bean
	public FormController loginController() {
		return new FormController();
	}
	
	@Bean
	public DriverManagerDataSource dmd() {
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost:3306/spring5");
		dmd.setUsername("root");
		dmd.setPassword("1234");
		return dmd;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dmd());
		ssfb.setMapperLocations(
				new PathMatchingResourcePatternResolver()
				.getResources("classpath*:mappers/*Mappers.xml")
			);
		return ssfb.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactoryBean());
	}
}
