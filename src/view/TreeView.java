package view;

import person.Person;

import java.util.List;

public interface TreeView {
    void displayMessage(String message);
    void displayPerson(Person person);
    void displayAllPersons(List<Person> persons);
    void addCommand(Command command);
    void start();
}
