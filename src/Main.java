import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human human1 = new Human("Василий", Gender.Male, LocalDate.of(2001, 10, 2), null, null, null, null, null);
        Human human2 = new Human("Светлана", Gender.Female, LocalDate.of(2002, 11, 3), null, null, null, null, null);

        FamilyTree familyTree = new FamilyTree();

        familyTree.add(human1);
        familyTree.add(human2);
        familyTree.setWadding(human1.getId(), human2.getId());


        Human human3 = new Human("Виталий", Gender.Male, LocalDate.of(2022, 10, 6), null, human1, human2, null, null);

        familyTree.add(human3);

        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
        FamilyTree familyTree2 = fileHandler.load();

        System.out.println(familyTree2.searchByName("Виталий"));
    }
}