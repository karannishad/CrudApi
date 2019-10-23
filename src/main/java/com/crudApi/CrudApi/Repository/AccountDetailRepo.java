package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.AccountDetail;
import com.crudApi.CrudApi.model.AccountNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountDetailRepo  extends JpaRepository<AccountDetail, AccountNum> {
    @Transactional
        void deleteByAccNo(String AccNo);

}
