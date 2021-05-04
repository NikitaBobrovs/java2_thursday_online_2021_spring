package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class CreateUserValidator {

    public List<CoreError> validate(CreateUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateUsername(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateUsername(CreateUserRequest request) {
        return (request.getUsername() == null || request.getUsername().isEmpty())
                ? Optional.of(new CoreError("Username", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePassword(CreateUserRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }
}
