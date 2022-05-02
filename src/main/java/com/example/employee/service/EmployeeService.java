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

        if (employeeValidator.validateEmployee(employeeDto)) {
            Employee newEmployeeAfterMapping = employeeMapping.employeeMapping(employeeDto);
            Employee newEmployeeAfterSave = employeeRepository.save(newEmployeeAfterMapping);
            return mapStructMapper.toEmployeeDto(newEmployeeAfterSave);
        } else System.out.println("Недопустимые данные EmployeeDto");
        return null;
    }
//
//    public EmployeeDto getEmployeeById(Long id) {
//
//        Employee employee = employeeRepository.findById(id).orElse(null);
//        return mapStructMapper.toEmployeeDto(employee);
//    }
//
//    public EmployeeDto getEmployeeDirector(Long id) {
//        Employee employee = employeeRepository.findById(id).orElse(null);
//
//        Department department = employee.getDepartment();
//        List<Employee> employeeList = department.getEmployeeList();
//
//        Employee director = null;
//        for (Employee employee1 : employeeList) {
//            if (employee1.isDirector()) {
//                director = employee1;
//                break;
//            }
//        }
//        return mapStructMapper.toEmployeeDto(director);
//    }
//
//    @Transactional
//    public void dismissalEmployee(Long id, LocalDate date) {
//
//        Employee employee = employeeRepository.nativeFindEmployeeById(id);
//
//        // проверяем, что дата увольнения больше даты приема на работу
//        if (date.isAfter(employee.getDateOfEmployment())) {
//            employee.setDateOfDismissal(date);
//        }
//
//        employeeRepository.updateEmployeeDismissalDate(id, date);
//    }
//
//    public List<EmployeeDto> getEmployeeByName(String name) {
//        List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeDto> employeesForSearch = new ArrayList<>();
//        for (Employee employee : employees) {
//            if (employee.getName().equals(name)) {
//                employeesForSearch.add(mapStructMapper.toEmployeeDto(employee));
//            }
//        }
//        return employeesForSearch;
//    }
//
//    @Transactional
//    @Modifying
//    public void changeEmployee(Long changedEmployeeId, EmployeeDto employeeDtoForUpdate) {
//
//        // Находим изменяемoго сотрудника
//        Employee changedEmployee = employeeRepository.findEmployeeById(changedEmployeeId);
//
//        // Валидируем вносимые изменения
//        employeeValidator.validateEmployee(employeeDtoForUpdate);
//
//        // Сетим изменения
//        employeeChanger.changeEmployee(changedEmployee, employeeDtoForUpdate);
//
//        //сохраняем изменения
//        employeeRepository.updateEmployee(changedEmployee, changedEmployeeId);
//    }
//
//    public EmployeeDto changeDepartment(Long idEmployee, Long idDepartment) {
//        // сетим новый департамент для сотрудника и переводим его в не директора
//        Employee employee = criteriaApiRepository.getById(idEmployee);
//        //Employee employee = employeeRepository.findById(idEmployee).orElse(null);
//        Department department = departmentRepository.findById(idDepartment).orElse(null);
//        Employee employeeAfterChange = employeeRepository.save(employee.setDepartment(department).setDirector(false));
//        return mapStructMapper.toEmployeeDto(employeeAfterChange);

}
