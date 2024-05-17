import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human h1 = new Human("Nikolai", Gender.Male , LocalDate.of(1957, 12, 22));
        Human h2 = new Human("Irina", Gender.Female, LocalDate.of(1959, 11, 16));
        Human h3 = new Human("Anna", Gender.Female, LocalDate.of(1985, 5, 14));
        Human h4 = new Human("ALeksandr", Gender.Male, LocalDate.of(1988, 6, 6));
        h3.addParent(h1);
        h3.addParent(h2);
        h4.addParent(h1);
        h4.addParent(h2);


        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(h1);
        familyTree.addMember(h2);
        familyTree.addMember(h3);
        familyTree.addMember(h4);

        FileHandler handler = new FileHandler();
        handler.saveTree(familyTree);
        FamilyTree newTree = handler.downloadTree();
        System.out.println(newTree.MembersInfo());
    }
}