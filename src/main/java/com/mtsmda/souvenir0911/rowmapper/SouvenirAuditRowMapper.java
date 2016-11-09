package com.mtsmda.souvenir0911.rowmapper;

import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.souvenir0911.model.SouvenirAudit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mtsmda.souvenir0911.repository.SouvenirAuditRepository.*;
import static com.mtsmda.spring.helper.helper.RowMapperHelper.*;

/**
 * Created by MTSMDA on 09.11.2016.
 */
public class SouvenirAuditRowMapper implements RowMapper<SouvenirAudit> {
    @Override
    public SouvenirAudit mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SouvenirAudit(new Souvenir(get(rs.getInt(T_SOUVENIRS_AUDIT_F_SOUVENIR_ID))),
                get(rs.getTimestamp(T_SOUVENIRS_AUDIT_F_CREATED_DATETIME)).toLocalDateTime(),
                get(rs.getTimestamp(T_SOUVENIRS_AUDIT_F_LAST_UPDATE_DATETIME).toLocalDateTime()));
    }
}
