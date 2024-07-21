package family_tree;

import family_tree.FamilyTree;
import family_tree.Human;
import static java.time.LocalDate.of;
import java.time.LocalDate;


public class Main {


    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human bobby = new Human("Bobby Alien (father family)", of(1999, 07, 14), of(2020, 12, 11), Gender.Male, null, null);
        Human katrin = new Human("Katrin Alien (motherFamily)", of(2000, 03, 07), null, Gender.Female, null, null);

        familyTree.addMember(bobby);
        familyTree.addMember(katrin);
        // Создал Хьюманов


        Human franklin = new Human("Franklin", of(2020, 03, 03), null, Gender.Male, bobby, katrin);
        Human lester = new Human("Lesterina", of(2021, 01, 01), null, Gender.Female, franklin, katrin);

//        bobby.addChild(franklin);
//        bobby.addChild(lester);
//        katrin.addChild(franklin);
//        katrin.addChild(lester);

//        familyTree.addMember(franklin);
//        familyTree.addMember(lester);

        // Не получается реализовать адекватное поведение детей при их добавлении :(


        System.out.println("-------------------");
        System.out.println(familyTree);
        System.out.println("_____________");



//        for (Human child : familyTree.getChildrenOf(katrin)) {
//            System.out.println(child);
//        }
    }
}