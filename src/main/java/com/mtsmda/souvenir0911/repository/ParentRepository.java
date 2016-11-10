package com.mtsmda.souvenir0911.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by dminzat on 11/10/2016.
 */
public class ParentRepository {

    private String messageForLogger;
    private String query;

    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected String getMessageForLogger() {
        return messageForLogger;
    }

    protected void setMessageForLogger(String messageForLogger) {
        this.messageForLogger = messageForLogger;
    }

    protected String getQuery() {
        return query;
    }

    protected void setQuery(String query) {
        this.query = query;
    }
}