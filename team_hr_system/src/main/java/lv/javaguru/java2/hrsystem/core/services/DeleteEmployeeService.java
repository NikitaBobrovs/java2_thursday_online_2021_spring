package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.DeleteEmployeeRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteEmployeeService {

    @Autowired
   // private EmployeeRepository employeeRepository;
    private ORMEmployeeRepository ormEmployeeRepository;
    @Autowired
    private DeleteEmployeeRequestValidator validator;


    public DeleteEmployeeResponse execute(DeleteEmployeeRequest deleteEmployeeRequest) {
        List<CoreError> errors = validator.validate(deleteEmployeeRequest);
        if (!errors.isEmpty()) {
            return new DeleteEmployeeResponse(errors);
        }
        //boolean deleted = employeeRepository.deleteEmployee(deleteEmployeeRequest.getId());
        boolean deleted = ormEmployeeRepository.deleteEmployee(deleteEmployeeRequest.getId());
        return new DeleteEmployeeResponse(deleted);
    }
}