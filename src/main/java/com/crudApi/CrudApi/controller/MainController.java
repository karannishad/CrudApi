package com.crudApi.CrudApi.controller;

import com.crudApi.CrudApi.Repository.EmployeeRepository;
import com.crudApi.CrudApi.helpers.LogTime;
import com.crudApi.CrudApi.model.Employee;
import com.crudApi.CrudApi.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@CrossOrigin("*")
@RestController
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    public MainController(EmployeeRepository employeeRepository, AccountService accountService) {
        this.employeeRepository = employeeRepository;
        this.accountService = accountService;

    }

    @Autowired
    Environment environment;
    @Value("${env:dev1}")
    private String env;


    private EmployeeRepository employeeRepository;

    private AccountService accountService;


    @LogTime(name = "insert")
    @PostMapping(path = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertObject(@RequestBody Employee employee) {
        ResponseEntity.notFound().build();
        employeeRepository.save(employee);
        return new ResponseEntity<Object>(employee, HttpStatus.BAD_REQUEST);
    }


    @LogTime(name = "get")
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getObject() {

        return ResponseEntity.ok(employeeRepository.findAll());
    }


    @Cacheable("account")
    @GetMapping(path = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getObjectById(@RequestParam("id") String id) {

        return accountService.findAccIdByAccount(id).orElse(null);

    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateObject(@RequestBody Employee employee) {
        employeeRepository.save(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteObject(@RequestParam("id") String id) {
        employeeRepository.deleteById(Long.parseLong(id));

        return new ResponseEntity<Object>("Employee deleted with id " + id, HttpStatus.OK);

    }




}
