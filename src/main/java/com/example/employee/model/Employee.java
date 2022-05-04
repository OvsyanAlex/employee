package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

//@NamedQuery(name = "Employee.findAllDepartmentEmployees",
//        query = "SELECT e FROM Employee e WHERE e.department = ?1")
//@NamedQuery(name = "Employee.findEmployeeById",
//        query = "SELECT e FROM Employee e WHERE e.id = ?1")
//@NamedQuery(name = "Employee.updateEmployee",
//        query = "UPDATE Employee e SET e=?1 WHERE e.id = ?2")
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Employee {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @Pattern(regexp = "[А-Яа-я-]")
    @Column(name = "surname")
    private String surname;
    @Getter
    @Setter
    @Column(name = "name")
    @Pattern(regexp = "[А-Яа-я-]")
    private String name;
    @Getter
    @Setter
    @Column(name = "middle_name")
    @Pattern(regexp = "[А-Яа-я-]")
    private String middleName;
    @Getter
    @Setter
    @Column(name = "gender")
    private String gender;
    @Getter
    @Setter
    @Past
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate BirthDay;
    @Getter
    @Setter
    @Column(name = "phone")
    @Pattern(regexp = "[+0-9()[:blank:]-]")
    private String phone;
    @Getter
    @Setter
    @Email
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "date_of_employment")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEmployment;
    @Getter
    @Setter
    @FutureOrPresent
    @Column(name = "date_of_dismissal")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfDismissal;
    @Getter
    @Setter
    @Column(name = "post")
    private String post;
    @Getter
    @Setter
    @Positive
    @Column(name = "salary")
    private int salary;
    @Getter
    @Setter
    @Column(name = "director")
    private boolean director;
    @Getter
    @Setter
    @Column(name = "department_name")
    private String department;
}
