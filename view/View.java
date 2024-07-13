package view;

public interface View {
    void showMenu();
    void display(String message);
    void displayError(String errorMessage);
    String getUserInput(String prompt); // SRP: добавлен метод для получения ввода пользователя
    int getUserIntInput(String prompt); // SRP: добавлен метод для получения ввода пользователя
}
