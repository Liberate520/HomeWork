import family_tree.humans.Gender;
import family_tree.humans.Human;
import family_tree.tree.FamilyTree;
import family_tree.writer.FileHandler;
import family_tree.writer.Writable;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>(); //Создаем дерево ледей

        //Первая промать
        Human commonMother = new Human("Марина",
                new Date(1812 - 1900, Calendar.APRIL, 10),
                new Date(1887 - 1900, Calendar.MAY, 12),
                Gender.Female);

        //Первый проотец
        Human commonFather = new Human("Вадим",
                new Date(1810 - 1900, Calendar.MAY, 15),
                new Date(1888 - 1900, Calendar.JUNE, 12),
                Gender.Male);

        Human human1 = new Human("Сергей",
                commonMother,
                commonFather,
                new Date(1824 - 1900, 6, 23),
                new Date(1901 - 1900, 7, 27),
                Gender.Male);

        commonMother.addChild(human1);
        commonFather.addChild(human1);

        familyTree.addToTree(commonMother);
        familyTree.addToTree(commonFather);
        familyTree.addToTree(human1);

        System.out.println(familyTree);

        Writable writable = new FileHandler();
        writable.writeToFamilyTree(familyTree, "savesFamilyTree.ftr");

        FamilyTree<Human> familyTreeRead = writable.readFromFamilyTree("savesFamilyTree.ftr");

        System.out.println("**********************************************");
        System.out.println("Востановленное древо:");
        System.out.println(familyTreeRead);

        System.out.println("**********************************************");
        System.out.println("\n-------------Перебор через foreach-----------");
        for (Human man : familyTree){
            System.out.println(man);
        }

        System.out.println("\n-------------Сортировка по имени-----------");
        familyTree.sortByName();
        System.out.println(familyTree);

        System.out.println("\n-------------Сортировка по возрасту-----------");
        familyTree.sortByAge();
        System.out.println(familyTree);

        System.out.println("\n-------------Сортировка по дате рождения-----------");
        familyTree.sortByBirthDate();
        System.out.println(familyTree);

        System.out.println("\n-------------Сортировка по дате смерти-----------");
        familyTree.sortByDeathDate();
        System.out.println(familyTree);
    }
}
