package family__tree;

import family__tree.family_tree.FamilyTree;
import family__tree.human.Gender;
import family__tree.human.Human;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human sergey = new Human("Сергей", LocalDate.of(1920, 1, 1), Gender.Male);
        Human lena = new Human("Лена", LocalDate.of(1925, 2, 2), Gender.Female);
        Human toma = new Human("Тома", LocalDate.of(1950, 3, 3), Gender.Female);
        Human lida = new Human("Лида", LocalDate.of(1945, 4, 4), Gender.Female);
        Human vitalya = new Human("Виталя", LocalDate.of(1955, 5, 5), Gender.Male);
        Human alexander = new Human("Александр", LocalDate.of(1949, 6, 6), Gender.Male);
        Human masha = new Human("Маша", LocalDate.of(1990, 7, 7), Gender.Female);
        Human anya = new Human("Аня", LocalDate.of(1986, 8, 8), Gender.Female);
        Human kolya = new Human("Коля", LocalDate.of(1988, 9, 9), Gender.Male);
        Human vasya = new Human("Вася", LocalDate.of(2016, 10, 10), Gender.Male);
        Human klava = new Human("Клава", LocalDate.of(1920, 11, 11), Gender.Female);
        Human petr = new Human("Петр", LocalDate.of(1921, 12, 12), Gender.Male);
        Human tanya = new Human("Таня", LocalDate.of(1947, 1, 1), Gender.Female);
        Human valera = new Human("Валера", LocalDate.of(1948, 2, 2), Gender.Male);
        Human katya = new Human("Катя", LocalDate.of(2070, 3, 3), Gender.Female);

        sergey.addChild(toma);
        sergey.addChild(lida);
        sergey.addChild(vitalya);
        lena.addChild(toma);
        lena.addChild(lida);
        lena.addChild(vitalya);

        toma.addChild(masha);
        toma.addChild(anya);
        alexander.addChild(masha);
        alexander.addChild(anya);

        masha.addChild(vasya);
        kolya.addChild(vasya);

        klava.addChild(alexander);
        klava.addChild(tanya);
        petr.addChild(alexander);
        petr.addChild(tanya);

        tanya.addChild(katya);
        valera.addChild(katya);

        familyTree.addHumans(Arrays.asList(sergey, lena, toma, lida, vitalya, alexander, masha, anya, kolya, vasya, klava, petr, tanya, valera, katya));

        /* System.out.println("Дети Сергея: " + familyTree.getAllChildren(sergey));
        System.out.println("Дети Лены: " + familyTree.getAllChildren(lena));
        System.out.println("Дети Томы: " + familyTree.getAllChildren(toma));
        System.out.println("Дети Александра: " + familyTree.getAllChildren(alexander));
        System.out.println("Дети Клавы: " + familyTree.getAllChildren(klava));
        System.out.println("Дети Петра: " + familyTree.getAllChildren(petr));
        System.out.println("Дети Тани: " + familyTree.getAllChildren(tanya));
        System.out.println("Дети Валеры: " + familyTree.getAllChildren(valera));

        System.out.println("Родители Маши: " + masha.getParents());
        System.out.println("Родители Ани: " + anya.getParents());
        System.out.println("Родители Васи: " + vasya.getParents());
        System.out.println("Родители Александра: " + alexander.getParents());
        System.out.println("Родители Томы: " + toma.getParents());
        System.out.println("Родители Кати: " + katya.getParents()); */

        System.out.println(familyTree);
        familyTree.sortByName();
        System.out.println(familyTree);
        familyTree.sortByAge();
        System.out.println(familyTree);

        // Запись
//        FileHandler fileHandler = new FileHandler();
//        try {
//            fileHandler.writeToFile(familyTree, "familyTree.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Чтение
//        FamilyTree loadedFamilyTree = null;
//        try {
//            loadedFamilyTree = fileHandler.readFromFile("familyTree.txt");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Вывод
//        if (loadedFamilyTree != null) {
//            System.out.println(loadedFamilyTree);
//        } else {
//            System.out.println("Не удалось загрузить семейное древо.");
//        }

    }
}