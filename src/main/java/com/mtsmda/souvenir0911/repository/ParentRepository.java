package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

import static com.mtsmda.helper.ExceptionMessageHelper.exceptionDescription;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_ERROR;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_SUCCESS;

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


    protected <T> CommonResponse<Boolean> checkInputObject(T tObject, Logger LOGGER){
        if (ObjectHelper.objectIsNull(tObject)) {
            setMessageForLogger("souvenir category is null");
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(true, REPOSITORY_SUCCESS, null);
    }

    protected CommonResponse<Boolean> insert(String query, Map<String, Object> params, Logger LOGGER){
        try {
            LOGGER.info("query - " + query);
            int update = namedParameterJdbcTemplate.update(query, params);
            if (update <= 0) {
                setMessageForLogger("error with insert!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(true, REPOSITORY_SUCCESS, null);
    }

    protected CommonResponse<Boolean> update(String query, Map<String, Object> params, Logger LOGGER){
        try {
            LOGGER.info("query - " + query);
            int update = namedParameterJdbcTemplate.update(query, params);
            if (update <= 0) {
                setMessageForLogger("error with update!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(true, REPOSITORY_SUCCESS, null);
    }

    protected CommonResponse<Boolean> delete(String query, Map<String, Object> params, Logger LOGGER) {
        try {
            LOGGER.info("query - " + query);
            int update = namedParameterJdbcTemplate.update(query, params);
            if (update <= 0) {
                setMessageForLogger("error with delete!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(true, REPOSITORY_SUCCESS, null);
    }

}