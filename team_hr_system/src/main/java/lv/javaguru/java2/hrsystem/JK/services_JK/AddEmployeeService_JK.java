package lv.javaguru.java2.hrsystem.JK.services_JK;

import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;

public class AddEmployeeService_JK {
    private final Database database;

    public AddEmployeeService_JK(Database database) {
        this.database = database;
    }

    public void add(String firstName, String lastName, int age) {
        database.saveEmployee(new Employee(firstName, lastName, age));
    }
}