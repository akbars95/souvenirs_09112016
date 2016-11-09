package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.model.SouvenirCategory;
import com.mtsmda.spring.helper.StandardRepository;

/**
 * Created by dminzat on 11/9/2016.
 */
public interface SouvenirCategoryRepository extends StandardRepository<SouvenirCategory> {

    String T_SOUVENIR_CATEGORIES = "souvenir_categories";
    String T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY_ID = "souvenir_category_id";
    String T_SOUVENIR_CATEGORIES_F_SOUVENIR_CATEGORY = "souvenir_category";

}