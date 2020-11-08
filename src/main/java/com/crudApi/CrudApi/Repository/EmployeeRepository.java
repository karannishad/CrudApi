package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findAllByTimestampBetween(LocalDateTime startTimestamp,LocalDateTime endTimestamp);
}
