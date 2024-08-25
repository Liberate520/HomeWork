package family_free.family.buider;

import family_free.family.buider.FamilyTree.FamilyTree;
import family_free.family.buider.human.Gender;
import family_free.family.buider.human.Human;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/family_free/writer/tree.txt";
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Sara", Gender.Female,LocalDate.of(2004,12,10));
        Human human2 = new Human("Mike",Gender.Male,LocalDate.of(1999,11,20));
        Human human3 = new Human("Dina",Gender.Male,LocalDate.of(2005,11,20));
        Human human4 = new Human("Lili",Gender.Male,LocalDate.of(2003,11,20));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);

        System.out.println(familyTree);
        familyTree.sortByAge();
        System.out.println(familyTree);
        familyTree.sortByName();
        System.out.println(familyTree);
    }
}

