package view;

import model.Person;
import presenter.TreePresenter;

import java.util.List;

public interface TreeView {
    void setPresenter(TreePresenter presenter);
    void start();
    void displayMembers(List<Person> members);
    void displayChildren(List<Person> children);
    void showMessage(String message);
}


