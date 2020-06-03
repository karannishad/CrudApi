package com.crudApi.CrudApi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Employee {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name_me;
    private String age;
    @OneToOne
    AccountDetail accountDetail;

    public Employee(Long id, String name_me, String age,  AccountDetail accountDetail) {
        this.id = id;
        this.name_me = name_me;
        this.age = age;
        this.accountDetail = accountDetail;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_me() {
        return name_me;
    }

    public void setName_me(String name_me) {
        this.name_me = name_me;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }
}
