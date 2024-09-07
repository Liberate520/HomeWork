import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Petr", "Petrov", LocalDate.of(1990, 1, 1), Gender.male);
        Human human2 = new Human("Elena", "Petrova", LocalDate.of(1990, 2, 25), Gender.female);
        Human human3 = new Human("Polina", "Petrova", LocalDate.of(2010, 3, 15), Gender.female);

        human2.setChildren(human3);
        System.out.println(human1.getChildren());
        System.out.println(human2.getChildren());

        System.out.println(human2.getBirthDate());
        System.out.println(human2.getDeathDate());

        human3.setFather(human1);
        System.out.println(human3.getFather());
        System.out.println(human3.getMother());

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        System.out.println(familyTree.toString());

    }
}
