import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/writer/tree.txt";

    public static void main(String[] args) {
//        FamilyTree tree = load();
        FamilyTree tree = ft();
        save(tree);

        System.out.println(tree);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

    public static FamilyTree ft() {
        FamilyTree ft = new FamilyTree();
        Human oleg = new Human("Oleg", Gender.Male, LocalDate.of(1995, 7, 2));
        Human nastya = new Human("Nastya", Gender.Female, LocalDate.of(2001, 3, 16));
        ft.add(oleg);
        ft.add(nastya);
        Human nadya = new Human("Nadezhda", Gender.Female, LocalDate.of(1974, 6, 26));
        Human andrey = new Human("Andrey", Gender.Male, LocalDate.of(1970, 7, 25));
        ft.setWedding(oleg, nastya);
        Human katya = new Human("Katya", Gender.Female, LocalDate.of(2004, 12, 24), andrey, nadya);
        ft.add(katya);
        ft.add(nadya);
        ft.add(andrey);
        ft.setWedding(nadya, andrey);
        oleg.addParent(andrey);
        oleg.addParent(nadya);
        nadya.addChild(oleg);
        nadya.addChild(katya);
//        System.out.println(ft);
//        ft.remove(ft.findByName("Andrey"));
        ft.sortByName();
        ft.sortByAge();
        ft.sortByBirthDate();
        return ft;
    }
}
