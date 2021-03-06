package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.model.SouvenirAudit;
import com.mtsmda.spring.helper.StandardRepository;

/**
 * Created by dminzat on 11/9/2016.
 */
public interface SouvenirAuditRepository extends StandardRepository<SouvenirAudit> {

    String T_SOUVENIRS_AUDIT = "souvenirs_audit";
    String T_SOUVENIRS_AUDIT_F_SOUVENIR_ID = "souvenir_id";
    String T_SOUVENIRS_AUDIT_F_CREATED_DATETIME = "created_datetime";
    String T_SOUVENIRS_AUDIT_F_LAST_UPDATE_DATETIME = "last_update_datetime";

}