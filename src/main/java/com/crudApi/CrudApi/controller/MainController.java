package com.crudApi.CrudApi.controller;

import com.crudApi.CrudApi.Repository.EmployeeRepository;
import com.crudApi.CrudApi.helpers.LogTime;
import com.crudApi.CrudApi.model.AccountDetail;
import com.crudApi.CrudApi.model.Employee;
import com.crudApi.CrudApi.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@RestController
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);



    @Autowired
    Environment environment;
    @Value("${env:dev1}")
    private String env;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private AccountService accountService;


    @LogTime(name = "insert")
    @Resource
    @PostMapping(path = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertObject(@RequestBody Employee employee) {
        employee.setTimestamp(LocalDateTime.now());

        employeeRepository.save(employee);
        return new ResponseEntity<Object>(employee, HttpStatus.OK);
    }


    @LogTime(name = "get")
    @Cacheable("account")
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getObject() {

        List<AccountDetail> accountDetails = accountService.findAll();
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
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

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getD() {
        Optional<String> s = Optional.empty();
        return s.get();
    }


}
