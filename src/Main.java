import Human.Human;

import java.time.LocalDate;
import java.util.Date;

import Human.Gender;
import Tree.FameleTree;

public class Main {


    //Не успел доделать еще


    public static void main(String[] args) {
        Human ignat = new Human("Ignat", LocalDate.of(2000,9, 10),Gender.Male );
        Human lol = new Human("kol", LocalDate.of(2000,9, 10),Gender.Male );
        Human olya = new Human("olya", LocalDate.of(2000,9, 10),Gender.Famale );
        Human surik = new Human("Surik", LocalDate.of(2000,9, 10),Gender.Male );
        FameleTree tree = new FameleTree("Orlovi");
        tree.add(ignat);
        tree.add(lol);

        tree.addParents(0,olya,surik);
        tree.printTree();

    }
}