package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.ExceptionMessageHelper;
import com.mtsmda.helper.ListHelper;
import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.souvenir0911.model.SouvenirPhoto;
import com.mtsmda.souvenir0911.rowmapper.SouvenirPhotoRowMapper;
import com.mtsmda.souvenir0911.rowmapper.SouvenirRowMapper;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.helper.ListHelper.getListWithData;
import static com.mtsmda.helper.QueryCreatorHelper.*;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_ERROR;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_SUCCESS;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirRepositoryImpl")
public class SouvenirRepositoryImpl extends ParentRepository implements SouvenirRepository {

    private static final Logger LOGGER = Logger.getLogger(SouvenirRepositoryImpl.class);

    @Override
    public CommonResponse<Boolean> insert(Souvenir tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIRS_F_SOUVENIR_CATEGORY_ID, tObject.getSouvenirCategory().getSouvenirCategoryId());
        params.put(T_SOUVENIRS_F_SOUVENIR_NAME, tObject.getSouvenirName());
        params.put(T_SOUVENIRS_F_SOUVENIR_DESCRIPTION, tObject.getSouvenirDescription());
        params.put(T_SOUVENIRS_F_SOUVENIR_VISIBILITY, tObject.getSouvenirVisibility());
        params.put(T_SOUVENIRS_F_SOUVENIR_PRICE, tObject.getSouvenirPrice());
        params.put(T_SOUVENIRS_F_SOUVENIR_COUNT_DAY_TO_ORDER, tObject.getSouvenirCountDayToOrder());
        return insert(insertGenerate(T_SOUVENIRS, getListWithData(T_SOUVENIRS_F_SOUVENIR_CATEGORY_ID, T_SOUVENIRS_F_SOUVENIR_NAME,
                T_SOUVENIRS_F_SOUVENIR_DESCRIPTION, T_SOUVENIRS_F_SOUVENIR_VISIBILITY, T_SOUVENIRS_F_SOUVENIR_PRICE,
                T_SOUVENIRS_F_SOUVENIR_COUNT_DAY_TO_ORDER)), params, LOGGER);
    }

    @Override
    public CommonResponse<Boolean> update(Souvenir tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIRS_F_SOUVENIR_CATEGORY_ID, tObject.getSouvenirCategory().getSouvenirCategoryId());
        params.put(T_SOUVENIRS_F_SOUVENIR_NAME, tObject.getSouvenirName());
        params.put(T_SOUVENIRS_F_SOUVENIR_DESCRIPTION, tObject.getSouvenirDescription());
        params.put(T_SOUVENIRS_F_SOUVENIR_VISIBILITY, tObject.getSouvenirVisibility());
        params.put(T_SOUVENIRS_F_SOUVENIR_PRICE, tObject.getSouvenirPrice());
        params.put(T_SOUVENIRS_F_SOUVENIR_COUNT_DAY_TO_ORDER, tObject.getSouvenirCountDayToOrder());
        params.put(T_SOUVENIRS_F_SOUVENIR_ID, tObject.getSouvenirCountDayToOrder());
        return update(updateGenerate(T_SOUVENIRS, getListWithData(T_SOUVENIRS_F_SOUVENIR_CATEGORY_ID, T_SOUVENIRS_F_SOUVENIR_NAME,
                T_SOUVENIRS_F_SOUVENIR_DESCRIPTION, T_SOUVENIRS_F_SOUVENIR_VISIBILITY, T_SOUVENIRS_F_SOUVENIR_PRICE,
                T_SOUVENIRS_F_SOUVENIR_COUNT_DAY_TO_ORDER), T_SOUVENIRS_F_SOUVENIR_ID), params, LOGGER);
    }

    @Override
    public CommonResponse<Boolean> delete(Souvenir tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIRS_F_SOUVENIR_ID, tObject.getSouvenirId());
        return delete(deleteGenerate(T_SOUVENIRS, T_SOUVENIRS_F_SOUVENIR_ID), params, LOGGER);
    }

    @Override
    public CommonResponse<Souvenir> getById(Integer id) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(id, LOGGER);
        if (booleanCommonResponse.getCode().equals(REPOSITORY_ERROR)) {
            return new CommonResponse<>(null, REPOSITORY_ERROR, booleanCommonResponse.getMessageErrorDescription());
        }
        Souvenir souvenir = null;
        try {
            setQuery(selectById(T_SOUVENIRS, T_SOUVENIRS_F_SOUVENIR_ID));
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIRS_F_SOUVENIR_ID, id);
            LOGGER.info("query - " + getQuery());
            souvenir = namedParameterJdbcTemplate.queryForObject(getQuery(), params, new SouvenirRowMapper());
            if (ObjectHelper.objectIsNull(souvenir)) {
                setMessageForLogger("return souvenir is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenir, REPOSITORY_SUCCESS, null);
    }

    @Override
    public CommonResponse<List<Souvenir>> getAll() {
        List<Souvenir> souvenirs = null;
        try {
            setQuery(selectAll(T_SOUVENIRS));
            LOGGER.info("query - " + getQuery());
            souvenirs = namedParameterJdbcTemplate.query(getQuery(), new LinkedHashMap<>(), new SouvenirRowMapper());
            if (ListHelper.listIsNullOrEmpty(souvenirs)) {
                setMessageForLogger("return souvenirs is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirs, REPOSITORY_SUCCESS, null);
    }

}