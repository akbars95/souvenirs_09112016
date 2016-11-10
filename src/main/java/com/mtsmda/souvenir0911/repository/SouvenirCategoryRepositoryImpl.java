package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.LocalDateTimeHelper;
import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.souvenir0911.model.SouvenirCategory;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.helper.ExceptionMessageHelper.exceptionDescription;
import static com.mtsmda.helper.ListHelper.getListWithData;
import static com.mtsmda.helper.QueryCreatorHelper.insertGenerate;
import static com.mtsmda.helper.QueryCreatorHelper.updateGenerate;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_ERROR;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_SUCCESS;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirCategoryRepositoryImpl")
public class SouvenirCategoryRepositoryImpl extends ParentRepository implements SouvenirCategoryRepository {

    private static final Logger LOGGER = Logger.getLogger(SouvenirAuditRepositoryImpl.class);

    @Override
    public CommonResponse<Boolean> insert(SouvenirCategory tObject) {
        try {
            if (ObjectHelper.objectIsNull(tObject)) {
                setMessageForLogger("souvenir category is null");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
            setQuery(insertGenerate(T_SOUVENIR_CATEGORIES, getListWithData(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY)));
            LOGGER.info("query - " + getQuery());
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY, tObject.getSouvenirCategory());
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
    public CommonResponse<Boolean> update(SouvenirCategory tObject) {
        try {
            if (ObjectHelper.objectIsNull(tObject)) {
                setMessageForLogger("souvenir category is null");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
            setQuery(updateGenerate(T_SOUVENIR_CATEGORIES, getListWithData(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY),
                    T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID));
            LOGGER.info("query - " + getQuery());
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY, tObject.getSouvenirCategory());
            params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID, tObject.getSouvenirCategoryId());
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
    public CommonResponse<Boolean> delete(SouvenirCategory tObject) {
        try {
            if (ObjectHelper.objectIsNull(tObject)) {
                setMessageForLogger("souvenir category is null");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(false, REPOSITORY_ERROR, getMessageForLogger());
            }
            setQuery(updateGenerate(T_SOUVENIR_CATEGORIES, getListWithData(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY),
                    T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID));
            LOGGER.info("query - " + getQuery());
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY, tObject.getSouvenirCategory());
            params.put(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID, tObject.getSouvenirCategoryId());
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
    public CommonResponse<SouvenirCategory> getById(Integer id) {
        return null;
    }

    @Override
    public CommonResponse<List<SouvenirCategory>> getAll() {
        return null;
    }

}