import java.time.LocalDate;

import Family_tree.FamiliTree;
import Family_tree.Human;

public class Main {

    public static void main(String[] args) {
        FamiliTree familiTree = new FamiliTree();
        Human father = new Human("Victor", LocalDate.of(1961, 12, 19), LocalDate.of(0000, 1, 1), null, null, Family_tree.Gender.MALE);
        Human mother = new Human("Evgehiya", LocalDate.of(1964, 4, 7), LocalDate.of(2005, 12, 18), null, null, Family_tree.Gender.FEMALE);
        Human me = new Human("Maksim", LocalDate.of(1985, 4, 19), LocalDate.of(0000, 1, 1), mother, father, Family_tree.Gender.MALE);

        familiTree.addHuman(me);
        familiTree.addHuman(mother);

        me.getChildren();

        System.out.println(me);
        System.out.println(familiTree);
        // System.out.println(mother);
    }
}