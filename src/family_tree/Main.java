package ru.gb.family_tree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human olga = new Human("Ольга", LocalDate.of(1945, 5, 15), Gender.Female, null, null);
        familyTree.addMember(olga);

        Human ivan = new Human("Иван", LocalDate.of(1963, 3, 10), Gender.Male, null, olga);
        Human svetlana = new Human("Светлана", LocalDate.of(1965, 7, 25), Gender.Female, null, null);

        familyTree.addMember(ivan);
        familyTree.addMember(svetlana);

        ivan.setSpouse(svetlana);
        svetlana.setSpouse(ivan);

        Human anna = new Human("Анна", LocalDate.of(1988, 6, 5), Gender.Female, ivan, svetlana);
        Human pavel = new Human("Павел", LocalDate.of(1990, 11, 20), Gender.Male, ivan, svetlana);

        ivan.addChild(anna);
        ivan.addChild(pavel);
        svetlana.addChild(anna);
        svetlana.addChild(pavel);

        familyTree.addMember(anna);
        familyTree.addMember(pavel);

        for (Human member : familyTree.getMembers()) {
            System.out.println(member);
        }

        FileHandler fileHandler = new FileHandler();
        String fileName = "familyTree.ser";

        try {
            fileHandler.save(fileName, familyTree);
            System.out.println("Данные сохранены в файл: " + fileName);

            FamilyTree loadedFamilyTree = fileHandler.load(fileName);
            System.out.println("Данные загружены из файла: " + fileName);

            for (Human member : loadedFamilyTree.getMembers()) {
                System.out.println(member);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
