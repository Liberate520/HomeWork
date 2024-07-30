package com.oop.homeWorkOOP;

public class Main {
    public static void main(String[] args) {
        LineageTree lineAge = new LineageTree();
        Human h9 = new Human("Эрнст", 24, 7, 1920, 3, 5, 2020, null, null, null);
        Human h5 = new Human("Арнольд", 3, 8, 1955, 4, 7, 2022, h9, null, null);
        Human h6 = new Human("Антонина", 12, 10, 1961, null, null, null);
        Human h7 = new Human("Константин", 21, 8, 1945, 15, 6, 2021, null, null, null);
        Human h8 = new Human("Инна", 25, 4, 1944, 3, 5, 2021, null, null, null);
        Human h4 = new Human("Александра", 6, 6, 1982, h7, h8, null);
        Human h3 = new Human("Евгений", 4, 6, 1980, h5, h6, null);
        Human h2 = new Human("Анна", 3, 3, 2002, h3, h4, null);
        Human h1 = new Human("Василий", 1, 1, 2000, h3, h4, null);
        h3.addChild(h1);
        h3.addChild(h2);
        h4.addChild(h1);
        h4.addChild(h2);
        h5.addChild(h3);
        h6.addChild(h3);
        h7.addChild(h4);
        h8.addChild(h4);
        h9.addChild(h5);
        lineAge.addHuman(h1);
        lineAge.addHuman(h2);
        lineAge.addHuman(h3);
        lineAge.addHuman(h4);
        lineAge.addHuman(h5);
        lineAge.addHuman(h6);
        lineAge.addHuman(h7);
        lineAge.addHuman(h8);
        lineAge.addHuman(h9);
        lineAge.printLineAge();
        System.out.println("---------");
        LineageTree fatherLine = lineAge.getFatherLine(lineAge.getHumanById(0));
        fatherLine.printLineAge();
        System.out.println("-----------");
        LineageTree motherLine = lineAge.getMotherLine(lineAge.getHumanById(1));
        motherLine.printLineAge();
        System.out.println("---------");
        System.out.println(lineAge.getHumanById(9).getChildren());
    }
}
