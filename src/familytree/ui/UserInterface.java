package familytree.ui;

import familytree.model.Person;
import java.util.List;


public interface UserInterface {
    void displayMessage(String message);
    void displayPersons(List<Person> persons);
    String getUserInput(String prompt);
    void showMenu();
}