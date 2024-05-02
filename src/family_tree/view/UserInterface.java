package family_tree.view;

public interface UserInterface {
    void displayMenu();
    int getUserChoice();
    String getInput();
    void showMessage(String message);
    void showErrorMessage(String errorMessage);
}