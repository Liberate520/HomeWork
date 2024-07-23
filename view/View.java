package view;

public interface View {
    void showMenu();
    void display(String message);
    void displayError(String message);
    UserInput getUserInput();
    int getUserIntInput(String prompt);
    String getUserInput(String prompt);
}
