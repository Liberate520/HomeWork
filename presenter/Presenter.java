package com.oop.homeWorkOOP.presenter;

import com.oop.homeWorkOOP.model.human.Gender;
import com.oop.homeWorkOOP.model.human.Human;
import com.oop.homeWorkOOP.model.lineAgeSave.LineAgeFile;
import com.oop.homeWorkOOP.model.service.HumanService;
import com.oop.homeWorkOOP.view.ConsoleUI;

import java.util.List;

public class Presenter {
    private ConsoleUI cons;
    private HumanService service;

    public Presenter(ConsoleUI cons) {
        this.cons = cons;
        this.service = new HumanService(new LineAgeFile<>("lineage.db"));
    }

    public void getTreeInfo() {
        String info = service.getLineAgeInfo();
        cons.printAnswer(info);
    }

    public void addHuman(String name, String birthDate, String deathDate, String gender, String father, String mother) {
        Gender gend;
        int[] birthDateArr = dateStringToIntArray(birthDate);
        if ("1".equals(gender)) {
            gend = Gender.Male;
        } else {
            gend = Gender.Female;
        }
        Human fath = checkParent(Integer.parseInt(father));
        Human moth = checkParent(Integer.parseInt(mother));
        if (deathDate!=null) {
            int[] deathDateArr = dateStringToIntArray(deathDate);
            service.addHuman(name, birthDateArr[0], birthDateArr[1], birthDateArr[2], deathDateArr[0], deathDateArr[1],deathDateArr[2], gend, fath, moth);
        } else {
            service.addHuman(name, birthDateArr[0], birthDateArr[1], birthDateArr[2], gend, fath, moth);
        }
        cons.printAnswer("Операция проведена!");
    }

    private Human checkParent(int p) {
        Human par;
        int size = service.getTreeSize();
        if (p ==0 || p > size) {
            par=null;
        } else {
            par = service.getHumanById(p -1);
        }
        return par;
    }

    private int[] dateStringToIntArray(String date) {
        String[] dateArray = date.split("-");
        int[] intDate = new int[3];
        for (int i = 0; i < dateArray.length; i++) {
            intDate[i] = Integer.parseInt(dateArray[i]);
        }
        return intDate;
    }

    public void sortTreeByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortTreeByBirthDate() {
        service.sortByBirthDate();
        getTreeInfo();
    }

    public void saveTree() {
        if (service.saveTree()) {
            cons.printAnswer("Древо успешно сохранено!");
        } else {
            cons.printAnswer("Древо не сохранено, ошибка!");
        }
    }

    public void loadTree() {
        if (service.loadTree()) {
            cons.printAnswer("Древо успешно загружено!");
        } else {
            cons.printAnswer("Древо не загружено, ошибка!");
        }
    }

    public void getHumanByName(String name) {
        List<Human> human = service.getHumanByName(name);
        if (human.isEmpty()) {
            cons.printAnswer("Ничего не найдено!");
        } else {
            for (Human hum:human) {
                cons.printAnswer(hum.toString());
            }
        }
        cons.printAnswer("Поиск окончен!");
    }
}
