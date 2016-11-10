package com.mtsmda.souvenir0911.repository;

import com.mtsmda.souvenir0911.model.Souvenir;
import com.mtsmda.spring.helper.response.CommonResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MTSMDA on 09.11.2016.
 */
@Repository("souvenirRepositoryImpl")
public class SouvenirRepositoryImpl implements SouvenirRepository {

    @Override
    public CommonResponse<Boolean> insert(Souvenir tObject) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> update(Souvenir tObject) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> delete(Souvenir tObject) {
        return null;
    }

    @Override
    public CommonResponse<Souvenir> getById(Integer id) {
        return null;
    }

    @Override
    public CommonResponse<List<Souvenir>> getAll() {
        return null;
    }

}