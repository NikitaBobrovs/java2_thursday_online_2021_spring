package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetEmployeesByTitleResponse;

import java.util.List;

public class GetEmployeesByTitleService {
    private final Database database;

    public GetEmployeesByTitleService(Database database) {
        this.database = database;
    }

    public GetEmployeesByTitleResponse execute(GetEmployeesByTitleRequest getEmployeesByTitleRequest) {
        List<Employee> employeesByTitle = database.getEmployeesByTitle(getEmployeesByTitleRequest.getEmployeeTitle());
        return new GetEmployeesByTitleResponse(employeesByTitle);
    }
}