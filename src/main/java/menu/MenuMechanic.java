package menu;

import model.Mechanic;
import persistence.RepositoryMechanic;

import java.util.Scanner;

public class MenuMechanic {
    RepositoryMechanic repositoryMechanic = new RepositoryMechanic();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all mechanics //todo");
        System.out.println("2: Update mechanics work phone number by mechanics id");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    //todo
                    //menuListAllMechanics
                    break;
                case 2:
                    menuUpdateMechanicWorkPhone(input);
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid option.");
                    menuOptions(input);
            } // End of switch
        } while (userChoice != 100);
    }

    private void menuUpdateMechanicWorkPhone(Scanner input) {
        System.out.println("Type the mechanics ID");
        int id = input.nextInt();

        Mechanic result = repositoryMechanic.findById(id);
        if (result == null) {
            System.out.println("\nMechanic not found!\n");
            menuOptions(input);
        } else {
            System.out.println("Type the new work phone number");
            String newWorkNumber = input.next();
            repositoryMechanic.updateMechanicWorkPhone(id, newWorkNumber);
        }
    }
}
