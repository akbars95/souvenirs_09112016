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
}