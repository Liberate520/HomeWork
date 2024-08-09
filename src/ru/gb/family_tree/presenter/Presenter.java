package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private final FamilyTreeService service;

    public Presenter() {
        service = new FamilyTreeService();
    }

    public String getTreeInfo() {
        return service.getTreeInfo();
    }

    public String sortById() {
        return service.sortById();
    }

    public String sortByName() {
        return service.sortByName();
    }

    public String sortByAge() {
        return service.sortByAge();
    }

    public String sortByBirthDay() {
        return service.sortByBirthDay();
    }

    public String getChildrenInfo(int selectId) {
        return service.getChildrenInfo(selectId);
    }

    public String addHuman(String strName, String strGender, String strBirthDay) {
        Gender gender;
        if (strGender.charAt(0) == 'М') {
            gender = Gender.MALE;
        } else if (strGender.charAt(0) == 'Ж') {
            gender = Gender.FEMALE;
        } else {
            return "Данные пола введены не верно.";
        }
        LocalDate birthDay = LocalDate.parse(strBirthDay);
        return service.addHuman(strName, gender, birthDay);
    }

    public String setHumanDeathDay(int id, String strDeathDay) {
        LocalDate deathDay = LocalDate.parse(strDeathDay);
        return service.setHumanDeathDay(id, deathDay);
    }

    public String setHumanFather(int idChildren, int idFather) {
        return service.setHumanFather(idChildren, idFather);
    }

    public String setHumanMother(int idChildren, int idMother) {
        return service.setHumanMother(idChildren, idMother);
    }

    public String wedding(int idHusband, int idWife) {
        return service.wedding(idHusband, idWife);
    }

    public String divorce(int idHusband, int idWife) {
        return service.divorce(idHusband, idWife);
    }

    public String remove(int id) {
        return service.remove(id);
    }

    public String createFamilyTree() {
        service.createFamilyTree();
        return service.getTreeInfo();
    }

    public void restoreTree() {
        service.restoreTree();
    }

    public void saveTree() {
        service.saveTree();
    }
}
