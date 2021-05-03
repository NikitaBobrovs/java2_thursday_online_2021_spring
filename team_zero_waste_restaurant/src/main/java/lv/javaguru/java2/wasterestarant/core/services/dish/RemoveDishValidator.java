package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//AndrejsB
@DIComponent
public class RemoveDishValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RemoveDishRequest request) {
        validateNameToRemove(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateNameToRemove(RemoveDishRequest request){
        return (request.getDishNameToRemove() == null || request.getDishNameToRemove().isEmpty())
                ? Optional.of(new CoreError("nameToRemove", "Must not be empty"))
                : Optional.empty();
    }
}
