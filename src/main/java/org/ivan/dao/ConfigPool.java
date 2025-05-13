package org.ivan.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConfigPool {
    private static HikariDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/highschool");
            config.setUsername("root");
            config.setPassword("Sandia4you");
            
            config.setMaximumPoolSize(5);
            config.setMinimumIdle(5);
            config.setIdleTimeout(30000);
            config.setMaxLifetime(1800000);
            config.setConnectionTimeout(30000);
            
            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }

    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
