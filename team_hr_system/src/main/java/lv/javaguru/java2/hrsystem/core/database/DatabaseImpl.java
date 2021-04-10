package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.bean.Employee;

import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database{

    private Long nextIdEmployee = 1L;
    private List <Employee> employeeList = new ArrayList<>();

    @Override
    public void saveEmployee(Employee employee) {
        employee.setId(nextIdEmployee);
        nextIdEmployee++;
        employeeList.add(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}