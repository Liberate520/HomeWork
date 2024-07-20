import family.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human();
        human1.setName("Mike");
        human1.setId(3);
        human1.setGender(Gender.MALE);
        human1.setBirthDate(LocalDate.of(1967,5,6));

        Human human2 = new Human(0,"Lola", Gender.FEMALE, LocalDate.of(1969,11, 9));
        human2.setSpouse(human1);


        human1.setSpouse(human2);

        Human human3 = new Human(1, "Sara", Gender.FEMALE, LocalDate.of(1991, 1,5));
        human3.setFather(human1);
        human3.setMother(human2);

        human2.setChildren(human3);
        human1.setChildren(human3);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        System.out.println(familyTree);


    }
}
