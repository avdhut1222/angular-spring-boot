package com.verizon.dashvue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
  basePackages = "com.verizon.dashvue.common.repository.infostore",
  entityManagerFactoryRef = "infostoreEntityManager",
  transactionManagerRef = "infostoreTransactionManager"
)
public class InfostoreDatabaseConfig {

  @Autowired
  private Environment env;

  @Qualifier("infostoreEntityManager")
  @Bean
  public LocalContainerEntityManagerFactoryBean infostoreEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(infostoreDatasource());
    em.setPackagesToScan( new String[] {"com.verizon.dashvue.common.domain.infostore"});
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//    properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    em.setJpaPropertyMap(properties);
    return em;
  }

  @Qualifier("infostoreDatasource")
  @Bean
  public DataSource infostoreDatasource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("infostore.datasource.driver.class"));
    dataSource.setUrl(env.getProperty("infostore.datasource.url"));
    dataSource.setUsername(env.getProperty("infostore.datasource.username"));
    dataSource.setPassword(env.getProperty("infostore.datasource.password"));
    return dataSource;
  }

  @Qualifier("infostoreTransactionManager")
  @Bean
  public PlatformTransactionManager infostoreTransactionManager(){
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(infostoreEntityManager().getObject());
    return transactionManager;
  }
}
