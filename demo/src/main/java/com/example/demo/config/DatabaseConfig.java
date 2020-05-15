package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/otp?characterEncoding=utf8&useSSL=true&verifyServerCertificate=false");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "123456" );
        return dataSource;
    }


}
