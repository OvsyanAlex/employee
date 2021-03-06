package com.example.employee.service;


import com.example.employee.dto.EmployeeDto;
import com.example.employee.mapping.EmployeeMapStructMapper;
import com.example.employee.mapping.EmployeeMapping;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.util.CriteriaApiRepository;
import com.example.employee.util.EmployeeChanger;
import com.example.employee.util.EmployeeValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapping employeeMapping;
    private final EmployeeValidator employeeValidator;
    private final EmployeeChanger employeeChanger;
    private final CriteriaApiRepository criteriaApiRepository;
    private final EmployeeMapStructMapper mapStructMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapping employeeMapping, EmployeeValidator employeeValidator, EmployeeChanger employeeChanger, CriteriaApiRepository criteriaApiRepository, EmployeeMapStructMapper mapStructMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapping = employeeMapping;
        this.employeeValidator = employeeValidator;
        this.employeeChanger = employeeChanger;
        this.criteriaApiRepository = criteriaApiRepository;
        this.mapStructMapper = mapStructMapper;
    }


    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //валидируем employeeDto, если валидация успешна сохраняем и возвращаем (переписать validateEmployee)
        if (employeeValidator.validateEmployee(employeeDto)) {
            Employee newEmployeeAfterMapping = employeeMapping.employeeMapping(employeeDto);
            Employee newEmployeeAfterSave = employeeRepository.save(newEmployeeAfterMapping);
            return mapStructMapper.toEmployeeDto(newEmployeeAfterSave);
        } else System.out.println("Недопустимые данные EmployeeDto");
        return null;
    }

    public EmployeeDto getEmployeeById(Long id) {
        // ищем Employee по id, если такой есть возвращаем
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            return mapStructMapper.toEmployeeDto(employee);
        } else System.out.println("Не существует сотрудника с таким Id");
        return null;
    }

    public EmployeeDto getEmployeeDirector(Long id) {
        // ищем Employee по id
        Employee employee = employeeRepository.findById(id).orElse(null);
        // проверка, что Employee существует
        if (employee == null) {
            System.out.println("Нет сотрудника с таким Id");
            return null;
        }
        // проверка Employee на директора
        if (employee.isDirector()) {
            return mapStructMapper.toEmployeeDto(employee);
        }
        //ищем Employee который является директором и состоит в той же организации->возвращаем (поменять findAll)
        List<Employee> employeeList = employeeRepository.findAll();
        Employee director = null;
        for (Employee employee1 : employeeList) {
            if (employee1.isDirector() && employee1.getDepartment().equals(employee.getDepartment())) {
                director = employee1;
                break;
            }
        }
        if (director != null) {
            return mapStructMapper.toEmployeeDto(director);
        } else System.out.println("У сотрудника нет директора");
        return null;
    }

    @Transactional
    public void dismissalEmployee(Long id, LocalDate date) {

        //находим Employee
        Employee employee = employeeRepository.nativeFindEmployeeById(id);

        // проверяем, что дата увольнения больше даты приема на работу
        if (date.isAfter(employee.getDateOfEmployment())) {
            employee.setDateOfDismissal(date);
        } else System.out.println("Дата увольнения должна быть позже даты приема на работу");

        // апдейтим дату увольнения
        employeeRepository.updateEmployeeDismissalDate(id, date);
    }

    // переписать метод с использованием @Query
    public List<EmployeeDto> getEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeesForSearch = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employeesForSearch.add(mapStructMapper.toEmployeeDto(employee));
            }
        }
        if (employeesForSearch.isEmpty()) {
            System.out.println("Нет работников с таким именем");
            return null;
        } else return employeesForSearch;
    }

    @Transactional
    @Modifying
    public void changeEmployee(Long changedEmployeeId, EmployeeDto employeeDtoForUpdate) {

        // Находим изменяемoго сотрудника
        Employee changedEmployee = employeeRepository.findEmployeeById(changedEmployeeId);

        //сетим изменения и сохраняем (написать валидацию для employeeDtoForUpdate)
        employeeRepository.save(employeeChanger.changeEmployee(changedEmployee, employeeDtoForUpdate));
    }

    // написать валидацию для departmentName
    public EmployeeDto changeDepartment(Long employeeId, String departmentName) {

        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        Employee employeeAfterUpdate = employee.setDepartment(departmentName);
        Employee employeeAfterSave = employeeRepository.save(employeeAfterUpdate);
        return mapStructMapper.toEmployeeDto(employeeAfterSave);
    }
    //переписать findAll, написать валидацию если нет запрашиваемог департамента
    public List<EmployeeDto> getEmployeesByDepartment(String departmentName) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeListResult = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getDepartment() == departmentName) {
                employeeListResult.add(mapStructMapper.toEmployeeDto(employee));
            }
        }
        return employeeListResult;
    }
}
