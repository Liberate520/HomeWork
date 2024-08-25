package Homework4_OOP.MVP;

import Homework4_OOP.Human.Human;
import java.util.List;

public interface View {
    void displayMenu();
    int getUserChoice();
    void displayMessage(String message);
    void displayHumans(List<Human> humans);
    String getUserInput(String prompt);
}
