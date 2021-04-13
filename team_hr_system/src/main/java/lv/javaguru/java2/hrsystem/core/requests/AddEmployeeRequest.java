package lv.javaguru.java2.hrsystem.core.requests;

public class AddEmployeeRequest {
    private String name;
    private String lastName;
    private int age;

    public AddEmployeeRequest(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
