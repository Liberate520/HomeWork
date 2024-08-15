package family_free;

import family_free.FamilyTree.FamilyTree;
import family_free.human.Gender;
import family_free.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Sara", Gender.Female,LocalDate.of(2004,12,10));
        Human human2 = new Human("Mike",Gender.Male,LocalDate.of(2000,11,20));
        Human human3 = new Human("Mike", Gender.Male,LocalDate.of(1999,9,23));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        human1.addChild(human2);
        human1.addChild(human3);

//        System.out.println(human2.getParantsToString());
//
//        System.out.println(human3.AboutChidren());
//        System.out.println(human1.AboutChidren());

        System.out.println(familyTree);
        //System.out.println(familyTree.getAllDescendants(human1));
    }
}