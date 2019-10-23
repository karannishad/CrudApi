package com.crudApi.CrudApi.controller;

import com.crudApi.CrudApi.Repository.AccountDetailRepo;
import com.crudApi.CrudApi.Repository.EmployeeRepository;
import com.crudApi.CrudApi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountDetailRepo accountDetailRepo;
    @PostMapping(path = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertObject(@RequestBody Employee employee)
    {
        
        employeeRepository.save(employee);
        return new ResponseEntity<Object>(employee,HttpStatus.OK);
    }

    @GetMapping(path = "/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getObject()
    {
        return new ResponseEntity<Object>(employeeRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getObjectById(@RequestParam("id") String id)
    {
        List<Employee> employees=employeeRepository.findAllById(Collections.singleton(Long.parseLong(id)));
        return new ResponseEntity<Object>(employees.get(0),HttpStatus.OK);
    }

    @PutMapping(path = "/update", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateObject(@RequestBody Employee employee
    )
    {
        employeeRepository.save(employee);
        return new ResponseEntity<Object>(employee,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteObject(@RequestParam("id") String id)
    {
        employeeRepository.deleteById(Long.parseLong(id));
        return new ResponseEntity<Object>("Employee deleted with id "+id,HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteqq")
    public void getAccount(){
        accountDetailRepo.deleteByAccNo("1");
    }


}
