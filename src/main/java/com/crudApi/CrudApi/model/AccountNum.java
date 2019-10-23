package com.crudApi.CrudApi.model;

import java.io.Serializable;
import java.util.Objects;

public class AccountNum implements Serializable {
    private String accNo;
    private String accId;

    public AccountNum() {
    }

    public AccountNum(String accId) {
        this.accId = accId;
    }

    public AccountNum(String accNo, String accId) {
        this.accNo = accNo;
        this.accId = accId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNum that = (AccountNum) o;
        return Objects.equals(accNo, that.accNo) &&
                Objects.equals(accId, that.accId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNo, accId);
    }
}
