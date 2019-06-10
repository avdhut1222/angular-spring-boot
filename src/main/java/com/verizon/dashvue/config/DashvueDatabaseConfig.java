package com.verizon.dashvue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Mankavale, Avdhut
 * Created: 9/24/2018 2:42 PM
 */

@Configuration
@EnableJpaRepositories(
  basePackages = {"com.verizon.dashvue.common.repository.dashvue"},
  entityManagerFactoryRef = "dashvueEntityManager",
  transactionManagerRef = "dashvueTransactionManager"
)
public class DashvueDatabaseConfig {

  @Autowired
  private Environment env;

  @Qualifier("dashvueEntityManager")
  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean dashvueEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dashvueDatasource());
    em.setPackagesToScan( new String[] {"com.verizon.dashvue.common.domain.dashvue"});
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//    properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    em.setJpaPropertyMap(properties);

    return em;
  }

  @Qualifier("dashvueDatasource")
  @Bean
  @Primary
  public DataSource dashvueDatasource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("dashvue.datasource.driver.class"));
    dataSource.setUrl(env.getProperty("dashvue.datasource.url"));
    dataSource.setUsername(env.getProperty("dashvue.datasource.username"));
    dataSource.setPassword(env.getProperty("dashvue.datasource.password"));

    return dataSource;
  }

  @Qualifier("dashvueTransactionManager")
  @Bean
  @Primary
  public PlatformTransactionManager dashvueTransactionManager(){
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(dashvueEntityManager().getObject());

    return transactionManager;
  }
}
