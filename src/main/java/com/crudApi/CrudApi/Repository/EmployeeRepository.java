package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
