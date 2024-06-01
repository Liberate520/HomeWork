import pack.Family_Tree;
import pack.Gender;
import pack.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human familyTree = new Human();
        Human human1 = new Human("Jack", LocalDate.of(2000, 10, 3), Gender.Male);
        Human human2 = new Human("Alisa", LocalDate.of(1998, 5, 20),Gender.Female);
        Human human3 = new Human("Artur", LocalDate.of(2023, 1, 21), Gender.Male);
        Human human4 = new Human("Fedya", LocalDate.of(2022, 1, 21), Gender.Male);
        Human human5 = new Human("Nina", LocalDate.of(2023, 1, 21), Gender.Female);


        human1.setDeathDate(LocalDate.of(2021, 10, 2));
        System.out.println(human1.getAge());
        human2.addChild(human3);
        human2.addChild(human4);
        human2.addChild(human5);

        human1.getInfo();
        human2.getInfo();
        human3.getInfo();
        human1.setSpouse(human2);
        human1.getInfo();
        human2.getInfo();
        human3.getInfo();
        human4.getBrothers();
        human4.getSisters();


        familyTree.printFamilyTree();


    }


}
