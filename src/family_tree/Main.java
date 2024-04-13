package family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;
import family_tree.writer.Writable;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> members = new ArrayList<>();

        Human vito = new Human("Vito", LocalDate.of(1891, 12, 7), Gender.Male);
        vito.setDateOfDeath(LocalDate.of(1955, 7, 29));

        Human carmine = new Human("Carmine", LocalDate.of(1877, 11, 21), Gender.Male);
        carmine.setDateOfDeath(LocalDate.of(1934, 5, 23));

        Human antonio = new Human("Antonio", LocalDate.of(1892, 8, 8), Gender.Male);

        Human antonia = new Human("Antonia", LocalDate.of(1892, 8, 5), Gender.Female);
        antonia.setDateOfDeath(LocalDate.of(1915, 11, 7));

        Human andolini = new Human("Andolini", LocalDate.of(1860, 5, 4), Gender.Male);
        andolini.setDateOfDeath(LocalDate.of(1891, 8, 30));

        Human andoliniMother = new Human("Andolini's mother", LocalDate.of(1838, 4, 12), Gender.Female);
        andoliniMother.setDateOfDeath(LocalDate.of(1893, 3, 18));

        Human connie = new Human("Connie", LocalDate.of(1927, 12, 17), Gender.Female);

        Human carlo = new Human("Carlo", LocalDate.of(1920, 3, 18), Gender.Male);
        carlo.setDateOfDeath(LocalDate.of(1955, 7, 29));

        Human michael = new Human("Michael", LocalDate.of(1920, 9, 23), Gender.Male);

        Human sonny = new Human("Sonny", LocalDate.of(1917, 5, 17), Gender.Male);
        sonny.setDateOfDeath(LocalDate.of(1948, 7, 29));

        Human fredo = new Human("Fredo", LocalDate.of(1919, 4, 17), Gender.Male);
        fredo.setDateOfDeath(LocalDate.of(1958, 5, 14));

        Human tom = new Human("Tom", LocalDate.of(1900, 8, 31), Gender.Male);
        tom.setDateOfDeath(LocalDate.of(1955, 7, 30));

        Human hagen = new Human("Hagen", LocalDate.of(1901, 10, 30), Gender.Male);

        Human kay = new Human("Kay", LocalDate.of(1925, 5, 10), Gender.Female);

        // Устанавливаем отношения
        vito.setFather(carmine);
        vito.setMother(antonia);
        antonia.setFather(andolini);
        antonia.setMother(andoliniMother);
        michael.setFather(vito);
        michael.setMother(kay);
        sonny.setFather(vito);
        sonny.setMother(kay);
        fredo.setFather(vito);
        fredo.setMother(kay);
        connie.setFather(vito);
        connie.setMother(kay);
        carlo.setFather(vito);
        carlo.setMother(kay);
        tom.setFather(vito);
        tom.setMother(kay);
        hagen.setFather(vito);
        hagen.setMother(kay);

        // Добавляем членов семьи в список
        members.add(vito);
        members.add(carmine);
        members.add(antonio);
        members.add(andolini);
        members.add(andoliniMother);
        members.add(michael);
        members.add(sonny);
        members.add(fredo);
        members.add(connie);
        members.add(carlo);
        members.add(tom);
        members.add(hagen);
        members.add(kay);

        // Сохраняем в файл и загружаем из файла
        try {
            Writable fileHandler = new FileHandler();
            fileHandler.saveToFile("family_tree_data.txt", members);
            List<Human> loadedMembers = fileHandler.loadFromFile("family_tree_data.txt");

            // Дальнейшие операции с членами семьи
            System.out.println("Члены семьи Карлеоне:");
            for (Human member : loadedMembers) {
                System.out.println("Имя: " + member.getName() + ", Дата рождения: " + member.getDateOfBirth() + ", Дата смерти: " + member.getDateOfDeath() + ", Пол: " + member.getGender());
                if (member.getMother() != null) {
                    System.out.println("Мать: " + member.getMother().getName());
                }
                if (member.getFather() != null) {
                    System.out.println("Отец: " + member.getFather().getName());
                }
                System.out.println();
            }

             // Сортировка по имени
            Collections.sort(loadedMembers, Comparator.comparing(Human::getName));
            System.out.println("\nОтсортированный список по имени:");
            for (Human member : loadedMembers) {
            System.out.println(member.getName());
            }

            // Сортировка по дате рождения
            Collections.sort(loadedMembers, Comparator.comparing(Human::getDateOfBirth));
            System.out.println("\nОтсортированный список по дате рождения:");
            for (Human member : loadedMembers) {
            System.out.println(member.getName() + " - " + member.getDateOfBirth());
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
