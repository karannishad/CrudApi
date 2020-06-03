package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.AccountDetail;
import com.crudApi.CrudApi.model.AccountNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepo  extends JpaRepository<AccountDetail, AccountNum> {

        void deleteByAccNo(String AccNo);

}
