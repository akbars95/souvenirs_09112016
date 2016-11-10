package com.mtsmda.souvenir0911.repository;

import com.mtsmda.helper.ExceptionMessageHelper;
import com.mtsmda.helper.ListHelper;
import com.mtsmda.helper.ObjectHelper;
import com.mtsmda.souvenir0911.model.SouvenirPhoto;
import com.mtsmda.souvenir0911.rowmapper.SouvenirPhotoRowMapper;
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
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_SUCCESS;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirPhotoRepositoryImpl")
public class SouvenirPhotoRepositoryImpl extends ParentRepository implements SouvenirPhotoRepository {

    private static final Logger LOGGER = Logger.getLogger(SouvenirPhotoRepositoryImpl.class);

    @Override
    public CommonResponse<Boolean> insert(SouvenirPhoto tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID, tObject.getSouvenir().getSouvenirId());
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_NAME, tObject.getSouvenirPhotoName());
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_PATH, tObject.getSouvenirPhotoPath());
        return insert(insertGenerate(T_SOUVENIRS_PHOTO, getListWithData(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID, T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_NAME, T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_PATH)), params, LOGGER);
    }

    @Override
    public CommonResponse<Boolean> update(SouvenirPhoto tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_PATH, tObject.getSouvenirPhotoPath());
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_NAME, tObject.getSouvenirPhotoName());
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_ID, tObject.getSouvenir().getSouvenirId());
        return update(updateGenerate(T_SOUVENIRS_PHOTO, getListWithData(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_PATH, T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_NAME, T_SOUVENIRS_PHOTO_F_SOUVENIR_ID),
                T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID), params, LOGGER);
    }

    @Override
    public CommonResponse<Boolean> delete(SouvenirPhoto tObject) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(tObject, LOGGER);
        if (!booleanCommonResponse.getObject()) {
            return booleanCommonResponse;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID, tObject.getSouvenirPhotoId());
        return delete(deleteGenerate(T_SOUVENIRS_PHOTO, T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID), params, LOGGER);
    }

    @Override
    public CommonResponse<SouvenirPhoto> getById(Integer id) {
        CommonResponse<Boolean> booleanCommonResponse = checkInputObject(id, LOGGER);
        if (booleanCommonResponse.getCode().equals(REPOSITORY_ERROR)) {
            return new CommonResponse<>(null, REPOSITORY_ERROR, booleanCommonResponse.getMessageErrorDescription());
        }
        SouvenirPhoto souvenirPhoto = null;
        try {
            setQuery(selectById(T_SOUVENIRS_PHOTO, T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID));
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID, id);
            LOGGER.info("query - " + getQuery());
            souvenirPhoto = namedParameterJdbcTemplate.queryForObject(getQuery(), params, new SouvenirPhotoRowMapper());
            if (ObjectHelper.objectIsNull(souvenirPhoto)) {
                setMessageForLogger("return souvenirCategory is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirPhoto, REPOSITORY_SUCCESS, null);
    }

    @Override
    public CommonResponse<List<SouvenirPhoto>> getAll() {
        List<SouvenirPhoto> souvenirPhotos = null;
        try {
            setQuery(selectAll(T_SOUVENIRS_PHOTO));
            LOGGER.info("query - " + getQuery());
            souvenirPhotos = namedParameterJdbcTemplate.query(getQuery(), new LinkedHashMap<>(), new SouvenirPhotoRowMapper());
            if (ListHelper.listIsNullOrEmpty(souvenirPhotos)) {
                setMessageForLogger("return souvenirPhotos is null!");
                LOGGER.error(getMessageForLogger());
                return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
            }
        } catch (Exception e) {
            setMessageForLogger(ExceptionMessageHelper.exceptionDescription(e));
            LOGGER.error(getMessageForLogger());
            return new CommonResponse<>(null, REPOSITORY_ERROR, getMessageForLogger());
        }
        return new CommonResponse<>(souvenirPhotos, REPOSITORY_SUCCESS, null);
    }

}