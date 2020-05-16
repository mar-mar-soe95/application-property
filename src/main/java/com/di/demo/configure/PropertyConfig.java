package com.di.demo.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.di.demo.beans.FakeDataSource;
import com.di.demo.beans.FakeJmsBroker;

@Configuration 
public class PropertyConfig {

	@Value("${guru.username}")
	String username;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String dburl;
	
	@Value("${demo.jms.username}")
	String jmsUser;
	
	@Value("${demo.jms.password}")
	String jmsPassword;
	
	@Value("${demo.jms.dburl}")
	String jmsUrl;
	
	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUsername(jmsUser);
		fakeJmsBroker.setPassword(jmsPassword);
		fakeJmsBroker.setUrl(jmsUrl);
		return fakeJmsBroker;
	}
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(username);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(dburl);
		return fakeDataSource;
	}

}
