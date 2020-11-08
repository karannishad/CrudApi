package com.crudApi.CrudApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Employee {
    @Id
    private Long id;
    private String name_me;
    private String age;
    private LocalDateTime timestamp;
    @OneToOne
    AccountDetail accountDetail;

    public Employee() {
    }

    public Employee(Long id, String name_me, String age, LocalDateTime timestamp, AccountDetail accountDetail) {

        this.id = id;
        this.name_me = name_me;
        this.age = age;
        this.timestamp = timestamp;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }
}
