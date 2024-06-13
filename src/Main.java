import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*
        FamilyTree tree = createTree();
        System.out.println(tree.getAllInfo());
        save(tree, "Gluhov_ft.dat");
        */

        FamilyTree tree = read("Gluhov_ft.dat");
        System.out.println(tree.getAllInfo());

    }
    public static void save(FamilyTree tree, String fileName) {
        Writable writable = new FileHandler();
        writable.save((Serializable) tree, fileName);

        //System.out.println(tree.getAllInfo());
        //save(tree, "Gluhov_ft.dat");
    }
    public static FamilyTree read(String fileName) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read((fileName));

        //FamilyTree tree = (FamilyTree) rw.readTree("Gluhov_ft.dat");

        //System.out.println(tree.getAllInfo());
    }
    private static FamilyTree createTree(){
        FamilyTree tree = new FamilyTree();
        Human polina = new Human("Полина", "Андроникова", LocalDate.of(1914, 12, 31),LocalDate.of(1972, 5, 15), Gender.Female);
        Human anton = new Human("Антон", "Пиантковский", LocalDate.of(1910, 6, 15),LocalDate.of(1943, 2, 3), Gender.Male);
        Human dariya = new Human("Людмила", "Пиантковская", LocalDate.of(1926, 8, 1), Gender.Female, polina, anton);

        tree.add(polina);
        tree.add(anton);
        tree.add(dariya);
        return tree;
    }
}