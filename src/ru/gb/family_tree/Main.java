package ru.gb.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.writer.Writer;
import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        Human human1 = new Human(1, "Семёнов Петр Игоревич", LocalDate.of(1965, 8, 16), Gender.Male, null, null);
        Human human2 = new Human(2, "Тарасов Виктор Алексеевич", LocalDate.of(1974, 1, 6), Gender.Male, null, null);
        Human human3 = new Human(3, "Максимова Татьяна Ивановна", LocalDate.of(1965, 9, 2), Gender.Female, null, null);
        Human human4 = new Human(4, "Вареникова Светлана Афанасьевна", LocalDate.of(1994, 2, 18), Gender.Female, human1, human3);
        Human human5 = new Human(5, "Самохина Валентина Петровна", LocalDate.of(1985, 9, 2), Gender.Female, null, null);

        human1.setDateOfDeath(LocalDate.of(2021, 2, 14));
        human1.addChild(human4);
        human3.addChild(human4);
        human3.addChild(human5);

        familyTree.addElement(human1);
        familyTree.addElement(human2);
        familyTree.addElement(human3);
        familyTree.addElement(human4);
        familyTree.addElement(human5);

        // Укажите абсолютный путь
        String filePath = "familytreebase.txt";
        Writer writer = new FileHandler(filePath);

        try {
            // Запись семейного древа в файл
            if (writer.writeToFile(familyTree)) {
                System.out.println("Данные успешно записаны в файл: " + filePath);
            } else {
                System.out.println("Ошибка при записи данных в файл: " + filePath);
            }

            // Чтение семейного древа из файла
            FamilyTree<Human> readFamilyTree = (FamilyTree<Human>) writer.readFromFile();
            System.out.println("Данные успешно считаны из файла: " + filePath);

            // Сортировка по имени
            readFamilyTree.sortByName();
            System.out.println("Семейное древо (отсортировано по имени):");
            for (Human human : readFamilyTree) {
                System.out.println("______________________________");
                System.out.println("Семейное древо: ");
                System.out.println(human.getBasicInfo());
                System.out.println();
                System.out.println("Мать: " + (human.getMother() != null ? "\n" + human.getMother().getBasicInfo() : "неизвестно"));
                System.out.println();
                System.out.println("Отец: " + (human.getFather() != null ? "\n" + human.getFather().getBasicInfo() : "неизвестно"));
                System.out.println();
                System.out.println("Дети: " + human.getChildrenInfo());
                System.out.println();
            }
            System.out.println("______________________________");

            // Сортировка по возрасту
            readFamilyTree.sortByAge();
            System.out.println("Семейное древо (отсортировано по возрасту):");
            for (Human human : readFamilyTree) {
                System.out.println("______________________________");
                System.out.println("Семейное древо: ");
                System.out.println(human.getBasicInfo());
                System.out.println();
                System.out.println("Мать: " + (human.getMother() != null ? "\n" + human.getMother().getBasicInfo() : "неизвестно"));
                System.out.println();
                System.out.println("Отец: " + (human.getFather() != null ? "\n" + human.getFather().getBasicInfo() : "неизвестно"));
                System.out.println();
                System.out.println("Дети: " + human.getChildrenInfo());
                System.out.println();
            }
            System.out.println("______________________________");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
