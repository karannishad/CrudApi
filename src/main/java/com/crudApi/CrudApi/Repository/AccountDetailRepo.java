package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.AccountDetail;
import com.crudApi.CrudApi.model.AccountNum;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = AccountDetail.class,idClass = AccountNum.class)
public interface AccountDetailRepo {

        List<AccountDetail> findAllByAccNo(String AccNo);
        List<AccountDetail> findAll();

}
