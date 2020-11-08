package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.AccountDetail;
import com.crudApi.CrudApi.model.AccountNum;
<<<<<<< HEAD
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = AccountDetail.class,idClass = AccountNum.class)
public interface AccountDetailRepo {

        List<AccountDetail> findAllByAccNo(String AccNo);
        List<AccountDetail> findAll();
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepo  extends JpaRepository<AccountDetail, AccountNum> {

        void deleteByAccNo(String AccNo);
>>>>>>> 73b9ec9fe464c3d6b312b09b500033a5adaa7bf5

}
