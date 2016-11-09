package com.mtsmda.souvenir0911.rowmapper;

import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.souvenir0911.model.SouvenirCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mtsmda.souvenir0911.repository.SouvenirRepository.*;

import static com.mtsmda.spring.helper.helper.RowMapperHelper.*;
/**
 * Created by dminzat on 11/9/2016.
 */
public class SouvenirRowMapper implements RowMapper<Souvenir> {

    @Override
    public Souvenir mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Souvenir(get(rs.getInt(T_SOUVENIRS_F_SOUVENIR_ID)),
                new SouvenirCategory(get(rs.getInt(T_SOUVENIRS_F_SOUVENIR_CATEGORY_ID))),
                get(rs.getString(T_SOUVENIRS_F_SOUVENIR_NAME)),
                get(rs.getString(T_SOUVENIRS_F_SOUVENIR_DESCRIPTION)),
                get(rs.getBoolean(T_SOUVENIRS_F_SOUVENIR_VISIBILITY)),
                get(rs.getDouble(T_SOUVENIRS_F_SOUVENIR_PRICE)),
                get(rs.getInt(T_SOUVENIRS_F_SOUVENIR_COUNT_DAY_TO_ORDER)));
    }
}