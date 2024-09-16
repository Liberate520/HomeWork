package ru.gb.family_tree.presenter;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
    }

    public void addHuman(String lastName, String name, String genderInput, String birthDateInput) {
        LocalDate birthDate = LocalDate.parse(birthDateInput);
        service.addHuman(lastName, name, genderInput, birthDate);
        getFamilyTree();
    }

    public void findHumanByName(String nameHuman){
        var human = service.findHumanByName(nameHuman);
        if (human != null){
            view.printAnswer(human.toString());
        }else {
            view.printAnswer("Член семьи с указанным именем не найден");
        }
    }

    public void getFamilyTree() {
        var familyTree = service.getFamilyTree();
        var humanList = familyTree.getHumanList();
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
        boolean success = service.delHuman(id);
        if (success) {
            view.printAnswer("Человек с ID " + id + " был успешно удален.");
        } else {
            view.printAnswer("Человек с ID " + id + " не найден.");
        }
    }

    public void findHumanById(long id) {
        var human = service.findHumanById(id);
        if (human != null) {
            view.printAnswer("Найден человек: " + human.toString());
        } else {
            view.printAnswer("Человек с ID " + id + " не найден.");
        }
    }
}