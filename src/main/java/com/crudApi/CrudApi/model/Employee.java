package com.crudApi.CrudApi.model;


import javax.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name_me;
    private String age;


    @OneToOne
    AccountDetail accountDetail;

    public Employee() {
    }

    public Employee(Long id, String name_me, String age) {
        this.id = id;
        this.name_me = name_me;
        this.age = age;
    }

    public Employee(Long id, String name_me, String age, AccountDetail accountDetail) {

        this.id = id;
        this.name_me = name_me;
        this.age = age;

        this.accountDetail = accountDetail;
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
