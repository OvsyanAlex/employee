package com.example.employee.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDto {
    @Schema(description = "Фамилия сотрудника", example = "Иванов")
    private String surname;
    @Schema(description = "Имя сотрудника", example = "Иван")
    private String name;
    @Schema(description = "Отчество сотрудника", example = "Иванович")
    private String middleName;
    @Schema(description = "Пол", example = "жор")
    private String gender;
    @Schema(description = "День рождения", example = "1980-11-12")
    private LocalDate birthDay;
    @Schema(description = "Телефон", example = "+7(963)8147-865")
    private String phone;
    @Schema(description = "Электронная почта", example = "email@company.com")
    private String email;
    @Schema(description = "Дата приема на работу", example = "2020-07-23")
    private LocalDate dateOfEmployment;
    @Schema(description = "Дата увольнения", example = "2021-07-23")
    private LocalDate dateOfDismissal;
    @Schema(description = "Должность", example = "инженер")
    private String post;
    @Schema(description = "Оклад", example = "60000")
    private int salary;
    @Schema(description = "Директор департамента", example = "false")
    private boolean director;
    @Schema(description = "Департамент", example = "департамент испытаний")
    private String department;

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", dateOfDismissal=" + dateOfDismissal +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", director=" + director +
                ", department='" + department + '\'' +
                '}';
    }
}
