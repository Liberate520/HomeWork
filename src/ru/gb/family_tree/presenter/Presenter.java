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
            return "Данные пола введены не верно. Введите М или Ж";
        }
        LocalDate birthDay = LocalDate.parse(strBirthDay);
        return service.addHuman(strName, gender, birthDay) + "\n" + "Человек добавлен в дерево.";
    }

    public String setHumanDeathDay(int id, String strDeathDay) {
        LocalDate deathDay = LocalDate.parse(strDeathDay);
        return service.setHumanDeathDay(id, deathDay) + "\n" + "Добавлена дата смерти.";
    }

    public String setHumanFather(int idChildren, int idFather) {
        return service.setHumanFather(idChildren, idFather) + "\n" + "Отец добавлен.";
    }

    public String setHumanMother(int idChildren, int idMother) {
        return service.setHumanMother(idChildren, idMother) + "\n" + "Мать добавлена.";
    }

    public String wedding(int idHusband, int idWife) {
        return service.wedding(idHusband, idWife) + "\n" + "Брак заключен.";
    }

    public String divorce(int idHusband, int idWife) {
        return service.divorce(idHusband, idWife) + "\n" + "Брак разторгнут.";
    }

    public String remove(int id) {
        return service.remove(id) + "\n" + "Человек удален и дерева.";
    }

    public String createFamilyTree() {
        service.createFamilyTree();
        return service.getTreeInfo() + "\n" + "Семейное древо создано.";
    }

    public String saveTree() {
        service.saveTree();
        return service.getTreeInfo() + "\n" + "Семейное древо сохранено в файл.";
    }

    public String restoreTree() {
        service.restoreTree();
        return service.getTreeInfo() + "\n" + "Семейное древо востановленно из файла.";
    }
}
