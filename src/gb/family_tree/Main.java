//Lyalin
package gb.family_tree;

import ru.gb.family_tree.humans.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

import static ru.gb.family_tree.humans.Gender.Female;
import static ru.gb.family_tree.humans.Gender.Male;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human hum1 = new Human("Pavel", Male, LocalDate.of(1953,11,3));
        Human hum2 = new Human("Olga", Female, LocalDate.of(1980,9,12));
        Human hum3 = new Human("Gleb", Male,
                LocalDate.of(1978,7,23),
                LocalDate.of(2020,3,14));

        familyTree.addHuman(hum1);
        familyTree.addHuman(hum2);
        familyTree.addHuman(hum3);

        System.out.println(familyTree);
    }

}