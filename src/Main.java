import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();

        System.out.println(tree);
    }

    private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human human1 = new Human("Ян", LocalDate.of(1977, 8, 30), Gender.Male);
        Human human2 = new Human("Светлана", LocalDate.of(1977, 5, 17), Gender.Female);
        Human human3 = new Human("Маргарита", LocalDate.of(1997, 2, 16), Gender.Female);
        Human human4 = new Human("Нина", LocalDate.of(1949, 5, 11), LocalDate.of(2012, 6, 15), Gender.Female);
        human3.addParent(human1);
        human3.addParent(human2);
        human2.addChild(human3);
        human4.addChild(human1);

        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        return tree;
    }
}
