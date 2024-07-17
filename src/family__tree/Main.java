package family__tree;

import family__tree.model.family_tree_service.FamilyTreeService;
import family__tree.model.human.Gender;
import family__tree.model.human.Human;
import family__tree.model.writer.FileHandler;
import family__tree.model.writer.Writer;
import family__tree.presenter.Presenter;
import family__tree.view.UserInterface;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FamilyTreeService<Human> familyTreeService = new FamilyTreeService<>();


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
        Human katya = new Human("Катя", LocalDate.of(2010, 3, 3), Gender.Female);

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

        familyTreeService.addHumans(Arrays.asList(sergey, lena, toma, lida, vitalya, alexander, masha, anya, kolya, vasya, klava, petr, tanya, valera, katya));

        Writer writer = new FileHandler();

        // Создаем Presenter с FamilyTree и Writer
        Presenter presenter = new Presenter(familyTreeService, writer);

        // Создаем UserInterface с Presenter
        UserInterface userInterface = new UserInterface(presenter);

        // Запускаем пользовательский интерфейс
        userInterface.start();

//        System.out.println("Дети Сергея: " + familyTree.getChildren(sergey));
//        System.out.println("Дети Лены: " + familyTree.getChildren(lena));
//        System.out.println("Дети Томы: " + familyTree.getChildren(toma));
//        System.out.println("Дети Александра: " + familyTree.getChildren(alexander));
//        System.out.println("Дети Клавы: " + familyTree.getChildren(klava));
//        System.out.println("Дети Петра: " + familyTree.getChildren(petr));
//        System.out.println("Дети Тани: " + familyTree.getChildren(tanya));
//        System.out.println("Дети Валеры: " + familyTree.getChildren(valera));
//
//        System.out.println("Родители Маши: " + masha.getParents());
//        System.out.println("Родители Ани: " + anya.getParents());
//        System.out.println("Родители Васи: " + vasya.getParents());
//        System.out.println("Родители Александра: " + alexander.getParents());
//        System.out.println("Родители Томы: " + toma.getParents());
//        System.out.println("Родители Кати: " + katya.getParents());
//
//        System.out.println(familyTree);
//        familyTree.sortByName();
//        System.out.println(familyTree);
//        familyTree.sortByAge();
//        System.out.println(familyTree);


        // Запись
        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.writeToFile(familyTreeService, "familyTree.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение
        FamilyTreeService loadedFamilyTreeService = null;
        try {
            loadedFamilyTreeService = fileHandler.readFromFile("familyTree.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Вывод
        if (loadedFamilyTreeService != null) {
            System.out.println(loadedFamilyTreeService);
        } else {
            System.out.println("Не удалось загрузить семейное древо.");
        }

    }
}
