package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//AndrejsB
@Component
public class RemoveDishValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RemoveDishRequest request) {
        validateNameToRemove(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateNameToRemove(RemoveDishRequest request){
        return (request.name() == null || request.name().length() == 0)
                ? Optional.of(new CoreError("name", "Must not be empty"))
                : Optional.empty();
    }
}
