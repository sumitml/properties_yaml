package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;

@Configuration
//Spring 4 property source
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
//Spring 5 changes
@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {
	
	@Value("${sk.username}")
	String user;
	@Value("${sk.password}")
	String password;
	@Value("${sk.dburl}")
	String url;
	@Value("${sk.jms.username}")
	String JMS_UserName;
	@Value("${sk.jms.password}")
	String JMS_Password;
	@Value("${sk.jms.url}")
	String dburl;
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
	@Bean
	public FakeJmsBroker fakeJMSBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUser(JMS_UserName);
		fakeJmsBroker.setPassword(JMS_Password);
		fakeJmsBroker.setUrl(dburl);
		return fakeJmsBroker;
	}
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfig = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfig;
	}

}
