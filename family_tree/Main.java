package homeWork.family_tree;

import homeWork.family_tree.family.FamilyTree;
import homeWork.family_tree.human.Gender;
import homeWork.family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();


        Human person1 = new Human("Инна", LocalDate.of(1976, 5, 16), Gender.Female);
        Human person2 = new Human("Роман", LocalDate.of(1978, 6, 25), Gender.Male);
        Human person3 = new Human("Валерий", LocalDate.of(1953, 2, 10), Gender.Male);
        Human person4 = new Human("Виктория", LocalDate.of(1955, 12, 23), Gender.Female);
        Human person5 = new Human("Вера", LocalDate.of(1998, 7, 1), Gender.Female);
        Human person6 = new Human("Карина", LocalDate.of(2002, 9, 21), Gender.Female);

        person1.setFather(person3);
        person1.setMother(person4);
        person1.addChild(person5);
        person1.addChild(person6);
        person2.addChild(person5);
        person2.addChild(person6);
        person4.setDayOfDeath(LocalDate.of(2022, 2, 24));

        familyTree.addHuman(person1);
        familyTree.addHuman(person2);

        System.out.println(familyTree);
    }
}