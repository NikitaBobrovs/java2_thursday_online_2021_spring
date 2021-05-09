package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.config.HRSystemConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class MainMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public MainMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddEmployeeUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, AddEmployeeWithTitleUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, DeleteEmployeeUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, GetAllEmployeesUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, SearchEmployeesUIAction.class));
        menuNumberToUIActionMap.put(6, findUIAction(uiActions, AddSkillUIAction.class));
        menuNumberToUIActionMap.put(7, findUIAction(uiActions, GetAllEmployeeSkillUIAction.class));
        menuNumberToUIActionMap.put(8, findUIAction(uiActions, SearchEmployeesBySkillUIAction.class));
        menuNumberToUIActionMap.put(9, findUIAction(uiActions, ExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }


    private int getUserOption() {
        System.out.printf("Enter 1 to %d menu option to execute:\n", menuNumberToUIActionMap.size());
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }


    private boolean checkUserInput(int input) {
        return input > 0 && input <= menuNumberToUIActionMap.size();
    }


    private void performAction(int userOption) {
        UIAction uiAction = menuNumberToUIActionMap.get(userOption);
        if (uiAction != null) {
            uiAction.execute();
        }
    }


    private void printMenu() {
        System.out.println("Select menu option: ");
        menuNumberToUIActionMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }


    public void run() {
        while (true) {
            printMenu();
            int option = getUserOption();
            if (checkUserInput(option)) {
                performAction(option);
            } else {
                System.out.println("Invalid menu option entered! Please try again");
            }
        }
    }
}