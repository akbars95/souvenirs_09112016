package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.spring.helper.StandardRepository;

/**
 * Created by dminzat on 11/9/2016.
 */
public interface SouvenirRepository extends StandardRepository<Souvenir>{

    String T_SOUVENIRS = "souvenirs";
    String T_SOUVENIRS_F_SOUVENIR_ID = "souvenir_id";
    String T_SOUVENIRS_F_SOUVENIR_CATEGORY_ID = "souvenir_category_id";
    String T_SOUVENIRS_F_SOUVENIR_NAME = "souvenir_name";
    String T_SOUVENIRS_F_SOUVENIR_DESCRIPTION = "souvenir_description";
    String T_SOUVENIRS_F_SOUVENIR_VISIBILITY = "souvenir_visibility";
    String T_SOUVENIRS_F_SOUVENIR_PRICE = "souvenir_price";
    String T_SOUVENIRS_F_SOUVENIR_COUNT_DAY_TO_ORDER = "souvenir_count_day_to_order";

}