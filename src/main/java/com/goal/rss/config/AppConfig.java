package com.goal.rss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URL;

/**
 * Created by p.gharibi on 3/3/2019.
 */
@Component
public class AppConfig {

    @Bean
    URL url() {
        try {
            URL goalUrl = new URL(Dashboard.GOAL_URL_ADDRESS);
            return goalUrl;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Autowired
    @Qualifier(value = "dc")
    DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "dc")
    public DataSource dataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                .addScript("schema.sql")
                .ignoreFailedDrops(true)
                .continueOnError(true)
                .build();
        return db;
    }



}
