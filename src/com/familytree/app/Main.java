package com.familytree.app;

import com.familytree.model.Gender;
import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.view.FamilyTreeView;
import com.familytree.view.FamilyTreeViewImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new FamilyTreeViewImpl();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);

        presenter.addPerson("Nikolay", LocalDate.of(1970, 4, 19), Gender.Male);
        presenter.addPerson("Olga", LocalDate.of(1969, 1, 11), Gender.Female);
        presenter.addPerson("Anna", LocalDate.of(2000, 3, 3), Gender.Female);
        presenter.addPerson("Alexei", LocalDate.of(1999, 3, 6), Gender.Male);

        presenter.setParents("Anna", "Olga", "Nikolay");
        presenter.setParents("Alexei", "Olga", "Nikolay");

        presenter.showChildren("Olga");
        presenter.showPeopleSortedByName();
        presenter.showPeopleSortedByBirthDate();
    }
}