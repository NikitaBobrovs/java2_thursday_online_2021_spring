package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchDishesRequestValidatorTest {
    SearchDishesRequestValidator victim = new SearchDishesRequestValidator();

    @Test
    public void test1Validate() {
        SearchDishesRequest request1 = new SearchDishesRequest("Pizza", "Pizza", 12.95);
        List<CoreError> errors = victim.validate(request1);
        assertEquals(0, errors.size());
    }

    @Test
    public void test2Validate() {
        SearchDishesRequest request2 = new SearchDishesRequest("Pumpkin soup", "", 4.95);
        List<CoreError> errors = victim.validate(request2);
        assertEquals(1, errors.size());
    }

    @Test
    public void test3Validate() {
        SearchDishesRequest request3 = new SearchDishesRequest("", "Soup", 4.95);
        List<CoreError> errors = victim.validate(request3);
        assertEquals(1, errors.size());
    }

    @Test
    public void test4Validate() {
        SearchDishesRequest request4 = new SearchDishesRequest("Pumpkin soup", "", -4.95);
        List<CoreError> errors = victim.validate(request4);
        assertEquals(2, errors.size());
    }

    @Test
    public void test5Validate() {
        SearchDishesRequest request4 = new SearchDishesRequest("", "", 4.95);
        List<CoreError> errors = victim.validate(request4);
        assertEquals(2, errors.size());
    }
}