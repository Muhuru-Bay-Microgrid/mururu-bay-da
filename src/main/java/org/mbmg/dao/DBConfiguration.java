package org.mbmg.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource("file:///${HOME}/db.properties")
@ConfigurationProperties
public class DBConfiguration {

    @Value("${url}")
    private String url;
    
    @Value("${username}")
    private String username;
    
    @Value("${password}")
    private String password;


    @Bean(name = "simpleDBTemplate")
    public DataSource simpleDBTemplate() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    
}
