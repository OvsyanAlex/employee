package com.example.employee.util;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CriteriaApiRepository implements CustomRepositoryCriteriaApi{
    @PersistenceContext
    private EntityManager entityManager;

    public Employee getById(Long employeeId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("id"), employeeId));

        Query query = entityManager.createQuery(criteriaQuery);

        List<Employee> employeeList = query.getResultList();

        return employeeList.get(0);
    }
}
