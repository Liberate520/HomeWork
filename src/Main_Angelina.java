package family_tree;

import family_tree.family_tree_Angelina.FamilyTree;
import family_tree.Writer.WriterHandler;
import family_tree.Writer.FileHandler;
import family_tree.human.Human;
import family_tree.human.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main_Angelina {
    public static void main(String[] args) {
        // Создание бабушек и дедушек по линии Гомера
        Human grandMotherHomer = new Human("Mona Simpson", Gender.FEMALE, LocalDate.of(1940, 7, 11));
        Human grandFatherHomer = new Human("Abraham Jay-Jebediah 'Abe' Simpson", Gender.MALE, LocalDate.of(1939, 8, 8));

        // Создание родителей
        Human homer = new Human("Homer Filipp Simpson", Gender.MALE, LocalDate.of(1962, 7, 10), grandMotherHomer, grandFatherHomer);

        // Создание бабушек и дедушек по линии Маржори
        Human grandMotherMarge = new Human("Jacqueline Gurney", Gender.FEMALE, LocalDate.of(1941, 4, 11));
        Human grandFatherMarge = new Human("Clancy Bouvier", Gender.MALE, LocalDate.of(1937, 2, 8));

        // Создание родителей
        Human marge = new Human("Marjiorie Jacqueline (Marge) Simpson", Gender.FEMALE, LocalDate.of(1964, 10, 2), grandMotherMarge, grandFatherMarge);

        // Создание детей
        Human bart = new Human("Bartholomew Jo-Jo 'Bart' Simpson", Gender.MALE, LocalDate.of(1990, 12, 15), marge, homer);
        Human lisa = new Human("Lisa Marie Simpson", Gender.FEMALE, LocalDate.of(1993, 9, 17), marge, homer);
        Human maggie = new Human("Margaret Lenny 'Maggie' Simpson", Gender.FEMALE, LocalDate.of(1999, 2, 27), marge, homer);

        // Установить супругов
        homer.setSpouse(marge); // Установка супруги
        marge.setSpouse(homer); // Установка мужа

        // Создание списка членов семьи
        List<Human> familyMembers = new ArrayList<>();
        familyMembers.add(homer);
        familyMembers.add(marge);
        familyMembers.add(grandMotherHomer);
        familyMembers.add(grandFatherHomer);
        familyMembers.add(grandMotherMarge);
        familyMembers.add(grandFatherMarge);
        familyMembers.add(bart);
        familyMembers.add(lisa);
        familyMembers.add(maggie);

        // Создание и вывод семейного дерева
        FamilyTree familyTree = new FamilyTree(familyMembers);
        String familyTreeInfo = familyTree.displayFamilyTree();

        // Вывод информации о семейном дереве
        System.out.println(familyTreeInfo);
    }
}



















































































/*import java.time.LocalDate;
public class Main_Angelina {
    public static void main(String[] args) {
        FamilyTree tree = testTree();

        System.out.println(tree);

    }

    private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human homer = new Human("Homer Filipp Simpson", Gender.Male, LocalDate.of(1962, 7, 10));
        Human marge = new Human("Marjiorie Jacqueline (Marge) Simpson", Gender.Female, LocalDate.of(1964, 10, 2));

        tree.add(homer);
        tree.add(marge);
        tree.setWedding(homer,marge);


        Human bart = new Human("Bartholomew Jo-Jo 'Bart' Simpson", Gender.Male,LocalDate.of(1990, 12, 15), homer, marge);
        Human lisa = new Human("Lisa Marie Simpson", Gender.Female,LocalDate.of(1993, 9, 17), homer, marge);
        Human maggie = new Human("Margaret Lenny 'Maggie' Simpson", Gender.Female,LocalDate.of(1999, 2, 27), homer, marge);

        tree.add(bart);
        tree.add(lisa);
        tree.add(maggie);

        Human grandMotherHomer = new Human("Mona Simpson", Gender.Female,LocalDate.of(1940,7,11));
        grandMotherHomer.addChild(homer);

        Human grandFatherHomer = new Human("Abraham Jay-Jebediah 'Abe' Simpson", Gender.Male,LocalDate.of(1939,8,8));
        grandFatherHomer.addChild(homer);

        tree.add(grandMotherHomer);
        tree.add(grandFatherHomer);


        Human grandMotherMarge = new Human("Jacqueline Gurney", Gender.Female,LocalDate.of(1941,4,11));
        grandMotherMarge.addChild(marge);

        Human grandFatherMarge = new Human("Clancy Bouvier", Gender.Male,LocalDate.of(1937,2,8));
        grandFatherMarge.addChild(marge);

        tree.add(grandMotherMarge);
        tree.add(grandFatherMarge);
        return tree;


    }
}
*/