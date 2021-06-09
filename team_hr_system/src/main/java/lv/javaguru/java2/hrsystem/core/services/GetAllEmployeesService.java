package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllEmployeesService {

    @Autowired
    //private EmployeeRepository employeeRepository;
    private ORMEmployeeRepository ormEmployeeRepository;

    public GetAllEmployeesResponse execute(GetAllEmployeesRequest request) {
        List<Employee> employees = ormEmployeeRepository.getAllEmployees();
        return new GetAllEmployeesResponse(employees);
    }
}
