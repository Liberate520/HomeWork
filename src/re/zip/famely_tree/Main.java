package re.zip.famely_tree;
import re.zip.famely_tree.humans.Human;
import java.time.LocalDate;

import re.zip.famely_tree.famely_tree.FamelyTree;
import re.zip.famely_tree.humans.Gender;

public class Main {
    public static void main(String[] args) {
        FamelyTree tree = simpleTree();
        System.out.println(tree);

    }

    static FamelyTree simpleTree() {

        FamelyTree tree = new FamelyTree();

        Human viktor = new Human("Виктор", "Кондрухов", LocalDate.of(1936, 1, 1), Gender.Male);
        Human lev = new Human("Лев", "Бор", LocalDate.of(1930, 1, 1), Gender.Male);
        Human irina = new Human("Ирина", "Кондрухова", LocalDate.of(1952, 6, 29), null, Gender.Female, null, viktor);
        Human evgenij = new Human("Евгений", "Бор", LocalDate.of(1952, 4, 16), null, Gender.Male, null, lev);
        
        tree.addToFamely(irina);
        tree.addToFamely(viktor);
        tree.addToFamely(lev);
        // tree.addToFamely(irina);
        tree.addToFamely(evgenij);

        tree.setWeddding(irina, evgenij);

        Human andrej1 = new Human("Андрей", "Бор", LocalDate.of(1977, 8, 19), null, Gender.Male, irina, evgenij);
        Human pavel = new Human("Павел", "Бор", LocalDate.of(1979, 6, 29), null, Gender.Male, irina, evgenij);

        tree.addToFamely(andrej1);
        tree.addToFamely(pavel);


        // System.out.println(andrej1);
        // System.out.println(pavel);

        return tree;

    }
}
