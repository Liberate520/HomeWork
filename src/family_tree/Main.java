package family_tree;

import family_tree.family_tree1.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.service.Service;
import family_tree.writer.FileHandler;
import family_tree.writer.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        // Добавление людей
        Human vitaliy = service.addHuman("Виталий", LocalDate.of(1940, 1, 1), Gender.MALE);
        Human alexeySenior = service.addHuman("Алексей", LocalDate.of(1935, 3, 20), Gender.MALE);
        Human tamara = service.addHuman("Тамара", LocalDate.of(1940, 1, 26), Gender.FEMALE);
        Human ivan = service.addHuman("Иван", LocalDate.of(1968, 7, 7), Gender.MALE);
        Human sergey = service.addHuman("Сергей", LocalDate.of(1964, 1, 1), Gender.MALE);
        Human nadezhda = service.addHuman("Надежда", LocalDate.of(1975, 1, 29), Gender.FEMALE);
        Human alexeyJunior = service.addHuman("Алексей", LocalDate.of(1994, 4, 5), Gender.MALE);
        Human maxim = service.addHuman("Максим", LocalDate.of(2006, 11, 7), Gender.MALE);


        // Установка связей между людьми

        //Родители родителей
        vitaliy.setChildren(List.of(ivan));
        tamara.setChildren(List.of(nadezhda));
        alexeySenior.setChildren(List.of(nadezhda));

        //Родители детей
        //Добавление детей
        nadezhda.setChildren(List.of(alexeyJunior, maxim));
        ivan.setChildren(List.of(alexeyJunior));
        sergey.setChildren(List.of(maxim));
        //Добавление родителей
        ivan.setFather(vitaliy);
        nadezhda.setFather(alexeySenior);
        nadezhda.setMother(tamara);

        //Дети
        alexeyJunior.setFather(ivan);
        alexeyJunior.setMother(nadezhda);
        maxim.setFather(sergey);
        maxim.setMother(nadezhda);

        // Вывод информации о людях
        System.out.println(service.getHumanListInfo());


        // Сортировка людей по имени и вывод отсортированного списка
        service.sortByName();
        System.out.println("Отсортированный список людей по имени:\n" + service.getHumanListInfo());

        // Сортировка людей по дате рождения и вывод отсортированного списка
        service.sortByDateBirth();
        System.out.println("Отсортированный список людей по дате рождения:\n" + service.getHumanListInfo());

        // Используем Scanner для ввода имени или ID для поиска
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя или ID для поиска:");
        String searchInput = scanner.nextLine();

        try {
            int searchId = Integer.parseInt(searchInput);
            Human foundHuman = service.findHumanById(searchId);
            if (foundHuman != null) {
                System.out.println("Найденный человек по ID:");
                System.out.println(foundHuman);
            } else {
                System.out.println("Человек с ID " + searchId + " не найден.");
            }
        } catch (NumberFormatException e) {
            List<Human> foundHumans = service.findHumansByName(searchInput);
            if (!foundHumans.isEmpty()) {
                System.out.println("Найденные люди по имени:");
                for (Human human : foundHumans) {
                    System.out.println(human);
                }
            } else {
                System.out.println("Человек с именем " + searchInput + " не найден.");
            }
        }
        scanner.close();


        // Сериализация семейного дерева в файл
        Writer fileWriter = new FileHandler();
        String filePath = "familyTree.ser";
        try {
            fileWriter.save(filePath, service.getFamilyTree());
            //System.out.println("Семейное дерево сохраняется в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }

        // Десериализуйте семейное дерево из файла
        try {
            FamilyTree loadedFamilyTree = fileWriter.load(filePath);
            //System.out.println("Семейное дерево загружается из файла:");
            //System.out.println(loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }
}
