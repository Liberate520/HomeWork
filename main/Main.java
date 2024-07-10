package main;

import model.FamilyTree;
import model.Person;
import model.services.FamilyTreeServiceImpl;
import presenter.FamilyTreePresenter;
import view.ConsoleView;
import view.View;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FamilyTreeServiceImpl<Person> service = new FamilyTreeServiceImpl<>(familyTree);
        View view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);
        presenter.start();
    }
}
