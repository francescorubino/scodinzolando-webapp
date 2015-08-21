package it.scodinzolando;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "it.scodinzolando", "it.scodinzolando.repository", "it.scodinzolando.model", "it.scodinzolando.mvc", "it.scodinzolando.service" })
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories("it.scodinzolando.repository")
public class ScodinzolandoWebappApplication {

	@Bean
	public MethodInvokingJobDetailFactoryBean simpleJobDetail() {
		MethodInvokingJobDetailFactoryBean result = new MethodInvokingJobDetailFactoryBean();
		result.setTargetBeanName("downloaderFacebookData");
		result.setTargetMethod("downloadData");
		return result;
	}

	@Bean
	public SimpleTriggerFactoryBean simpleTrigger() {
		SimpleTriggerFactoryBean result = new SimpleTriggerFactoryBean();
		MethodInvokingJobDetailFactoryBean simpleJobDetail = simpleJobDetail();
		result.setJobDetail(simpleJobDetail.getObject());
		result.setStartDelay(1000);
		result.setRepeatInterval(3600000);
		return result;
	}

	@Bean
	public SchedulerFactoryBean factory() {
		SchedulerFactoryBean result = new SchedulerFactoryBean();
		result.setJobDetails(simpleJobDetail().getObject());
		result.setTriggers(simpleTrigger().getObject());
		return result;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/scodinzolando");
		dataSource.setUsername("scodinzolando");
		dataSource.setPassword("scodinzolando");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "it.scodinzolando.model" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScodinzolandoWebappApplication.class, args);
	}
}
