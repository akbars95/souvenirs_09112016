package com.mtsmda.souvenir0911.rowmapper;

import com.mtsmda.souvenir0911.model.SouvenirCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mtsmda.souvenir0911.repository.SouvenirCategoryRepository.*;
import static com.mtsmda.spring.helper.helper.RowMapperHelper.*;

/**
 * Created by MTSMDA on 09.11.2016.
 */
public class SouvenirCategoryRowMapper implements RowMapper<SouvenirCategory> {

    @Override
    public SouvenirCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SouvenirCategory(get(rs.getInt(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID)),
                get(rs.getString(T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY)));
    }

}