package view;

import model.Person;

import java.util.List;

public interface TreeView {
    void start();
    void displayMembers(List<Person> members);
    void showMessage(String message);
    void displayChildren(List<Person> children);
}

