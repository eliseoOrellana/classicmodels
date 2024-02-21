package io.eliseoorellana.classicmodels;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("io.eliseoorellana")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
	Environment environment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("url"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
		driverManagerDataSource.setUsername(environment.getProperty("dbusername"));
		driverManagerDataSource.setPassword(environment.getProperty("dbpassword"));
		
		return driverManagerDataSource;
	}

}
