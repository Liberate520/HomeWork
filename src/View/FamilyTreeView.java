package View;

import Model.Person;

import java.util.List;
import java.util.Scanner;

public interface FamilyTreeView {
    void showMenu();
    void displayPeople(List<Person> people);
    void displayMessage(String message);
    void displayPerson(Person person);

    Scanner getScanner();
}
