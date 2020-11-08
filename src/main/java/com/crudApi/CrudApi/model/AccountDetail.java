package com.crudApi.CrudApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(AccountNum.class)
public class AccountDetail {
    @Id
    private String accNo;

    @Id
    private String accId;

    @Override
    public String toString() {
        return "AccountDetail{" +
                "accNo='" + accNo + '\'' +
                ", accId='" + accId + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    private String Name;

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
