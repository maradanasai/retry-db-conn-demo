package com.example.retrydbconndemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class RetryableDataSource extends AbstractDataSource {
    private static final Logger LOG = LoggerFactory.getLogger(RetryableDataSource.class);

    private final DataSource dataSource;

    public RetryableDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(multiplier = 1.3, maxDelay = 10000))
    public Connection getConnection() throws SQLException {
        LOG.info("Getting connection ...");
        return dataSource.getConnection();
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(multiplier = 1.3, maxDelay = 10000))
    public Connection getConnection(String username, String password) throws SQLException {
        LOG.info("Getting connection using credentials ...");
        return dataSource.getConnection(username, password);
    }
}