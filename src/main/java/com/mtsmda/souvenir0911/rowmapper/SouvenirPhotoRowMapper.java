package com.mtsmda.souvenir0911.rowmapper;

import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.souvenir0911.model.SouvenirPhoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mtsmda.souvenir0911.repository.SouvenirPhotoRepository.*;
import static com.mtsmda.spring.helper.helper.RowMapperHelper.get;

/**
 * Created by MTSMDA on 09.11.2016.
 */
public class SouvenirPhotoRowMapper implements RowMapper<SouvenirPhoto> {

    @Override
    public SouvenirPhoto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SouvenirPhoto(get(rs.getInt(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID)),
                get(rs.getString(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_PATH)),
                get(rs.getString(T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_NAME)),
                new Souvenir(get(rs.getInt(T_SOUVENIRS_PHOTO_F_SOUVENIR_ID))));
    }

}