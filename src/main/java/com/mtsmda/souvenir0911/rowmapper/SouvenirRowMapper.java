package com.mtsmda.souvenir0911.rowmapper;

import com.mtsmda.souvenir0911.model.Souvenir;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mtsmda.souvenir0911.repository.SouvenirRepository.T_SOUVENIRS_F_SOUVENIR_ID;

/**
 * Created by dminzat on 11/9/2016.
 */
public class SouvenirRowMapper implements RowMapper<Souvenir> {

    @Override
    public Souvenir mapRow(ResultSet rs, int rowNum) throws SQLException {
        Souvenir souvenir = new Souvenir();

        try{
            souvenir.setSouvenirId(rs.getInt(T_SOUVENIRS_F_SOUVENIR_ID));
        }
        catch (Exception e){
            souvenir.setSouvenirId(null);
        }

        return souvenir;
    }
}