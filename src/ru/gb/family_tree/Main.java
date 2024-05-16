package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree("Козловы-Ватрич");

        Human petrovich = new Human("Петрович", "мужской");
        Human zina = new Human("Зина", "женский");
        Human kate = new Human("Катя", "женский");
        Human andre = new Human("Андрэ", "мужской");
        Human ann = new Human("Аня", "женский");

        tree.addMember(petrovich);
        tree.addMember(zina);
        tree.addMember(kate);
        tree.addMember(andre);
        tree.addMember(ann);
        System.out.println(tree.getFamilyInfo());

        kate.setBirthday(LocalDate.of(1964,11,10));
        kate.setLocationAddress("Заречный, ул.Мира 34-2");
        kate.setMother(zina);
        kate.setFather(petrovich);
        kate.addChild(andre);
        kate.addChild(ann);
        kate.addPhoneNumber("+7-908-622-45-78");
        System.out.println(kate.getInfo());






    }


}
