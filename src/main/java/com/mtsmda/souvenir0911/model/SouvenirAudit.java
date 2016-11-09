package com.mtsmda.souvenir0911.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/9/2016.
 */
public class SouvenirAudit implements Serializable {

    private Souvenir souvenir;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastUpdatedDateTime;

    public SouvenirAudit() {

    }

    public SouvenirAudit(Souvenir souvenir, LocalDateTime createdDateTime, LocalDateTime lastUpdatedDateTime) {
        this.souvenir = souvenir;
        this.createdDateTime = createdDateTime;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public Souvenir getSouvenir() {
        return souvenir;
    }

    public void setSouvenir(Souvenir souvenir) {
        this.souvenir = souvenir;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }
}