package ru.gb.family_tree;

import ru.gb.family_tree.model.FT.FamilyTree;
import ru.gb.family_tree.model.FT.FamilyTreeItem;
import ru.gb.family_tree.model.FT.FileHandler;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.service.Service;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static <T extends FamilyTreeItem<T>> void main(String[] args) {
        //FamilyTree<T> familyTree = new FamilyTree<T>();
        Service service = new Service();

        service.addHuman("Шульга", "Анастасия", Gender.Female, LocalDate.of(1991,3,16));
        service.addHuman("Похабов", "Андрей", Gender.Male, LocalDate.of(1993,3,14));
        service.addHuman("Похабов", "Дмитрий", Gender.Male, LocalDate.of(2021,12,23));
        service.addHuman("Шульга", "Наталья", Gender.Female, LocalDate.of(1961,5,12));
        service.addHuman("Шульга", "Алексей", Gender.Male, LocalDate.of(1956,5,8));
        service.addHuman("Похабова","Елена", Gender.Female, LocalDate.of(1972, 9, 1));
        service.addHuman("Похабов","Дмитрий", Gender.Male, LocalDate.of(1972, 8, 5));

        FamilyTree<T> familyTree = service.getFamilyTree();



//
//        human3.setParents(human1, human2);
//        human2.setParents(human6, human7);
//        human1.setParents(human4, human5);
//
//        human1.addChild(human3);
//        human2.addChild(human3);
//        human4.addChild(human1);
//        human5.addChild(human1);
//        human6.addChild(human2);
//        human7.addChild(human2);
//
//        human1.getAge();
//        human2.getAge();
//        human3.getAge();
//        human4.getAge();
//        human5.getAge();
//        human6.getAge();
//        human7.getAge();


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

