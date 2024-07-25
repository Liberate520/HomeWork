import FamiliTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Writer.FileHandler;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        System.out.println(Arrays.toString(Gender.values()));     // проверка вывода формата Gender
//        Gender gender = Gender.Female;
//        System.out.println(gender);
//
////
        FamilyTree familyTree = new FamilyTree();

//        Human stepan = new Human("Степан", Gender.Male, LocalDate.of(1951, 10, 03), LocalDate.of(2015, 07, 23), null, null);
//        Human valentina = new Human("Валентина", Gender.Female, LocalDate.of(1953, 9, 11));
//        Human valentina1 = new Human("Валентина", Gender.Female, LocalDate.of(1953, 9, 11));
//        Human natasha = new Human("Наталья", Gender.Female, LocalDate.of(1960, 12, 22), LocalDate.of(2021, 1, 21), null, null, null);
//        familyTree.addHuman(stepan);
//        familyTree.addHuman(valentina);
//        familyTree.addHuman(valentina1); // добавлена для проверки работы метода @Override public boolean equals(Object obj) файла Human
//        familyTree.addHuman(natasha);
//
//        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1984, 12, 17), null, null, natasha, null);
//        familyTree.addHuman(olga);
//
//        Human petr = new Human("Петр", Gender.Male, LocalDate.of(1978, 04, 30));
//        familyTree.addHuman(petr);
//
////        olga.setMother(natasha);
//
//        petr.setMother(valentina);
//        petr.setFather(stepan);
////        petr.setMother(valentina);// проверка на вывод исключения (ребенок уже добавлен) - метод public Human addChildren(Human child)
////        petr.setFather(stepan); // проверка на вывод исключения (ребенок уже добавлен) - метод public Human addChildren(Human child)
//
//        valentina.setSpouse(stepan);
//        olga.setSpouse(petr);

////
////        System.out.println(familyTree); // вывод всех данных генеалогического древа
////        System.out.println(stepan);
////
////        System.out.println("\nВведите имя для поиска: ");
////        String name = in.nextLine();
////        System.out.println(familyTree.getByName(name));
////
////
////        System.out.println("\nВведите номер ID для поиска: ");
////        long id = in.nextLong();
////        System.out.println(familyTree.getById(id));
//
//
////
        /* Проверка работы Сериализации напрямую из класса Main

//        String fileName = "src\\Writer\\FamilyTree.txt";
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
//            System.out.println("---------------------------------------");
//            System.out.printf("Файл \"%s\" успешно создан", fileName);
//            oos.writeObject(familyTree);
//            System.out.println("\n---------------------------------------");
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }

//        String fileName = "src\\Writer\\FamilyTree.txt";
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
//            System.out.println("---------------------------------------");
//            System.out.printf("Восстановление файла \"%s\": \n", fileName);
//            System.out.println("---------------------------------------");
//            FamilyTree familyTree1 = (FamilyTree) ois.readObject();
//            System.out.println(familyTree1);
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }

*/


        FileHandler fileHandler = new FileHandler();
//        fileHandler.oos(familyTree); // проверка сохранения состояния программы (процесс записи состояния объекта в поток - сериализация)
        fileHandler.ois(fileHandler); // проверка восстановления состояния программы (процесс восстановления состояния объекта из потока - десериализация)



        in.close();
    }

}
