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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SouvenirPhoto that = (SouvenirPhoto) o;

        if (!souvenirPhotoId.equals(that.souvenirPhotoId)) return false;
        if (!souvenirPhotoPath.equals(that.souvenirPhotoPath)) return false;
        if (!souvenirPhotoName.equals(that.souvenirPhotoName)) return false;
        return souvenir != null ? souvenir.equals(that.souvenir) : that.souvenir == null;

    }

    @Override
    public int hashCode() {
        int result = souvenirPhotoId.hashCode();
        result = 31 * result + souvenirPhotoPath.hashCode();
        result = 31 * result + souvenirPhotoName.hashCode();
        result = 31 * result + (souvenir != null ? souvenir.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SouvenirPhoto{" +
                "souvenirPhotoId=" + souvenirPhotoId +
                ", souvenirPhotoPath='" + souvenirPhotoPath + '\'' +
                ", souvenirPhotoName='" + souvenirPhotoName + '\'' +
                '}';
    }
}