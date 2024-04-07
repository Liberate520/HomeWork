import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Иван","Иванович","Кочетков",
                Gender.MALE, LocalDate.of(1880,8,24),
                LocalDate.of(1919,7,8),null,null,-3);
        Human human2 = new Human("Александра","Ивановна","Кочеткова",
                Gender.MALE, LocalDate.of(1912,5,10),
                LocalDate.of(1978,3,17),null,null,-3);
        tree.add(human2);
        human1.addChild(human2);
        System.out.println(human1);
        System.out.println(human2);

    }
}
