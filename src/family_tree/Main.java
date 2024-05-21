package family_tree;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("John", Gender.Male, LocalDate.of(1965, 12, 10));
        Human human2 = new Human("Mary", Gender.Female, LocalDate.of(1967, 4, 22));
        Human human3 = new Human("Peter", Gender.Male, LocalDate.of(1990, 3, 27), human1, human2);

        human1.addChild(human3.getName());
        human2.addChild(human3.getName());

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        System.out.println(familyTree.toString());
    }
}
