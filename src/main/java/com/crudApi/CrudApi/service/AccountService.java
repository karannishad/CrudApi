package com.crudApi.CrudApi.service;

import com.crudApi.CrudApi.model.AccountDetail;

import java.util.List;
import java.util.Optional;


public interface AccountService {

    List<AccountDetail> findAll();
    List<AccountDetail> findAllByAccNo(String accNo);

    public Optional<String> findAccIdByAccount(String accNo);
}
