package homeWork;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();


        Human human1 = new Human("John", "Smith", Gender.Male, LocalDate.of(1990, 1, 18), "Jane Doe", "Alice Johnson, Bob Brown");
        Human human2 = new Human("Jane", "Doe", Gender.Female, LocalDate.of(1992, 5, 21),"неизвестно", "Charlie Davis John Smith" );
        Human human3 = new Human("Alice", "Johnson", Gender.Female, LocalDate.of(1985, 8, 3),"John Smith", "отсутствует"  );
        Human human4 = new Human("Bob", "Brown", Gender.Male, LocalDate.of(1978, 12, 8),"John Smith", "отсутствует" );
        Human human5 = new Human("Charlie", "Davis", Gender.Male, LocalDate.of(2000, 5, 6) ,"Jane Doe", "Alice Johnson" );


        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);
        tree.addHuman(human5);

        tree.removeHuman(human2);

        System.out.println(tree.getFamilyTree());

        System.out.println(tree.findChildren(tree));


        
    }
}