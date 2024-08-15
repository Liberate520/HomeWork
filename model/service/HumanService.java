package com.oop.homeWorkOOP.model.service;

import com.oop.homeWorkOOP.model.human.Gender;
import com.oop.homeWorkOOP.model.human.Human;
import com.oop.homeWorkOOP.model.lineAge.LineageTree;
import com.oop.homeWorkOOP.model.lineAgeSave.LineAgeFile;

import java.util.List;

public class HumanService {
    LineageTree<Human> lineAge;
    LineAgeFile <Human> workWithFile;

    public HumanService () {
        this.lineAge = new LineageTree<>();
//        this.lineAge = creatAndFillLineAge();
        workWithFile = new LineAgeFile<>("lineage.db");
    }

    public boolean addHuman (String name, int bDay, int bMonth, int bYear, Gender gender, Human father, Human mother) {
        Human human = new Human(name, bDay, bMonth, bYear, gender, father, mother);
        return lineAge.addHuman(human);
    }

    public boolean addHuman (String name, int bDay, int bMonth, int bYear, int dDay, int dMonth, int dYear, Gender gender,
                          Human father, Human mother) {
        Human human = new Human(name, bDay, bMonth, bYear, dDay, dMonth, dYear, gender, father, mother);
        return lineAge.addHuman(human);
    }

    public Human getHumanById(int i) {
        return lineAge.getHumanById(i);
    }

    public List<Human> getHumanByName(String name) {
        return lineAge.getHumanByName(name);
    }

    public String getLineAgeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Родословное древо: \n");
        for (int i = 0; i < lineAge.getLineAgeSize(); i++) {
            sb.append("Номер записи: ");
            sb.append(i+1);
            sb.append("\n");
            sb.append(lineAge.getHumanById(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public LineageTree<Human> getAllFather(Human human) {
        return lineAge.getAllFather(human);
    }

    public LineageTree<Human> getAllMother(Human human) {
        return lineAge.getAllMother(human);
    }

    public LineageTree<Human> getAllChildren(Human human) {
        return lineAge.getAllChildren(human);
    }

    public LineageTree<Human> getAllParents(Human human) {
        return lineAge.getAllParents(human);
    }

    public void sortByName() {
        lineAge.sortByName();
    }

    public void sortByBirthDate() {
        lineAge.sortByBirthDate();
    }

    public boolean saveTree() {
        return workWithFile.saveLineAge(lineAge);
    }

    public boolean loadTree() {
        lineAge = workWithFile.loadLineAge();
        return lineAge != null;
    }

    public  int getTreeSize() {
        return lineAge.getLineAgeSize();
    }

    public LineageTree<Human> creatAndFillLineAge() {
        LineageTree<Human> lineAge = new LineageTree<>();
        Human h9 = new Human("Эрнст", 24, 7, 1920, 3, 5, 2020, Gender.Male, null, null);
        Human h5 = new Human("Арнольд", 3, 8, 1955, 4, 7, 2022, Gender.Male, h9, null);
        Human h6 = new Human("Антонина", 12, 10, 1961, Gender.Female, null, null, null);
        Human h7 = new Human("Константин", 21, 8, 1945, 15, 6, 2021, Gender.Male, null, null);
        Human h8 = new Human("Инна", 25, 4, 1944, 3, 5, 2021, Gender.Female, null, null);
        Human h4 = new Human("Александра", 6, 6, 1982, Gender.Female, h7, h8);
        Human h3 = new Human("Евгений", 4, 6, 1980, Gender.Male, h5, h6);
        Human h2 = new Human("Анна", 3, 3, 2002, Gender.Female, h3, h4);
        Human h1 = new Human("Василий", 1, 1, 2000, Gender.Male, h3, h4);
        lineAge.addHuman(h1);
        lineAge.addHuman(h2);
        lineAge.addHuman(h3);
        lineAge.addHuman(h4);
        lineAge.addHuman(h5);
        lineAge.addHuman(h6);
        lineAge.addHuman(h7);
        lineAge.addHuman(h8);
        lineAge.addHuman(h9);
        return lineAge;
    }
}
