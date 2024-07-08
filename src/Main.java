import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human mariya = new Human("Mariya", Gender.FEMALE, LocalDate.of(1980, 1, 1));
        Human pyotr = new Human("Pyotr", Gender.MALE, LocalDate.of(1981, 2, 2));
        Human alisa = new Human("Alisa", Gender.FEMALE, LocalDate.of(2005, 3, 3));
        Human vladimir = new Human("Vladimir", Gender.MALE, LocalDate.of(2008, 4, 4));

        FamilyTree tree = new FamilyTree();
        tree.addMember(mariya);
        tree.addMember(pyotr);
        tree.addMember(alisa);
        tree.addMember(vladimir);

        pyotr.addChild(alisa);
        pyotr.addChild(vladimir);

        mariya.addChild(alisa);
        mariya.addChild(vladimir);

        System.out.println("Family Tree:");
        System.out.println(tree);

        System.out.println("Children of Pyotr:");
        List<Human> pyotrChildren = tree.getChildrenOf("Pyotr");
        for (Human child : pyotrChildren) {
            System.out.println(child);
        }

        System.out.println("Children of Mariya:");
        List<Human> mariyaChildren = tree.getChildrenOf("Mariya");
        for (Human child : mariyaChildren) {
            System.out.println(child);
        }

        System.out.println("Parents of Alisa:");
        List<Human> alisaParents = tree.getParentsOf("Alisa");
        for (Human parent : alisaParents) {
            System.out.println(parent);
        }

    }

}