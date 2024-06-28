import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = createFamilyTree();

        // Найти человека по имени и получить его детей
        Human person = familyTree.findHumanByName("Иван");
        if (person != null) {
            List<Human> children = familyTree.getChildrenOf(person);
            System.out.println("Children of " + person.getName() + ":");
            for (Human child : children) {
                System.out.println(child.getName() + ", Age: " + child.getAge());
            }
        } else {
            System.out.println("Person not found.");
        }
    }

    private static FamilyTree createFamilyTree() {
        FamilyTree familyTree = new FamilyTree();

        Human ivan = new Human("Иван", LocalDate.of(1974, 6, 1), Gender.MALE);
        Human maria = new Human("Мария", LocalDate.of(1979, 8, 15), Gender.FEMALE);
        Human mikhail = new Human("Михаил", LocalDate.of(2004, 11, 30), Gender.MALE);
        Human anna = new Human("Анна", LocalDate.of(2006, 5, 25), Gender.FEMALE);

        ivan.addChild(mikhail);
        ivan.addChild(anna);

        familyTree.addHuman(ivan);
        familyTree.addHuman(maria);
        familyTree.addHuman(mikhail);
        familyTree.addHuman(anna);

        return familyTree;
    }
}