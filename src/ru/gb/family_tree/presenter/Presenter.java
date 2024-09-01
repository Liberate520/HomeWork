package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.service.FamilyTreeServices;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTreeServices service;

    public Presenter(View view, FamilyTreeServices service) {
        this.service = service;
        this.view = view;
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, long idFather, long idMother) {
        Human human = service.addHuman(name, gender, birthDate, idFather, idMother);
        view.print(human.toString());
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = service.addHuman(name, gender, birthDate);
        view.print(human.toString());
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void setDeathDate(int idHuman, LocalDate deathDate){
        if (service.setDeathDate(idHuman, deathDate)){
            view.print("Данные обновлены");
        } else {
            view.print("Не удалось обновить данные");
        }
    }

    public void setParentToChild(int idParent, int idChild){
        if (service.setParentToChild(idParent, idChild)){
            view.print("Данные обновлены");
        } else {
            view.print("Данные не удалось обновить");
        }
    }
}
