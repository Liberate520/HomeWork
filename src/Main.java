import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human person1 = new Human("Khrushev Nikita Sergeevich", LocalDate.of(1894, 4, 15), Gender.Male);
        person1.setDod(LocalDate.of(1971, 9, 11));
        Human person2 = new Human("Khrushev Sergei Nikitich", LocalDate.of(1935, 7, 2), Gender.Male);
        Human person3 = new Human("Khrushev Leonid Nikitich", LocalDate.of(1917, 11, 10), Gender.Male);
        Human person4 = new Human("Kucharchuk-Khrusheva Nina Petrovna", LocalDate.of(1900, 4, 14), Gender.Female);
        person4.setDod(LocalDate.of(1984, 8, 13));


        /*
        Create the union of two partners and add of their kids
         */
        person1.setPartner(person4);
        person1.addChildFromThisPartner(person4, person2);
        person1.addChildFromThisPartner(person4, person3);

        /*
        Add the information about parents
         */
        person3.setFather(person1);
        person3.setMother(person4);

        person2.setFather(person1);
        person2.setMother(person4);


        /*
        Create the family tree
         */
        FamilyTree tree = new FamilyTree();
        tree.addPersonToFamily(person1, 2);
        tree.addPersonToFamily(person4, 2);
        tree.addPersonToFamily(person2, 1);
        tree.addPersonToFamily(person3, 1);


    }
}