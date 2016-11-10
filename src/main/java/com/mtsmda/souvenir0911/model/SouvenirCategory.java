package com.mtsmda.souvenir0911.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dminzat on 11/9/2016.
 */
public class SouvenirCategory implements Serializable {

    private Integer souvenirCategoryId;
    private String souvenirCategory;
    private List<Souvenir> souvenirs;

    public SouvenirCategory() {

    }

    public SouvenirCategory(Integer souvenirCategoryId) {
        this.souvenirCategoryId = souvenirCategoryId;
    }

    public SouvenirCategory(String souvenirCategory) {
        this.souvenirCategory = souvenirCategory;
    }

    public SouvenirCategory(Integer souvenirCategoryId, String souvenirCategory) {
        this.souvenirCategoryId = souvenirCategoryId;
        this.souvenirCategory = souvenirCategory;
    }

    public Integer getSouvenirCategoryId() {
        return souvenirCategoryId;
    }

    public void setSouvenirCategoryId(Integer souvenirCategoryId) {
        this.souvenirCategoryId = souvenirCategoryId;
    }

    public String getSouvenirCategory() {
        return souvenirCategory;
    }

    public void setSouvenirCategory(String souvenirCategory) {
        this.souvenirCategory = souvenirCategory;
    }

    public List<Souvenir> getSouvenirs() {
        return souvenirs;
    }

    public void setSouvenirs(List<Souvenir> souvenirs) {
        this.souvenirs = souvenirs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SouvenirCategory that = (SouvenirCategory) o;

        if (!souvenirCategoryId.equals(that.souvenirCategoryId)) return false;
        if (!souvenirCategory.equals(that.souvenirCategory)) return false;
        return souvenirs != null ? souvenirs.equals(that.souvenirs) : that.souvenirs == null;

    }

    @Override
    public int hashCode() {
        int result = souvenirCategoryId.hashCode();
        result = 31 * result + souvenirCategory.hashCode();
        result = 31 * result + (souvenirs != null ? souvenirs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SouvenirCategory{" +
                "souvenirCategoryId=" + souvenirCategoryId +
                ", souvenirCategory='" + souvenirCategory + '\'' +
                '}';
    }
}