/*
 * package com.example.demo1.configs;
 * 
 * import java.util.HashMap;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Primary; import
 * org.springframework.core.env.Environment; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager;
 * 
 * import com.zaxxer.hikari.HikariConfig; import
 * com.zaxxer.hikari.HikariDataSource;
 * 
 * @Configuration
 * 
 * @EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory",
 * transactionManagerRef = "mysqldbTransactionManager", basePackages =
 * "com.example.db.repos") public class MySqlConfig {
 * 
 * @Autowired private Environment env;
 * 
 * @Primary
 * 
 * @Bean(name = "mysqlDataSource") public DataSource mysqlDataSource() { final
 * HikariConfig config = new HikariConfig();
 * config.setJdbcUrl(env.getProperty("app.mysql.datasource.url"));
 * config.setUsername(env.getProperty("app.mysql.datasource.username"));
 * config.setPassword(env.getProperty("app.mysql.datasource.password"));
 * 
 * config.setConnectionTimeout(Integer.parseInt(env.getProperty(
 * "app.mysql.datasource.connection-timeout")));
 * config.setMinimumIdle(Integer.parseInt(env.getProperty(
 * "app.mysql.datasource.minimum-idle-connections")));
 * config.setIdleTimeout(Integer.parseInt(env.getProperty(
 * "app.mysql.datasource.connection-idle-timeout")));
 * 
 * config.addDataSourceProperty("cachePrepStmts", "true");
 * config.addDataSourceProperty("prepStmtCacheSize", "250");
 * config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
 * 
 * final HikariDataSource ds = new HikariDataSource(config);
 * 
 * ds.setMaximumPoolSize(Integer.parseInt(env.getProperty(
 * "app.mdb.datasource.maximum-pool-size")));
 * ds.setDriverClassName(env.getProperty("app.mdb.datasource.driver-class-name")
 * ); return ds;
 * 
 * 
 * }
 * 
 * @Primary
 * 
 * @Bean(name = "mysqlEntityManagerFactory") public
 * LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean();
 * em.setDataSource(mysqlDataSource()); em.setPackagesToScan(new String[] {
 * "com.example.db.domains" });
 * 
 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
 * em.setJpaVendorAdapter(vendorAdapter); HashMap<String, Object> properties =
 * new HashMap<String, Object>(); properties.put("hibernate.hbm2ddl.auto",
 * env.getProperty("hibernate.hbm2ddl.auto"));
 * properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
 * em.setJpaPropertyMap(properties);
 * 
 * return em;
 * 
 * }
 * 
 * @Primary
 * 
 * @Bean(name = "mysqldbTransactionManager") public PlatformTransactionManager
 * mysqldbTransactionManager() { JpaTransactionManager transactionManager = new
 * JpaTransactionManager();
 * transactionManager.setEntityManagerFactory(mysqlEntityManagerFactory().
 * getObject()); return transactionManager; }
 * 
 * 
 * 
 * }
 */