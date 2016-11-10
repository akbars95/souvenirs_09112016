package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.ParentTest;
import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.souvenir0911.model.SouvenirCategory;
import com.mtsmda.souvenir0911.model.SouvenirPhoto;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_ERROR;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by dminzat on 11/10/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirPhotoRepositoryImplTest extends ParentTest {

    @Autowired
    @Qualifier("souvenirPhotoRepositoryImpl")
    private SouvenirPhotoRepository souvenirPhotoRepository;

    @Test
    public void test1001Init(){
        assertNotNull(souvenirPhotoRepository);
    }


    @Test
    public void test1002Insert(){
        /*SouvenirPhoto souvenirPhoto
        CommonResponse<Boolean> insert = souvenirPhotoRepository.insert(souvenirCategory);
        assertNotNull(insert);
        assertTrue(insert.getObject());
        assertEquals(insert.getCode(), CommonResponse.REPOSITORY_SUCCESS);

        insert = souvenirCategoryRepository.insert(souvenirCategory);
        assertFalse(insert.getObject());
        assertNotNull(insert.getMessageErrorDescription());
        assertEquals(insert.getCode(), REPOSITORY_ERROR);

        insert = souvenirCategoryRepository.insert(null);
        assertFalse(insert.getObject());
        assertNotNull(insert.getMessageErrorDescription());
        assertEquals(insert.getCode(), REPOSITORY_ERROR);*/
    }
}