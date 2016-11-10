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

    public Souvenir(Integer souvenirId) {
        this.souvenirId = souvenirId;
    }

    public Souvenir(Integer souvenirId, SouvenirCategory souvenirCategory, String souvenirName, String souvenirDescription, Boolean souvenirVisibility, Double souvenirPrice, Integer souvenirCountDayToOrder) {
        this.souvenirId = souvenirId;
        this.souvenirCategory = souvenirCategory;
        this.souvenirName = souvenirName;
        this.souvenirDescription = souvenirDescription;
        this.souvenirVisibility = souvenirVisibility;
        this.souvenirPrice = souvenirPrice;
        this.souvenirCountDayToOrder = souvenirCountDayToOrder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Souvenir souvenir = (Souvenir) o;

        if (souvenirId != null ? !souvenirId.equals(souvenir.souvenirId) : souvenir.souvenirId != null) return false;
        if (souvenirCategory != null ? !souvenirCategory.equals(souvenir.souvenirCategory) : souvenir.souvenirCategory != null)
            return false;
        if (!souvenirName.equals(souvenir.souvenirName)) return false;
        if (!souvenirDescription.equals(souvenir.souvenirDescription)) return false;
        if (!souvenirVisibility.equals(souvenir.souvenirVisibility)) return false;
        if (souvenirAudit != null ? !souvenirAudit.equals(souvenir.souvenirAudit) : souvenir.souvenirAudit != null)
            return false;
        if (!souvenirPrice.equals(souvenir.souvenirPrice)) return false;
        if (!souvenirCountDayToOrder.equals(souvenir.souvenirCountDayToOrder)) return false;
        return souvenirPhotos != null ? souvenirPhotos.equals(souvenir.souvenirPhotos) : souvenir.souvenirPhotos == null;

    }

    @Override
    public int hashCode() {
        int result = souvenirId != null ? souvenirId.hashCode() : 0;
        result = 31 * result + (souvenirCategory != null ? souvenirCategory.hashCode() : 0);
        result = 31 * result + souvenirName.hashCode();
        result = 31 * result + souvenirDescription.hashCode();
        result = 31 * result + souvenirVisibility.hashCode();
        result = 31 * result + (souvenirAudit != null ? souvenirAudit.hashCode() : 0);
        result = 31 * result + souvenirPrice.hashCode();
        result = 31 * result + souvenirCountDayToOrder.hashCode();
        result = 31 * result + (souvenirPhotos != null ? souvenirPhotos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "souvenirId=" + souvenirId +
                ", souvenirName='" + souvenirName + '\'' +
                ", souvenirDescription='" + souvenirDescription + '\'' +
                ", souvenirVisibility=" + souvenirVisibility +
                ", souvenirAudit=" + souvenirAudit +
                ", souvenirPrice=" + souvenirPrice +
                ", souvenirCountDayToOrder=" + souvenirCountDayToOrder +
                '}';
    }



}