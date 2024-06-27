package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.FT.FamilyTree;
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
    private FamilyTree<Human> familyTree;

    public Presenter(View view, Service<Human> service){
        this.view = view;
        this.service = service;
    }

    public void addHuman(String lastName, String name, Gender gender, LocalDate birthDate) {
        service.addHuman(lastName, name, gender, birthDate);
        getFamilyTree();
    }

    public Human findHumanByName(String nameHuman){
        familyTree.findHumanByName(nameHuman);
        getFamilyTree();
        return null;
    }

    public void getFamilyTree() {
        FamilyTree<Human> familyTree = service.getFamilyTree();
        List<Human> humanList = new ArrayList<>(familyTree.getHumanList());
        System.out.println("Текущий состав членов семьи: ");
        for (Human human : humanList){
            System.out.println(human);
        }
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


}


