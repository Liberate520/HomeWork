import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree romanovFamilyTree = new FamilyTree();

        Human human1 = new Human("Иван", Gender.MALE, LocalDate.of(1985,5,14));
        Human human2 = new Human("Мария", Gender.FEMALE, LocalDate.of(1986,8,5));
        Human human3 = new Human("Павел", Gender.MALE, LocalDate.of(2015,1,2));

        romanovFamilyTree.addHuman(human1);
        romanovFamilyTree.addHuman(human2);
        romanovFamilyTree.addHuman(human3);

        romanovFamilyTree.addParentChildRelation(human1, human3);
        romanovFamilyTree.addParentChildRelation(human2, human3);

        List<Human> human1_Children = romanovFamilyTree.getChildren(human1);
        System.out.println("\nДети " + human1.getName() + "-а: ");
        for (Human child : human1_Children) {
            System.out.println(child);
        }

        System.out.println("\nСемейное древо Романовых: ");
        romanovFamilyTree.printFamilyTree(human3);
    }
}