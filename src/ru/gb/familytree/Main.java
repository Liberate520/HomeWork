package ru.gb.familytree;

import ru.gb.familytree.model.HumanInfo;
import ru.gb.familytree.model.Gender;
import ru.gb.familytree.presenter.FamilyTreePresenter;
import ru.gb.familytree.view.ConsoleFamilyTreeView;
import ru.gb.familytree.view.FamilyTreeView;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);

        // Создание людей
        HumanInfo viserys = new HumanInfo("Viserys", LocalDate.of(1970, 1, 1), null, Gender.MALE);
        HumanInfo aemma = new HumanInfo("Aemma", LocalDate.of(1975, 5, 10), LocalDate.of(2020, 10, 1), Gender.FEMALE);
        HumanInfo alisanta = new HumanInfo("Alisanta", LocalDate.of(1990, 3, 15), null, Gender.FEMALE);
        HumanInfo rhaenyra = new HumanInfo("Rhaenyra", LocalDate.of(1996, 4, 20), null, Gender.FEMALE);
        HumanInfo aegon = new HumanInfo("Aegon", LocalDate.of(2000, 5, 25), null, Gender.MALE);
        HumanInfo aemond = new HumanInfo("Aemond", LocalDate.of(2002, 6, 30), null, Gender.MALE);
        HumanInfo helaena = new HumanInfo("Helaena", LocalDate.of(2004, 7, 15), null, Gender.FEMALE);

        // Добавление людей в древо
        presenter.addMember(viserys);
        presenter.addMember(aemma);
        presenter.addMember(alisanta);
        presenter.addMember(rhaenyra);
        presenter.addMember(aegon);
        presenter.addMember(aemond);
        presenter.addMember(helaena);

        // Установка родительских связей
        viserys.addChild(rhaenyra);
        viserys.addChild(aegon);
        viserys.addChild(aemond);
        viserys.addChild(helaena);

        aemma.addChild(rhaenyra);
        alisanta.addChild(aegon);
        alisanta.addChild(aemond);
        alisanta.addChild(helaena);

        rhaenyra.setFather(viserys);
        rhaenyra.setMother(aemma);

        aegon.setFather(viserys);
        aegon.setMother(alisanta);

        aemond.setFather(viserys);
        aemond.setMother(alisanta);

        helaena.setFather(viserys);
        helaena.setMother(alisanta);

        runMenu(presenter);
    }

    private static void runMenu(FamilyTreePresenter presenter) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Сортировка по имени");
            System.out.println("2. Сортировка по дате рождения");
            System.out.println("3. Найти конкретного человека");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    presenter.sortByName();
                    break;
                case 2:
                    presenter.sortByDob();
                    break;
                case 3:
                    System.out.println("Введите имя человека:");
                    String name = scanner.nextLine();
                    presenter.findPersonByName(name);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}


//import ru.gb.familytree.familytree.FamilyTree;
//import ru.gb.familytree.model.Gender;
//import ru.gb.familytree.model.HumanInfo;
//import ru.gb.familytree.writer.FileHandler;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Comparator;
//
//public class Main {
//    public static void main(String[] args) {
//        // Создание семейного древа для HumanInfo
//        FamilyTree<HumanInfo> tree = new FamilyTree<>();
//
//        // Параметры людей
//        HumanInfo viserys = new HumanInfo("Viserys", LocalDate.of(1970, 1, 1), null, Gender.MALE);
//        HumanInfo aemma = new HumanInfo("Aemma", LocalDate.of(1975, 5, 10), LocalDate.of(2020, 10, 1), Gender.FEMALE);
//        HumanInfo alisanta = new HumanInfo("Alisanta", LocalDate.of(1990, 3, 15), null, Gender.FEMALE);
//        HumanInfo rhaenyra = new HumanInfo("Rhaenyra", LocalDate.of(1996, 4, 20), null, Gender.FEMALE);
//        HumanInfo aegon = new HumanInfo("Aegon", LocalDate.of(2000, 5, 25), null, Gender.MALE);
//        HumanInfo aemond = new HumanInfo("Aemond", LocalDate.of(2002, 6, 30), null, Gender.MALE);
//        HumanInfo helaena = new HumanInfo("Helaena", LocalDate.of(2004, 7, 15), null, Gender.FEMALE);
//
//        // Добавление людей в древо
//        tree.addMember(viserys);
//        tree.addMember(aemma);
//        tree.addMember(alisanta);
//        tree.addMember(rhaenyra);
//        tree.addMember(aegon);
//        tree.addMember(aemond);
//        tree.addMember(helaena);
//
//        viserys.addChild(rhaenyra);
//        viserys.addChild(aegon);
//        viserys.addChild(aemond);
//        viserys.addChild(helaena);
//
//        aemma.addChild(rhaenyra);
//
//        alisanta.addChild(aegon);
//        alisanta.addChild(aemond);
//        alisanta.addChild(helaena);
//
//        rhaenyra.setFather(viserys);
//        rhaenyra.setMother(aemma);
//
//        aegon.setFather(viserys);
//        aegon.setMother(alisanta);
//
//        aemond.setFather(viserys);
//        aemond.setMother(alisanta);
//
//        helaena.setFather(viserys);
//        helaena.setMother(alisanta);
//
//        // Сохранение семейного древа в файл
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "FamilyTree.txt";
//        try {
//            fileHandler.save(tree.getMembers(), filePath);
//            System.out.println("Family tree saved successfully.");
//        } catch (IOException e) {
//            System.out.println("Failed to save family tree: " + e.getMessage());
//        }
//
//        // Загрузка семейного древа из файла
//        try {
//            List<HumanInfo> loadedMembers = fileHandler.load(filePath);
//            FamilyTree<HumanInfo> loadedTree = new FamilyTree<>();
//            for (HumanInfo member : loadedMembers) {
//                loadedTree.addMember(member);
//            }
//            System.out.println("Family tree loaded successfully.");
//
//            // Сортировка и вывод всех людей по имени
//            loadedTree.sortByName();
//            System.out.println("\nPeople sorted by name:");
//            for (HumanInfo member : loadedTree) {
//                System.out.println(member);
//            }
//
//            // Сортировка и вывод всех людей по дате рождения
//            loadedTree.sortByDob();
//            System.out.println("\nPeople sorted by date of birth:");
//            for (HumanInfo member : loadedTree) {
//                System.out.println(member);
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Failed to load family tree: " + e.getMessage());
//        }
//    }
//}
            // Проведение исследования: получение всех детей Viserys
            //HumanInfo viserysLoaded = loadedTree.findPersonByName("Viserys");
            //if (viserysLoaded != null) {
            //    System.out.println("Information about Viserys:");
            //    System.out.println(viserysLoaded);
            //    List<HumanInfo> childrenOfViserys = viserysLoaded.getChildren();

                // Вывод результатов исследования
            //    System.out.println("Children of Viserys:");
            //    for (HumanInfo child : childrenOfViserys) {
            //        System.out.println(child.getName() + ", DOB: " + child.getDob() +
            //                ", DOD: " + (child.getDod() != null ? child.getDod() : "N/A") +
            //                ", ru.gb.familytree.model.Gender: " + child.getGender());
            //    }
            //}
