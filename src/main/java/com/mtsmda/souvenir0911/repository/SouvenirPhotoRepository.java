package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.model.SouvenirPhoto;
import com.mtsmda.spring.helper.StandardRepository;

/**
 * Created by dminzat on 11/9/2016.
 */
public interface SouvenirPhotoRepository extends StandardRepository<SouvenirPhoto> {

    String T_SOUVENIRS_PHOTO = "souvenirs_photo";
    String T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_ID = "souvenir_photo_id";
    String T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_PATH = "souvenir_photo_path";
    String T_SOUVENIRS_PHOTO_F_SOUVENIR_PHOTO_NAME = "souvenir_photo_name";
    String T_SOUVENIRS_PHOTO_F_SOUVENIR_ID = "souvenir_id";

}