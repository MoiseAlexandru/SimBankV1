import java.util.Scanner;

public class Menu {
    public static Scanner input = new Scanner(System.in);
    public void displayIntro() {
        System.out.println("Acesta este proiectul meu la PAO.");
        System.out.println("Pentru a afisa comenzile disponibile, scrieti show. Pentru a merge inapoi, scrieti back");
        displayFirstMenu();
    }
    private void displayOptions(String[] options) {
        for(String option: options)
            System.out.println(option);
    }
    private void displayFirstMenu() {
        String[] options = {"card", "show", "back"};
        System.out.print("> ");
        String str = input.nextLine();
        String[] enteredInput = str.split(" ", 0);
        if(enteredInput.length > 1) {
            displayFirstMenu();
            return;
        }
        if(str.equals("show")) {
            displayOptions(options);
            displayFirstMenu();
            return;
        }
        if(str.equals("card")) {
            displayCardMenu();
            return;
        }
        if(str.equals("back")) {
            displayFirstMenu();
            return;
        }
        System.out.println("Incorrect command.");
        displayFirstMenu();
    }
    private void displayCardMenu() {
        String[] options = {"show cards", "delete card", "activate card", "deactivate card", "show", "back"};
        System.out.print("card> ");
        String str = input.nextLine();
        String[] enteredInput = str.split(" ", 0);
        if(enteredInput.length == 1) {
            if(str.equals("show")) {
                displayOptions(options);
                displayCardMenu();
                return;
            }
            if(str.equals("back")) {
                displayFirstMenu();
                return;
            }
            System.out.println("Incorrect command.");
            displayCardMenu();
            return;
        }
        if(enteredInput.length == 2) {
            if(enteredInput[0].equals("show") && enteredInput[1].equals("cards")) {
                CardRepository.getAllCards();
                displayCardMenu();
                return;
            }
            if(enteredInput[0].equals("activate") && enteredInput[1].equals("card")) {
                displayTakeActionCardMenu("activate");
                return;
            }
            if(enteredInput[0].equals("deactivate") && enteredInput[1].equals("card")) {
                displayTakeActionCardMenu("deactivate");
                return;
            }
            if(enteredInput[0].equals("delete") && enteredInput[1].equals("card")) {
                displayTakeActionCardMenu("delete");
                return;
            }
        }
    }
    private void displayTakeActionCardMenu(String action) {
        System.out.print("Specify number of card you want to " + action + ": ");
        String cardNumber = input.nextLine();
        String[] options = {"(card number)", "show", "back"};
        if(cardNumber.equals("back")) {
            displayCardMenu();
            return;
        }
        if(cardNumber.equals("show")) {
            displayOptions(options);
            displayTakeActionCardMenu(action);
            return;
        }
        Card card = CardRepository.findCardById(cardNumber);
        if(card == null) {
            System.out.println("Incorrect card number");
            displayTakeActionCardMenu(action);
            return;
        }
        if(action.equals("delete")) {
            CardRepository.deleteCard(card);
            System.out.println("Operation completed.");
            displayCardMenu();
            return;
        }
        if(action.equals("activate"))
            card.activateCard();
        else if(action.equals("deactivate"))
            card.deactivateCard();
        CardRepository.updateCard(card);
        System.out.println("Operation completed.");
        displayCardMenu();
    }
}
