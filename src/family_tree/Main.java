package family_tree;

import family_tree.writer.FileHandler;
import family_tree.writer.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        // Создаем объекты Human для родителей родителей

        Human grandfather1 = new Human("Виталий", null, null,
                Gender.MALE, null, null, new ArrayList<>());
        Human grandfather2 = new Human("Алексей", LocalDate.of(1935, 3, 20),
                LocalDate.of(2002, 12, 27),
                Gender.MALE, null, null, new ArrayList<>());
        Human grandmother1 = new Human("Тамара", LocalDate.of(1940, 1, 26), null,
                Gender.FEMALE, null, null, new ArrayList<>());

        // Создаем объекты Human для родителей
        Human father1 = new Human("Иван", LocalDate.of(1968, 7, 7), null,
                Gender.MALE, grandfather1, null, new ArrayList<>());
        Human father2 = new Human("Сергей", LocalDate.of(1964, 1, 1), null,
                Gender.MALE, null, null, new ArrayList<>());
        Human mother1 = new Human("Надежда", LocalDate.of(1975, 1, 29), null,
                Gender.FEMALE, grandfather2, grandmother1, new ArrayList<>());

        // Создаем объекты Human для детей
        Human human1 = new Human("Алексей", LocalDate.of(1994, 4, 5), null,
                Gender.MALE, father1, mother1, new ArrayList<>());
        Human human2 = new Human("Максим", LocalDate.of(2006, 11, 7), null,
                Gender.MALE, father2, mother1, new ArrayList<>());


        // Добавляем детей в список детей родителей
        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(human1);

        ArrayList<Human> children2 = new ArrayList<>();
        children2.add(human2);

        father1.setChildren(children1);  // Иван имеет только одного ребенка - Алексея Ивановича
        father2.setChildren(children2);
        mother1.setChildren(new ArrayList<>());
        mother1.getChildren().add(human1);
        mother1.getChildren().add(human2); // Добавляем обоих детей к матери

        // Добавляем людей в семейное дерево
        familyTree.addHuman(grandfather1);
        familyTree.addHuman(grandfather2);
        familyTree.addHuman(grandmother1);
        familyTree.addHuman(father1);
        familyTree.addHuman(father2);
        familyTree.addHuman(mother1);
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);

        // Выводим информацию о людях
//        System.out.println(grandfather1);
//        System.out.println(grandfather2);
//        System.out.println(grandmother1);
//        System.out.println(father1);
//        System.out.println(father2);
//        System.out.println(mother1);
//        System.out.println(human1);
//        System.out.println(human2);

//        System.out.println(familyTree);


        // Используем Scanner для ввода имени для поиска
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя или ID для поиска:");
        String searchInput = scanner.nextLine();

        try {
            int searchId = Integer.parseInt(searchInput);
            Human foundHuman = familyTree.findHumanById(searchId);
            if (foundHuman != null) {
                System.out.println("Найденный человек по ID:");
                System.out.println(foundHuman);
            } else {
                System.out.println("Человек с ID " + searchId + " не найден.");
            }
        } catch (NumberFormatException e) {
            List<Human> foundHumans = familyTree.findHumansByName(searchInput);
            if (!foundHumans.isEmpty()) {
                System.out.println("Найденные люди по имени:");
                for (Human human : foundHumans) {
                    System.out.println(human);
                }
            } else {
                System.out.println("Человек с именем " + searchInput + " не найден.");
            }
        }


        // Запись семейного дерева в файл
        Writer fileWriter = new FileHandler();
        String filePath = "familyTree.ser";
        try {
            fileWriter.save(filePath, familyTree);
            System.out.println("Семейное дерево записано в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }

        // Чтение семейного дерева из файла
        try {
            FamilyTree loadedFamilyTree = fileWriter.load(filePath);
            System.out.println("Семейное дерево загружено из файла:");
            System.out.println(loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка чтения из файла: " + e.getMessage());
        }

        scanner.close();

    }
}
