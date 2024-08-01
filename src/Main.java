import familiTree.FamilyTree;
import human.Gender;
import human.Human;
import service.Service;
import writer.FileHandler;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        FamilyTree familyTree = new FamilyTree();
        Service service = new Service();

        Human stepan = new Human("Степан", Gender.Male, LocalDate.of(1951, 10, 03), LocalDate.of(2015, 07, 23), null, null);
        Human valentina = new Human("Валентина", Gender.Female, LocalDate.of(1953, 9, 11));
        Human valentina1 = new Human("Валентина", Gender.Female, LocalDate.of(1953, 9, 11));
        Human natasha = new Human("Наталья", Gender.Female, LocalDate.of(1960, 12, 22), LocalDate.of(2021, 1, 21), null, null, null);
        familyTree.addHuman(stepan);
        familyTree.addHuman(valentina);
        familyTree.addHuman(valentina1); // добавлена для проверки работы метода @Override public boolean equals(Object obj) файла Human
        familyTree.addHuman(natasha);

        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1984, 12, 17), null, null, natasha, null);
        familyTree.addHuman(olga);

        Human petr = new Human("Петр", Gender.Male, LocalDate.of(1978, 04, 30));
        familyTree.addHuman(petr);

        petr.setMother(valentina);
        petr.setFather(stepan);
//        petr.setMother(valentina);// проверка на вывод исключения (ребенок уже добавлен) - метод public Human addChildren(Human child)
//        petr.setFather(stepan); // проверка на вывод исключения (ребенок уже добавлен) - метод public Human addChildren(Human child)

        valentina.setSpouse(stepan);
        olga.setSpouse(petr);
        olga.setMother(natasha);

//        familyTree.sortByName(); // сортировка по имени
//        System.out.println("Сортировка генеалогического древа по имени человека");
//        System.out.println(familyTree);
//
//        familyTree.sortByAge(); // сортировка по возрасту
//        System.out.println("Сортировка генеалогического древа по возрасту человека");
//        System.out.println(familyTree);
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


//        FileHandler fileHandler = new FileHandler();
////        fileHandler.oos(familyTree); // проверка сохранения состояния программы (процесс записи состояния объекта в поток - сериализация)
//        fileHandler.ois(fileHandler); // проверка восстановления состояния программы (процесс восстановления состояния объекта из потока - десериализация)


        in.close();
    }

}
