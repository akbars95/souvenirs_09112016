package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.ExceptionMessageHelper;
import com.mtsmda.helper.ListHelper;
import com.mtsmda.helper.LocalDateTimeHelper;
import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.souvenir0911.model.SouvenirAudit;
import com.mtsmda.souvenir0911.model.SouvenirCategory;
import com.mtsmda.souvenir0911.rowmapper.SouvenirAuditRowMapper;
import com.mtsmda.souvenir0911.rowmapper.SouvenirCategoryRowMapper;
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

import static com.mtsmda.helper.QueryCreatorHelper.selectAll;
import static com.mtsmda.helper.QueryCreatorHelper.selectById;
import static com.mtsmda.spring.helper.response.CommonResponse.*;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirAuditRepositoryImpl")
public class SouvenirAuditRepositoryImpl extends ParentRepository implements SouvenirAuditRepository{

    private static final Logger LOGGER = Logger.getLogger(SouvenirAuditRepositoryImpl.class);

    @Override
    public CommonResponse<Boolean> insert(SouvenirAudit tObject) {
        throw new UnsupportedOperationException("Update Operation is unsupport!");
    }

    @Override
    public CommonResponse<Boolean> update(SouvenirAudit tObject) {
        throw new UnsupportedOperationException("Update Operation is unsupport!");
    }

    @Override
    public CommonResponse<Boolean> delete(SouvenirAudit tObject) {
        throw new UnsupportedOperationException("Update Operation is unsupport!");
    }

    @Override
    public CommonResponse<SouvenirAudit> getById(Integer id) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(id, LOGGER);
        if (booleanCommonResponse.getCode().equals(REPOSITORY_ERROR)) {
            return new CommonResponse<>(null, REPOSITORY_ERROR, booleanCommonResponse.getMessageErrorDescription());
        }
        SouvenirAudit souvenirAudit = null;
        try {
            setQuery(selectById(T_SOUVENIRS_AUDIT, T_SOUVENIRS_AUDIT_F_SOUVENIR_ID));
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIRS_AUDIT_F_SOUVENIR_ID, id);
            LOGGER.info("query - " + getQuery());
            souvenirAudit = namedParameterJdbcTemplate.queryForObject(getQuery(), params, new SouvenirAuditRowMapper());
            if (ObjectHelper.objectIsNull(souvenirAudit)) {
                setMessageForLogger("return souvenirAudit is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirAudit, REPOSITORY_SUCCESS, null);
    }

    @Override
    public CommonResponse<List<SouvenirAudit>> getAll() {
        List<SouvenirAudit> souvenirAudits = null;
        try {
            setQuery(selectAll(T_SOUVENIRS_AUDIT));
            LOGGER.info("query - " + getQuery());
            souvenirAudits = namedParameterJdbcTemplate.query(getQuery(), new LinkedHashMap<>(), new SouvenirAuditRowMapper());
            if (ListHelper.listIsNullOrEmpty(souvenirAudits)) {
                setMessageForLogger("return souvenirAudits is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirAudits, REPOSITORY_SUCCESS, null);
    }
}