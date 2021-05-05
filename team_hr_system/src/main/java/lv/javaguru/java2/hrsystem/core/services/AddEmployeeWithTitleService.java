package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeWithTitleValidator;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;

import java.util.List;

@DIComponent
public class AddEmployeeWithTitleService {
    @DIDependency
    private Database database;
    @DIDependency
    private AddEmployeeWithTitleValidator validator;

  /*  public AddEmployeeWithTitleService(Database database) {
        this.database = database;
    }*/

    public AddEmployeeWithTitleResponse execute(AddEmployeeWithTitleRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddEmployeeWithTitleResponse(errors);
        }

        Employee employee = new Employee(
                request.getName(), request.getLastName(), request.getAge(), EmployeeTitle.valueOf(request.getTitle()));
        database.saveEmployee(employee);
        return new AddEmployeeWithTitleResponse(employee);
    }
}