import java.util.Scanner;

public class Menu {
    public static Scanner input = new Scanner(System.in);
    AccountRepository accountRepository;
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
        String[] options = {"user", "account", "card", "transaction", "show", "back", "end"};
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
        if(str.equals("transaction")) {
            displayTransactionMenu();
            return;
        }
        if(str.equals("account")) {
            displayAccountMenu();
            return;
        }
        if(str.equals("user")) {
            displayUserMenu();
        }
        if(str.equals("end"))
            return;
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
            System.out.println("Incorrect command.");
            displayCardMenu();
            return;
        }
        System.out.println("Incorrect command.");
        displayCardMenu();
        return;
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
    private void displayTransactionMenu() {
        String[] options = {"show transactions", "create transaction", "update transaction", "show", "back"};
        System.out.print("transaction> ");
        String str = input.nextLine();
        String[] enteredInput = str.split(" ", 0);
        if(enteredInput.length == 1) {
            if(str.equals("show")) {
                displayOptions(options);
                displayTransactionMenu();
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
        if(enteredInput.length > 2) {
            System.out.println("Incorrect input");
            displayTransactionMenu();
            return;
        }
        if(enteredInput[0].equals("show")) {
            TransactionRepository.showTransactions();
            displayTransactionMenu();
            return;
        }
        if(enteredInput[0].equals("update")) {
            displayTransactionUpdateMenu();
            return;
        }
        if(enteredInput[0].equals("create")) {
            displayCreateTransactionMenu();
            return;
        }
    }
    private void displayTransactionUpdateMenu() {
        String[] options1 = {"(transaction number)", "show", "back"};
        String[] options2 = {"(status number)", "show", "back"};
        System.out.println("Enter the id of the transaction you want to update: ");
        String transactionId = input.nextLine();
        if(transactionId.equals("back")) {
            displayTransactionMenu();
            return;
        }
        if(transactionId.equals("show")) {
            displayOptions(options1);
            displayTransactionUpdateMenu();
            return;
        }
        Transaction transaction = TransactionRepository.findTransactionById(transactionId);
        if(transaction == null) {
            System.out.println("Transaction does not exist.");
            displayTransactionUpdateMenu();
        }
        System.out.println("Enter the new status of the transaction: ");
        String newStatus = input.nextLine();
        if(newStatus.equals("back")) {
            displayTransactionMenu();
            return;
        }
        if(newStatus.equals("show")) {
            displayOptions(options2);
            displayTransactionUpdateMenu();
            return;
        }
        transaction.updateStatus(newStatus);
        TransactionRepository.updateTransactionStatus(transactionId, newStatus);
        System.out.println("Transaction update successfull.");
        displayTransactionMenu();
        return;
    }
    private void displayCreateTransactionMenu() {
        System.out.println("Enter type of transaction you want to do (deposit, withdrawal, transfer): ");
        String enteredType = input.nextLine();
        String[] options = {"deposit", "withdrawal", "transfer", "show", "back"};
        if(enteredType.equals("show")) {
            displayOptions(options);
            displayCreateTransactionMenu();
            return;
        }
        if(enteredType.equals("back")) {
            displayTransactionMenu();
            return;
        }
        if(enteredType.equals("deposit")) {
            displayCreateDepositMenu();
            return;
        }
        if(enteredType.equals("withdrawal")) {
            displayCreateWithdrawalMenu();
            return;
        }
        if(enteredType.equals("transfer")) {
            displayCreateTransferMenu();
            return;
        }
        System.out.println("Incorrect command.");
        displayCreateTransactionMenu();
    }
    void displayCreateDepositMenu() {
        System.out.println("Enter the IBAN of the account that the money is deposited to: ");
        String accountId = input.nextLine();
        System.out.println("Enter the amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        Transaction transaction = new Transaction(1, amount, accountId);
        TransactionRepository.addTransaction(transaction);
        System.out.println("Transaction added successfully.");
        displayTransactionMenu();
    }
    void displayCreateWithdrawalMenu() {
        System.out.println("Enter the IBAN of the account you are withdrawing from: ");
        String accountId = input.nextLine();
        System.out.println("Enter the amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        Transaction transaction = new Transaction(2, amount, accountId);
        TransactionRepository.addTransaction(transaction);
        System.out.println("Transaction added successfully.");
        displayTransactionMenu();
    }
    void displayCreateTransferMenu() {
        System.out.println("Enter the IBAN of the sending account: ");
        String senderAccount = input.nextLine();
        System.out.println("Enter the IBAN of the receiver account: ");
        String receiverAccount = input.nextLine();
        System.out.println("Enter the amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter description: ");
        String description = input.nextLine();
        Transaction transaction = new Transaction(amount, senderAccount, receiverAccount, description);
        TransactionRepository.addTransaction(transaction);
        displayTransactionMenu();
    }
    public void displayAccountMenu() {
        System.out.print("account> ");
        String[] options = {"show accounts", "show", "back"};
        String[] command = input.nextLine().split(" ", 0);
        if(command.length > 1) {
            if(command[0].equals("show") && command[1].equals("accounts")) {
                accountRepository.showAllAccounts();
                displayAccountMenu();
                return;
            }
            System.out.println("Invalid command");
            displayAccountMenu();
            return;
        }
        if(command[0].equals("show")) {
            displayOptions(options);
            displayAccountMenu();
            return;
        }
        if(command[0].equals("back")) {
            displayFirstMenu();
            return;
        }
        System.out.println("Invalid command");
        displayAccountMenu();
    }
    public void displayUserMenu() {
        System.out.print("user> ");
        String[] options = {"show users", "create user", "show", "back"};
        String[] command = input.nextLine().split(" ", 0);
        UserService userService = new UserService(new UserRepository());
        if(command.length == 1) {
            if(command[0].equals("show")) {
                userService.showAllUsers();
                displayUserMenu();
                return;
            }
            if(command[0].equals("back")) {
                displayFirstMenu();
                return;
            }
            System.out.println("Invalid command");
            displayUserMenu();
            return;
        }
        if(command[0].equals("show") && command[1].equals("users")) {
            userService.showAllUsers();
            displayUserMenu();
            return;
        }
    }
}
