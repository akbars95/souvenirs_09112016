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

import java.util.List;

import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_ERROR;
import static com.mtsmda.spring.helper.response.CommonResponse.REPOSITORY_SUCCESS;
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

    @Autowired
    @Qualifier("souvenirRepositoryImpl")
    private SouvenirRepository souvenirRepository;

    @Autowired
    @Qualifier("souvenirCategoryRepositoryImpl")
    private SouvenirCategoryRepository souvenirCategoryRepository;

    private static Souvenir souvenir;

    @Test
    public void test1001Init(){
        assertNotNull(souvenirPhotoRepository);
        assertNotNull(souvenirRepository);
        assertNotNull(souvenirCategoryRepository);
    }

    @Test
    public void test1002InsertSouvenir(){
        SouvenirCategory souvenirCategory = new SouvenirCategory("ate_categ_1");
        CommonResponse<Boolean> insertSouvenirCategory = souvenirCategoryRepository.insert(souvenirCategory);
        assertTrue(insertSouvenirCategory.getObject());
        assertEquals(insertSouvenirCategory.getCode(), CommonResponse.REPOSITORY_SUCCESS);
        CommonResponse<List<SouvenirCategory>> all = souvenirCategoryRepository.getAll();
        assertNotNull(all.getObject());
        assertTrue(!all.getObject().isEmpty());
        all.getObject().forEach(souvenirCategoryCurrent -> {
            if(souvenirCategory.getSouvenirCategory().equals(souvenirCategoryCurrent.getSouvenirCategory())){
                souvenirCategory.setSouvenirCategoryId(souvenirCategoryCurrent.getSouvenirCategoryId());
                return;
            }
        });
        assertNotNull(souvenirCategory.getSouvenirCategoryId());

        souvenir = new Souvenir(null, souvenirCategory, "Souvenir12345", "This is souvenir description", true,
                20.5, 2);
        CommonResponse<Boolean> insertSouvenir = souvenirRepository.insert(souvenir);
        assertNotNull(insertSouvenir.getObject());
        assertTrue(insertSouvenir.getObject());
        assertEquals(insertSouvenir.getCode(), REPOSITORY_SUCCESS);

        CommonResponse<List<Souvenir>> allSouvenirs = souvenirRepository.getAll();
        assertNotNull(allSouvenirs.getObject());
        assertFalse(allSouvenirs.getObject().isEmpty());
        allSouvenirs.getObject().forEach(souvenirCurrent -> {
            if(souvenirCurrent.getSouvenirName().equals("Souvenir12345") && souvenirCurrent.getSouvenirDescription().equals("This is souvenir description")){
                souvenir.setSouvenirId(souvenirCurrent.getSouvenirId());
                return;
            }
        });
    }

    @Test
    public void test1003Insert(){
        assertNotNull(souvenir);
        SouvenirPhoto souvenirPhoto = new SouvenirPhoto(null, "c://img.jpg", "This is photo name", souvenir);
        CommonResponse<Boolean> insertSouvenirPhoto = souvenirPhotoRepository.insert(souvenirPhoto);
        assertNotNull(insertSouvenirPhoto.getObject());
        assertTrue(insertSouvenirPhoto.getObject());
        assertEquals(insertSouvenirPhoto.getCode(), CommonResponse.REPOSITORY_SUCCESS);

        insertSouvenirPhoto = souvenirPhotoRepository.insert(null);
        assertFalse(insertSouvenirPhoto.getObject());
        assertNotNull(insertSouvenirPhoto.getMessageErrorDescription());
        assertEquals(insertSouvenirPhoto.getCode(), REPOSITORY_ERROR);
    }

    @Test
    public void test1003GetAllAndUpdate(){
        CommonResponse<List<SouvenirPhoto>> allSouvenirPhoto = souvenirPhotoRepository.getAll();
        assertNotNull(allSouvenirPhoto.getObject());
        assertTrue(!allSouvenirPhoto.getObject().isEmpty());
        assertEquals(allSouvenirPhoto.getCode(), CommonResponse.REPOSITORY_SUCCESS);

        SouvenirPhoto souvenirPhoto = new SouvenirPhoto();

        allSouvenirPhoto.getObject().forEach(current ->{

        });

        insertSouvenirPhoto = souvenirPhotoRepository.update()
        assertFalse(insertSouvenirPhoto.getObject());
        assertNotNull(insertSouvenirPhoto.getMessageErrorDescription());
        assertEquals(insertSouvenirPhoto.getCode(), REPOSITORY_ERROR);
    }
}