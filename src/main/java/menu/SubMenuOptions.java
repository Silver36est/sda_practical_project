package menu;

import java.util.Scanner;

public class SubMenuOptions {

    private MenuCustomer menuCustomer;

    public SubMenuOptions() {
        this.menuCustomer = new MenuCustomer();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the menu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Sub Menu - Customer");
        System.out.println("2: Sub Menu - <NAME>");
        System.out.println("3: Sub Menu - <NAME>");
        System.out.println("4: Sub Menu - <NAME>");
        System.out.println("100 - Quit");
        System.out.println("\n/***************************************************/");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;

        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuCustomer.menuChoice(input);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 100:
                    input.close();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid option");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 100);
        System.out.println("Closing system...");
        System.out.println("Thank you. Good bye.");
    }
}
