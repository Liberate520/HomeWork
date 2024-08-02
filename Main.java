package com.oop.homeWorkOOP;

import com.oop.homeWorkOOP.fileWork.LineAgeFile;
import com.oop.homeWorkOOP.lineAge.Human;
import com.oop.homeWorkOOP.lineAge.LineageTree;

public class Main {
    public static void main(String[] args) {
        LineAgeFile lFile = new LineAgeFile();
        LineageTree lineAge = lFile.loadLineAge("lineage.db");
        lineAge.printLineAge();
        System.out.println("1--------");
        LineageTree fatherLine = lineAge.getAllFather(lineAge.getHumanById(0));
        fatherLine.printLineAge();
        System.out.println("2----------");
        LineageTree motherLine = lineAge.getAllMother(lineAge.getHumanById(1));
        motherLine.printLineAge();
        System.out.println("3----------");
        LineageTree parents = lineAge.getAllParents(lineAge.getHumanById(3));
        parents.printLineAge();
        System.out.println("4----------");
        LineageTree children = lineAge.getAllChildren(lineAge.getHumanById(6));
        children.printLineAge();
        System.out.println("5--------");
        System.out.println(lineAge.getHumanById(3));
        System.out.println("6--------");
        System.out.println(lineAge.getHumanByName("Инна"));
        System.out.println(lFile.saveLineAge(lineAge, "lineage.db"));

    }

    private static LineageTree creatAndFillLineAge() {
        LineageTree lineAge = new LineageTree();
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
