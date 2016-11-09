package com.mtsmda.souvenir0911.model;

import java.io.Serializable;

/**
 * Created by dminzat on 11/9/2016.
 */
public class SouvenirPhoto implements Serializable {

    private Integer souvenirPhotoId;
    private String souvenirPhotoPath;
    private String souvenirPhotoName;
    private Souvenir souvenir;

    public SouvenirPhoto() {

    }

    public SouvenirPhoto(Integer souvenirPhotoId, String souvenirPhotoPath, String souvenirPhotoName, Souvenir souvenir) {
        this.souvenirPhotoId = souvenirPhotoId;
        this.souvenirPhotoPath = souvenirPhotoPath;
        this.souvenirPhotoName = souvenirPhotoName;
        this.souvenir = souvenir;
    }

    public Integer getSouvenirPhotoId() {
        return souvenirPhotoId;
    }

    public void setSouvenirPhotoId(Integer souvenirPhotoId) {
        this.souvenirPhotoId = souvenirPhotoId;
    }

    public String getSouvenirPhotoPath() {
        return souvenirPhotoPath;
    }

    public void setSouvenirPhotoPath(String souvenirPhotoPath) {
        this.souvenirPhotoPath = souvenirPhotoPath;
    }

    public String getSouvenirPhotoName() {
        return souvenirPhotoName;
    }

    public void setSouvenirPhotoName(String souvenirPhotoName) {
        this.souvenirPhotoName = souvenirPhotoName;
    }

    public Souvenir getSouvenir() {
        return souvenir;
    }

    public void setSouvenir(Souvenir souvenir) {
        this.souvenir = souvenir;
    }
}