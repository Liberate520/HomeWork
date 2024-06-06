package ru.gb.family_tree;

import ru.gb.family_tree.FT.FamilyTree;
import ru.gb.family_tree.FT.FamilyTreeItem;
import ru.gb.family_tree.FT.FileHandler;
import ru.gb.family_tree.Human.Gender;
import ru.gb.family_tree.Human.Human;
import ru.gb.family_tree.service.Service;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static <T extends FamilyTreeItem<T>> void main(String[] args) {
        FamilyTree<T> familyTree = new FamilyTree<T>();
        Service service = new Service(familyTree);


        //String name, Gender gender, LocalDate birthDate

        Human human1 = new Human("Шульга","Анастасия", Gender.Female, LocalDate.of(1991, 3, 16));
        Human human2 = new Human("Похабов", "Андрей", Gender.Male, LocalDate.of(1993, 3, 14));
        Human human3 = new Human("Похабов","Дмитрий", Gender.Male, LocalDate.of(2021, 12, 23));
        Human human4 = new Human("Шульга","Наталья", Gender.Female, LocalDate.of(1961, 5, 12));
        Human human5 = new Human("Шульга","Алексей", Gender.Male, LocalDate.of(1956, 5, 8));
        Human human6 = new Human("Похабов","Елена", Gender.Female, LocalDate.of(1972, 9, 1));
        Human human7 = new Human("Похабов","Дмитрий", Gender.Male, LocalDate.of(1972, 8, 5));


        familyTree.addHuman((T) human1);
        familyTree.addHuman((T) human2);
        familyTree.addHuman((T) human3);
        familyTree.addHuman((T) human4);
        familyTree.addHuman((T) human5);
        familyTree.addHuman((T) human6);
        familyTree.addHuman((T) human7);

        human3.setParents(human1, human2);
        human2.setParents(human6, human7);
        human1.setParents(human4, human5);

        human1.addChild(human3);
        human2.addChild(human3);
        human4.addChild(human1);
        human5.addChild(human1);
        human6.addChild(human2);
        human7.addChild(human2);

        human1.getAge();
        human2.getAge();
        human3.getAge();
        human4.getAge();
        human5.getAge();
        human6.getAge();
        human7.getAge();


//        service.sortByName();
//        System.out.println(familyTree);
//        service.sortByBirthDate();
//        System.out.println(familyTree);


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

