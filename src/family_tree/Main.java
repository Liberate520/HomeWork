package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args){
        FamilyTree tree = new FamilyTree();

        Human oleg = new Human("Oleg", LocalDate.of(1964, 7, 2), Gender.Male);
        Human olga = new Human("Olga", LocalDate.of(1969, 3, 8), Gender.Female);

        tree.add(oleg);
        tree.add(olga);

        tree.setWedding(oleg, olga);

        Human christina = new Human("Кристина", LocalDate.of(1989, 2, 23), Gender.Female, oleg, olga);
        Human semiyon = new Human("Семен", LocalDate.of(1994, 5, 21), Gender.Male);

        tree.add(christina);
        tree.add(semiyon);

        Human grandMother = new Human("Лариса", LocalDate.of(1945, 7, 22), Gender.Female);
        grandMother.addChild(oleg);
        oleg.addChild(semiyon);

        tree.add(grandMother);

        System.out.println(tree);
    }
}
