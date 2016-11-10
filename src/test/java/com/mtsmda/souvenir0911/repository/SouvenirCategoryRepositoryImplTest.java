package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.ParentTest;
import com.mtsmda.souvenir0911.model.SouvenirCategory;
import com.mtsmda.spring.helper.Run;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by dminzat on 11/10/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Profile({"production"})
public class SouvenirCategoryRepositoryImplTest extends ParentTest{

    @Autowired
    @Qualifier("souvenirCategoryRepositoryImpl")
    private SouvenirCategoryRepository souvenirCategoryRepository;

    @Test
    public void test1001Init(){
        assertNotNull(souvenirCategoryRepository);
    }

    @Test
    public void test1002Insert(){
        SouvenirCategory souvenirCategory = new SouvenirCategory("cat1");
        CommonResponse<Boolean> insert = souvenirCategoryRepository.insert(souvenirCategory);
        assertNotNull(insert);
        assertTrue(insert.getObject());
        assertEquals(insert.getCode(), CommonResponse.REPOSITORY_SUCCESS);
        try{
            insert = souvenirCategoryRepository.insert(souvenirCategory);
        }
        catch (DuplicateKeyException e){
            assertNotNull(e.getMessage());
        }

        try{
            insert = souvenirCategoryRepository.insert(null);
        }
        catch (RuntimeException e){
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void test1003UpdateAndGetAll(){
        CommonResponse<List<SouvenirCategory>> all = souvenirCategoryRepository.getAll();
        assertNotNull(all.getObject());
        assertFalse(all.getObject().isEmpty());
        assertTrue(all.getObject().size() == 1);
        SouvenirCategory souvenirCategory = all.getObject().get(0);
        souvenirCategory.setSouvenirCategory(souvenirCategory.getSouvenirCategory() + "_new");
        CommonResponse<Boolean> update = souvenirCategoryRepository.update(souvenirCategory);
        assertTrue(update.getObject());
        assertEquals(update.getCode(), CommonResponse.REPOSITORY_SUCCESS);
    }

    @Test
    public void test1004GetByIndex(){
        CommonResponse<List<SouvenirCategory>> all = souvenirCategoryRepository.getAll();
        assertNotNull(all.getObject());
        assertFalse(all.getObject().isEmpty());
        assertTrue(all.getObject().size() == 1);
        SouvenirCategory souvenirCategory = all.getObject().get(0);
        CommonResponse<SouvenirCategory> byId = souvenirCategoryRepository.getById(souvenirCategory.getSouvenirCategoryId());
        assertNotNull(byId.getObject());
        assertEquals(byId.getCode(), CommonResponse.REPOSITORY_SUCCESS);
        assertEquals(all.getObject().get(0), byId.getObject());
    }

    @Test
    public void test1005Delete(){
        CommonResponse<List<SouvenirCategory>> all = souvenirCategoryRepository.getAll();
        assertNotNull(all.getObject());
        assertFalse(all.getObject().isEmpty());
        assertTrue(all.getObject().size() == 1);
        SouvenirCategory souvenirCategory = all.getObject().get(0);
        CommonResponse<Boolean> delete = souvenirCategoryRepository.delete(souvenirCategory);
        assertTrue(delete.getObject());
        all = souvenirCategoryRepository.getAll();
        assertNull(all.getObject());
    }

}