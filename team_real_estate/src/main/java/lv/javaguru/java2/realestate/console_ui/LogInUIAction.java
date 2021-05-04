package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.LogInService;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class LogInUIAction implements ConsoleUI {
    @DIDependency
    private LogInService logInService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        LogInRequest request = new LogInRequest(username, password);
        LogInResponse response = logInService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));

        } else if (response.isLoggedIn()) {
            System.out.println("User " + response.getUser().getUsername() + " logged in successfully");
        } else {
            System.out.println("Incorrect user data");
        }
    }
}
