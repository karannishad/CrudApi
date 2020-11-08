package com.crudApi.CrudApi.service.impl;

import com.crudApi.CrudApi.Repository.AccountDetailRepo;
import com.crudApi.CrudApi.model.AccountDetail;
import com.crudApi.CrudApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDetailRepo accountDetailRepo;

    StopWatch stopWatch = new StopWatch();

    @Override
    public List<AccountDetail> findAll() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        return accountDetailRepo.findAll();
    }

    @Override
    public List<AccountDetail> findAllByAccNo(String accNo) {
        List<AccountDetail> accountDetails = new ArrayList<>();
        for (AccountDetail accountDetail : findAll()) {
            if (accountDetail.getAccNo().equals(accNo)) accountDetails.add(accountDetail);
        }
        return accountDetails;
    }

    public Optional<String> findAccIdByAccount(String accNo){
        if(findAllByAccNo(accNo).size()!=0){
            return Optional.of(findAllByAccNo(accNo).get(0).getAccId());
        }
        return Optional.empty();
    }


}
