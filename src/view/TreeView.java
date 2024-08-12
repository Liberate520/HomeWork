package view;

import person.Person;
import presenter.Presenter;

public interface TreeView {
    void displayMessage(String message);
    void displayPerson(Person person);
    void displayAllPersons(String persons);
    String getUserInput(String prompt);
    void setPresenter(Presenter presenter);
}
