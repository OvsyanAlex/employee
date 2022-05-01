package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllDepartmentEmployees(Department department);

    Employee findEmployeeById(Long id);

    @Query("select e FROM Employee e WHERE e.department = ?1")
    List<Employee> findEmployeeByDepartmentId(Department department);

    @Modifying
    @Query
    void updateEmployee(Employee changedEmployee, Long id);

    @Query(value = "select * from employees e where e.id= :id", nativeQuery = true)
    Employee nativeFindEmployeeById(Long id);

    @Modifying
    @Query(value = "UPDATE employees SET date_of_dismissal=?2 WHERE id = ?1", nativeQuery = true)
    void updateEmployeeDismissalDate(Long id, LocalDate date);
}
