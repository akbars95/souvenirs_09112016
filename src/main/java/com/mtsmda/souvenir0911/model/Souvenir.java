package com.mtsmda.souvenir0911.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dminzat on 11/9/2016.
 */
public class Souvenir implements Serializable{

    private Integer souvenirId;
    private SouvenirCategory souvenirCategory;
    private String souvenirName;
    private String souvenirDescription;
    private Boolean souvenirVisibility;
    private SouvenirAudit souvenirAudit;
    private Double souvenirPrice;
    private Integer souvenirCountDayToOrder;
    private List<SouvenirPhoto> souvenirPhotos;

    public Souvenir() {

    }

    public Integer getSouvenirId() {
        return souvenirId;
    }

    public void setSouvenirId(Integer souvenirId) {
        this.souvenirId = souvenirId;
    }

    public SouvenirCategory getSouvenirCategory() {
        return souvenirCategory;
    }

    public void setSouvenirCategory(SouvenirCategory souvenirCategory) {
        this.souvenirCategory = souvenirCategory;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String souvenirName) {
        this.souvenirName = souvenirName;
    }

    public String getSouvenirDescription() {
        return souvenirDescription;
    }

    public void setSouvenirDescription(String souvenirDescription) {
        this.souvenirDescription = souvenirDescription;
    }

    public Boolean getSouvenirVisibility() {
        return souvenirVisibility;
    }

    public void setSouvenirVisibility(Boolean souvenirVisibility) {
        this.souvenirVisibility = souvenirVisibility;
    }

    public SouvenirAudit getSouvenirAudit() {
        return souvenirAudit;
    }

    public void setSouvenirAudit(SouvenirAudit souvenirAudit) {
        this.souvenirAudit = souvenirAudit;
    }

    public Double getSouvenirPrice() {
        return souvenirPrice;
    }

    public void setSouvenirPrice(Double souvenirPrice) {
        this.souvenirPrice = souvenirPrice;
    }

    public Integer getSouvenirCountDayToOrder() {
        return souvenirCountDayToOrder;
    }

    public void setSouvenirCountDayToOrder(Integer souvenirCountDayToOrder) {
        this.souvenirCountDayToOrder = souvenirCountDayToOrder;
    }

    public List<SouvenirPhoto> getSouvenirPhotos() {
        return souvenirPhotos;
    }

    public void setSouvenirPhotos(List<SouvenirPhoto> souvenirPhotos) {
        this.souvenirPhotos = souvenirPhotos;
    }
}