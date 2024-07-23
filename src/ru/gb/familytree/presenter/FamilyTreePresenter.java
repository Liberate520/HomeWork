package ru.gb.familytree.presenter;

import ru.gb.familytree.model.HumanInfo;
import ru.gb.familytree.view.Service;
import ru.gb.familytree.view.FamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private Service service;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.service = new Service();
        this.view.setPresenter(this);
    }

    public void addMember(HumanInfo member) {
        service.addMember(member);
        view.showFamilyTree(service.getMembers());
    }

    public void sortByName() {
        service.sortByName();
        view.showFamilyTree(service.getMembers());
    }

    public void sortByDob() {
        service.sortByDob();
        view.showFamilyTree(service.getMembers());
    }

    public void findPersonByName(String name) {
        HumanInfo person = service.findPersonByName(name);
        if (person != null) {
            view.showFamilyTree(List.of(person));
        } else {
            view.showError("Person not found: " + name);
        }
    }
}