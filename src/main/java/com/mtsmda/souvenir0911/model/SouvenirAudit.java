package com.mtsmda.souvenir0911.model;

import com.mtsmda.manipulation.CloneableI;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/9/2016.
 */
public class SouvenirAudit implements Serializable, CloneableI<SouvenirAudit> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SouvenirAudit that = (SouvenirAudit) o;

        if (!souvenir.equals(that.souvenir)) return false;
        if (!createdDateTime.equals(that.createdDateTime)) return false;
        return lastUpdatedDateTime.equals(that.lastUpdatedDateTime);

    }

    @Override
    public int hashCode() {
        int result = souvenir.hashCode();
        result = 31 * result + createdDateTime.hashCode();
        result = 31 * result + lastUpdatedDateTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SouvenirAudit{" +
                "souvenir=" + souvenir +
                ", createdDateTime=" + createdDateTime +
                ", lastUpdatedDateTime=" + lastUpdatedDateTime +
                '}';
    }

    @Override
    public SouvenirAudit clone() {
        return new SouvenirAudit(this.getSouvenir(), this.getCreatedDateTime(), this.getLastUpdatedDateTime());
    }
}