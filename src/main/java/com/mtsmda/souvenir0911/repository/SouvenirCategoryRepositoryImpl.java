package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.ExceptionMessageHelper;
import com.mtsmda.helper.ListHelper;
import com.mtsmda.helper.LocalDateTimeHelper;
import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.souvenir0911.model.SouvenirCategory;
import com.mtsmda.souvenir0911.rowmapper.SouvenirCategoryRowMapper;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.helper.ExceptionMessageHelper.exceptionDescription;
import static com.mtsmda.helper.ListHelper.getListWithData;
import static com.mtsmda.helper.QueryCreatorHelper.*;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_ERROR;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_GET_ALL;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_SUCCESS;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirCategoryRepositoryImpl")
public class SouvenirCategoryRepositoryImpl extends ParentRepository implements SouvenirCategoryRepository {

    private static final Logger LOGGER = Logger.getLogger(SouvenirAuditRepositoryImpl.class);

    @Override
    public CommonResponse<Boolean> insert(SouvenirCategory tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY, tObject.getSouvenirCategory());
        return insert(insertGenerate(T_SOUVENIR_CATEGORIES, getListWithData(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY)), params, LOGGER);
    }

    @Override
    public CommonResponse<Boolean> update(SouvenirCategory tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY, tObject.getSouvenirCategory());
        params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID, tObject.getSouvenirCategoryId());
        return update(updateGenerate(T_SOUVENIR_CATEGORIES, getListWithData(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY),
                T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID), params, LOGGER);
    }

    @Override
    public CommonResponse<Boolean> delete(SouvenirCategory tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID, tObject.getSouvenirCategoryId());
        return delete(deleteGenerate(T_SOUVENIR_CATEGORIES, T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID), params, LOGGER);
    }

    @Override
    public CommonResponse<SouvenirCategory> getById(Integer id) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(id, LOGGER);
        if (booleanCommonResponse.getCode().equals(REPOSITORY_ERROR)) {
            return new CommonResponse<>(null, REPOSITORY_ERROR, booleanCommonResponse.getMessageErrorDescription());
        }
        SouvenirCategory souvenirCategory = null;
        try {
            setQuery(selectById(T_SOUVENIR_CATEGORIES, T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID));
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID, id);
            LOGGER.info("query - " + getQuery());
            souvenirCategory = namedParameterJdbcTemplate.queryForObject(getQuery(), params, new SouvenirCategoryRowMapper());
            if (ObjectHelper.objectIsNull(souvenirCategory)) {
                setMessageForLogger("return souvenirCategory is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirCategory, REPOSITORY_SUCCESS, null);
    }

    @Override
    public CommonResponse<List<SouvenirCategory>> getAll() {
        List<SouvenirCategory> souvenirCategories = null;
        try {
            setQuery(selectAll(T_SOUVENIR_CATEGORIES));
            LOGGER.info("query - " + getQuery());
            souvenirCategories = namedParameterJdbcTemplate.query(getQuery(), new LinkedHashMap<>(), new SouvenirCategoryRowMapper());
            if (ListHelper.listIsNullOrEmpty(souvenirCategories)) {
                setMessageForLogger("return souvenirCategories is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirCategories, REPOSITORY_SUCCESS, null);
    }

}