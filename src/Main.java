import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human h1 = new Human("Andrey", Gender.Male, LocalDate.of(1971, 10, 7));
        Human h2 = new Human("Irina", Gender.Female, LocalDate.of(1975, 3, 29));
        Human h3 = new Human("Ekaterina", Gender.Female, LocalDate.of(1994, 3, 2));
        Human h4 = new Human("Ilya", Gender.Male, LocalDate.of(2000, 6, 5));
        h3.addParent(h1);
        h3.addParent(h2);
        h4.addParent(h1);
        h4.addParent(h2);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(h1);
        familyTree.addMember(h2);
        familyTree.addMember(h3);
        familyTree.addMember(h4);

        //System.out.println(familyTree.MembersInfo());

        FileHandler handler = new FileHandler();
        handler.saveTree(familyTree);
        FamilyTree newTree = handler.downloadTree();
        System.out.println(newTree.MembersInfo());
    }
}
