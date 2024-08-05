package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.FT.FamilyTree;
import ru.gb.family_tree.model.FT.FamilyTreeInterface;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
    }

    public void addHuman(String lastName, String name, Gender gender, LocalDate birthDate) {
        service.addHuman(lastName, name, gender, birthDate);
        getFamilyTree();
    }

    public Human findHumanByName(String nameHuman){
        return service.findHumanByName(nameHuman);
    }

    public void getFamilyTree() {
        FamilyTreeInterface familyTree = service.getFamilyTree();
        List<Human> humanList = new ArrayList<>(familyTree.getHumanList());
        view.printAnswer(humanList.toString());
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTree();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTree();
    }

    public void addChildById(long parentId, long childId) {
        service.addChildById(parentId, childId);
        getFamilyTree();
    }

    public void saveFamilyTree() {
        service.saveFamilyTree();
    }

    public void loadFamilyTree() {
        service.loadFamilyTree();
    }

    public void delHuman(long id) {
        service.delHuman(id);
//        boolean success = service.delHuman(id);
//        if (success) {
//            view.printAnswer("Человек с ID " + id + " был успешно удален.");
//        } else {
//            view.printAnswer("Человек с ID " + id + " не найден.");
//        }
    }

    public void findHumanById(long id) {
        service.findHumanById(id);
    }
}