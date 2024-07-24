import FamiliTree.FamilyTree;
import Human.Gender;
import Human.Human;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        System.out.println(Arrays.toString(Gender.values()));     // проверка вывода формата Gender
//        Gender gender = Gender.Female;
//        System.out.println(gender);


        FamilyTree familyTree = new FamilyTree();

        Human stepan = new Human("Stepan", Gender.Male, LocalDate.of(1951, 10, 03), LocalDate.of(2015, 07, 23), null, null);
        Human valentina = new Human("Valentina", Gender.Female, LocalDate.of(1953, 9, 11));
        Human valentina1 = new Human("Valentina", Gender.Female, LocalDate.of(1953, 9, 11));
        Human natasha = new Human("Natasha", Gender.Female, LocalDate.of(1960, 12, 22), LocalDate.of(2021, 1, 21), null, null, null);
        familyTree.addHuman(stepan);
        familyTree.addHuman(valentina);
        familyTree.addHuman(valentina1); // добавлена для проверки работы метода @Override public boolean equals(Object obj) файла Human
        familyTree.addHuman(natasha);

        Human olga = new Human("Olga", Gender.Female, LocalDate.of(1984, 12, 17), null, null, natasha, null);
        familyTree.addHuman(olga);

        Human petr = new Human("Petr", Gender.Male, LocalDate.of(1978, 04, 30));
        familyTree.addHuman(petr);

//        olga.setMother(natasha);

        petr.setMother(valentina);
        petr.setFather(stepan);
        petr.setMother(valentina);// проверка на вывод исключения (ребенок уже добавлен) - метод public Human addChildren(Human child)
        petr.setFather(stepan); // проверка на вывод исключения (ребенок уже добавлен) - метод public Human addChildren(Human child)

        valentina.setSpouse(stepan);
        olga.setSpouse(petr);


        System.out.println(familyTree); // вывод всех данных генеалогического древа
        System.out.println(stepan);

        System.out.println("\nВведите имя для поиска: ");
        String name = in.nextLine();
        System.out.println(familyTree.getByName(name));


        System.out.println("\nВведите номер ID для поиска: ");
        long id = in.nextLong();
        System.out.println(familyTree.getById(id));


in.close();
    }

}

// в main отобразить, как работать с проектом. Создать классы и отобразить, как с ними работать (взаимодействовать)
// Внести несколько людей. Добавить в семейное древо
// Вывести, найти информацию о каком-то человеке