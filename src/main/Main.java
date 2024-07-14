package main;

import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
                FamilyTree<Human> readTree;
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/family_tree/tree.txt"))) {
                        readTree = (FamilyTree<Human>) ois.readObject();
                        System.out.println("Загруженное Семейное Древо:");
                        System.out.println(readTree);
                } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Не удалось загрузить Семейное Древо из файла. Создается новое.");
                        e.printStackTrace();
                }

                Human wowa = new Human("Вова", Gender.MALE, 45, LocalDate.of(1977, 3, 15));
                Human wika = new Human("Вика", Gender.FEMALE, 38, LocalDate.of(1984, 7, 20));
                Human katja = new Human("Катя", Gender.FEMALE, 12, LocalDate.of(2010, 2, 1));
                Human sasha = new Human("Саша", Gender.MALE, 8, LocalDate.of(2014, 6, 30));

                // Создание экземпляра класса семейное дерево
                FamilyTree<Human> familyTree = new FamilyTree<>();

                // Добавление членов семьи
                // Добавление членов семьи
                familyTree.addHumanMember(wowa);
                familyTree.addHumanMember(wika);
                familyTree.addHumanMember(katja);
                familyTree.addHumanMember(sasha);


                // Установление супружеских связей
                familyTree.connectSpouses(wowa, wika);

                // Установление родственных связей
                familyTree.connectParents(katja, wowa, wika);
                familyTree.connectParents(sasha, wowa, wika);

                // Вывод состояния семейного древа
                System.out.println("\nСозданное Семейное Древо:");
                System.out.println(familyTree);

                // Сохранение семейного древа в файл
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/family_tree/tree.txt"))) {
                        oos.writeObject(familyTree);
                        System.out.println("\nСемейное Древо сохранено в файл.");
                } catch (IOException e) {
                        System.out.println("Не удалось сохранить Семейное Древо в файл.");
                        e.printStackTrace();
                }
        }
}

