package ru.gb.family_tree;

import ru.gb.family_tree.FT.FamilyTree;
import ru.gb.family_tree.FT.FileHandler;
import ru.gb.family_tree.Human.Gender;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        //String name, Gender gender, LocalDate birthDate

        Gender.Human human1 = new Gender.Human("Шульга","Анастасия", Gender.Female, LocalDate.of(1991, 3, 16));
        Gender.Human human2 = new Gender.Human("Похабов", "Андрей", Gender.Male, LocalDate.of(1993, 3, 14));
        Gender.Human human3 = new Gender.Human("Похабов","Дмитрий", Gender.Male, LocalDate.of(2021, 12, 23));
        Gender.Human human4 = new Gender.Human("Шульга","Наталья", Gender.Male, LocalDate.of(1961, 5, 12));
        Gender.Human human5 = new Gender.Human("Шульга","Алексей", Gender.Male, LocalDate.of(1956, 5, 8));
        Gender.Human human6 = new Gender.Human("Похабов","Елена", Gender.Male, LocalDate.of(1972, 9, 1));
        Gender.Human human7 = new Gender.Human("Похабов","Дмитрий", Gender.Male, LocalDate.of(1972, 8, 5));


        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        human3.setParents(human1, human2);
        human2.setParents(human6, human7);
        human1.setParents(human4, human5);

        human1.addChild(human3);
        human2.addChild(human3);
        human4.addChild(human1);
        human5.addChild(human1);
        human6.addChild(human2);
        human7.addChild(human2);

        // Сохранение FamilyTree в файл
        FileHandler fileHandler = new FileHandler();
        String filePath = "familyTree.txt";
        try {
            fileHandler.saveFamilyTree(familyTree, "familyTree.txt");
            System.out.println("FamilyTree сохранено в файл " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Очистка или создание нового FamilyTree
        FamilyTree loadedFamilyTree = null;

        // Загрузка FamilyTree из файла
        try {
            loadedFamilyTree = fileHandler.loadFamilyTree(filePath);
            System.out.println("Загруженное семейное древо: ");
            System.out.println(loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

