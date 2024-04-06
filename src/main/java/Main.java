
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        //Родители
        Human ivan = new Human("Иван", LocalDate.of(1940,7,28), Gender.Male);
        Human olga = new Human("Ольга", LocalDate.of(1940,7,28), Gender.Female);
        familyTree.add(ivan);
        familyTree.add(olga);

        //Дети
        Human alexandr = new Human("Александр", LocalDate.of(1960,5,9),Gender.Male);
        Human nadezda = new Human("Надежда", LocalDate.of(1965,1,1),Gender.Female);
        familyTree.add(alexandr);
        familyTree.add(nadezda);
        alexandr.addParent(ivan);
        alexandr.addParent(olga);


        //Внуки
        Human alice = new Human("Алиса", LocalDate.of(1985, 3, 8), Gender.Female);
        Human kamila = new Human("Камила", LocalDate.of(1990, 8, 21), Gender.Female);
        familyTree.add(alice);
        familyTree.add(kamila);
        alexandr.addChildren(alice);
        alexandr.addChildren(kamila);
        nadezda.addChildren(alice);
        nadezda.addChildren(kamila);

        System.out.println("\n|___________________________|\n");
        System.out.println(familyTree);

    }
}
