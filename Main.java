package homeWork.src;

import homeWork.src.piple.Human;
import homeWork.src.tree.Tree;
import homeWork.src.piple.Human;
import homeWork.src.piple.Gender;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Tree tree = testTree();

        System.out.println(tree);
    }
    private static Tree testTree() {
        Tree tree = new Tree();

        Human ivan = new Human("Ivan",Gender.Male, LocalDate.of(1984,12,15) );
        Human ulya = new Human("Ulya",Gender.Female, LocalDate.of(1986,1,10) );

        tree.add(ivan);
        tree.add(ulya);
        tree.setWedding(ivan, ulya);

        Human igor = new Human("Igor",Gender.Male, LocalDate.of(2014,8,20),ivan,ulya );
        Human olga = new Human("Olga",Gender.Female, LocalDate.of(2015,12,30),igor,ulya );

        tree.add(igor);
        tree.add(olga);

        Human grandMother = new Human("Elis", Gender.Female,LocalDate.of(1966,7,14));
        grandMother.addChild(ivan);
        tree.add(grandMother);
        return tree;

    }







}
