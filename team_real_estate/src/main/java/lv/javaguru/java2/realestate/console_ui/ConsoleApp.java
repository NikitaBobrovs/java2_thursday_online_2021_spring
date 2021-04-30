package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private final Map<Integer, ConsoleUI> menuNumberToActionMap;

    private final static ApplicationContext beans = new ApplicationContext();

    public ConsoleApp() {

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(0, beans.getBean(ExitUIAction.class));
        menuNumberToActionMap.put(1, beans.getBean(CreateUserUIAction.class));
        menuNumberToActionMap.put(2, beans.getBean(LogInUIAction.class));
        menuNumberToActionMap.put(3, beans.getBean(CreateOfferUIAction.class));
        menuNumberToActionMap.put(4, beans.getBean(GetAllOffersUIAction.class));
        menuNumberToActionMap.put(5, beans.getBean(DeleteOfferUIAction.class));
        menuNumberToActionMap.put(6, beans.getBean(DeleteUserUIAction.class));
        menuNumberToActionMap.put(7, beans.getBean(SearchOffersUIAction.class));
    }

    public void run() {
        System.out.println("Welcome! \n ");

        while (true) {
            printMenu();
            int userSelectedMenuNumber = getNumberFromUser();
            executeOption(userSelectedMenuNumber);
        }
    }

    private int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private void printMenu() {
        System.out.print("Choose available option : \n" + "\n" +
                "0  = Exit \n" +
                "1 = Create account \n" +
                "2 = Log in \n" +
                "3 = Create offer \n" +
                "4 = View all offers\n" +
                "5 = Delete offer\n" +
                "6 = Delete account\n" +
                "7 = Search offers\n" +
                "\n");
        System.out.println("Please enter menu number: ");
    }


    private void executeOption(int userMenuChoice) {
        ConsoleUI consoleUI = menuNumberToActionMap.get(userMenuChoice);
        if (consoleUI != null) {
            consoleUI.execute();
        } else {
            System.out.println("Entered number does not exist in menu.");
        }
    }
}

