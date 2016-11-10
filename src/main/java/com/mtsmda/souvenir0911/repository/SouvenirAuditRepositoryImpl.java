package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.LocalDateTimeHelper;
import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.souvenir0911.model.SouvenirAudit;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.helper.ExceptionMessageHelper.exceptionDescription;
import static com.mtsmda.helper.ListHelper.getListWithData;
import static com.mtsmda.helper.QueryCreatorHelper.insertGenerate;

import static com.mtsmda.spring.helper.response.CommonResponse.*;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirAuditRepositoryImpl")
public class SouvenirAuditRepositoryImpl extends ParentRepository implements SouvenirAuditRepository{

    private static final Logger LOGGER = Logger.getLogger(SouvenirAuditRepositoryImpl.class);

    @Override
    public CommonResponse<Boolean> insert(SouvenirAudit tObject) {
        try {
            if (ObjectHelper.objectIsNull(tObject)) {
                setMessageForLogger("souvenir audit is null");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
            setQuery(insertGenerate(T_SOUVENIRS_AUDIT, getListWithData(T_SOUVENIRS_AUDIT_F_SOUVENIR_ID, T_SOUVENIRS_AUDIT_F_CREATED_DATETIME
                    , T_SOUVENIRS_AUDIT_F_LAST_UPDATE_DATETIME)));
            LOGGER.info("query - " + getQuery());
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIRS_AUDIT_F_SOUVENIR_ID, tObject.getSouvenir().getSouvenirId());
            params.put(T_SOUVENIRS_AUDIT_F_CREATED_DATETIME, LocalDateTimeHelper.localDateTimeMySqlFormat(tObject.getCreatedDateTime()));
            params.put(T_SOUVENIRS_AUDIT_F_LAST_UPDATE_DATETIME, LocalDateTimeHelper.localDateTimeMySqlFormat(tObject.getLastUpdatedDateTime()));
            int update = namedParameterJdbcTemplate.update(getQuery(), params);
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

    @Override
    public CommonResponse<Boolean> update(SouvenirAudit tObject) {
        /*try {
            if (ObjectHelper.objectIsNull(tObject)) {
                setMessageForLogger("souvenir audit is null");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
            setQuery(insertGenerate(T_SOUVENIRS_AUDIT, getListWithData(T_SOUVENIRS_AUDIT_F_SOUVENIR_ID, T_SOUVENIRS_AUDIT_F_CREATED_DATETIME
                    , T_SOUVENIRS_AUDIT_F_LAST_UPDATE_DATETIME)));
            LOGGER.info("query - " + getQuery());
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIRS_AUDIT_F_SOUVENIR_ID, tObject.getSouvenir().getSouvenirId());
            params.put(T_SOUVENIRS_AUDIT_F_CREATED_DATETIME, LocalDateTimeHelper.localDateTimeMySqlFormat(tObject.getCreatedDateTime()));
            params.put(T_SOUVENIRS_AUDIT_F_LAST_UPDATE_DATETIME, LocalDateTimeHelper.localDateTimeMySqlFormat(tObject.getLastUpdatedDateTime()));
            int update = namedParameterJdbcTemplate.update(getQuery(), params);
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
        return new CommonResponse<>(true, REPOSITORY_SUCCESS, null);*/
        throw new UnsupportedOperationException("Update Operation is unsupport!");
    }

    @Override
    public CommonResponse<Boolean> delete(SouvenirAudit tObject) {
        return null;
    }

    @Override
    public CommonResponse<SouvenirAudit> getById(Integer id) {
        return null;
    }

    @Override
    public CommonResponse<List<SouvenirAudit>> getAll() {
        return null;
    }
}