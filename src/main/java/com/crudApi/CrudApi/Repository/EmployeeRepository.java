package com.crudApi.CrudApi.Repository;

import com.crudApi.CrudApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
=======
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findAllByTimestampBetween(LocalDateTime startTimestamp,LocalDateTime endTimestamp);
>>>>>>> d8d23ff...  clean up and prometheus custom configs
}
