package ru.gb.family_tree;

import java.time.LocalDate;

import static ru.gb.family_tree.Gender.Female;
import static ru.gb.family_tree.Gender.Male;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        String filePath = "src\\ru\\gb\\family_tree\\tree.txt";

        Human human1 = new Human("Maria", "Pushkin", LocalDate.of(1700, 2, 25), LocalDate.of(1790, 5, 3), Female);
        Human human2 = new Human("Pavel", "Pushkin", LocalDate.of(1695, 8, 15), LocalDate.of(1790, 5, 3), Male);
        Human human3 = new Human("Alexander", "Pushkin", LocalDate.of(1730, 5, 21), LocalDate.of(1767, 11, 4), Male, human1, human2);
        Human human4 = new Human("Michael", "Pushkin", LocalDate.of(1730, 5, 21), LocalDate.of(1759, 5, 14), Male, human1, human2);
        Human human5 = new Human("Svetlana", "Pushkin", LocalDate.of(1735, 4, 13), LocalDate.of(1770, 1, 2), Female);
        Human human6 = new Human("Alena", "Pushkin", LocalDate.of(1733, 9, 23), LocalDate.of(1772, 5, 1), Female);
        Human human7 = new Human("Konstantin", "Pushkin", LocalDate.of(1755, 5, 15), LocalDate.of(1820, 7, 10), Male, human3, human5);
        Human human8 = new Human("Polina", "Pushkin", LocalDate.of(1758, 10, 4), LocalDate.of(1825, 2, 25), Female, human4, human6);
        Human human9 = new Human("Sergei", "Pushkin", LocalDate.of(1761, 4, 29), LocalDate.of(1827, 12, 31), Male, human4, human6);

        human1.addChilds(human3, human4);
        human2.addChilds(human3, human4);
        human3.addChilds(human7);
        human5.addChilds(human7);
        human4.addChilds(human8, human9);
        human6.addChilds(human8, human9);


        familyTree.addHumansInFamTree(human1, human2, human3, human4
                , human5, human6, human7, human8, human9);

//        familyTree = load(filePath);

        System.out.println(familyTree);

        save(familyTree, filePath);
    }


    private static FamilyTree load(String filePath){
        Writeable writeable = new FileHandler();
        return (FamilyTree) writeable.read(filePath);
    }


    private static void save(FamilyTree familyTree, String filePath){
        Writeable writeable = new FileHandler();
        writeable.save(familyTree, filePath);
    }
}
