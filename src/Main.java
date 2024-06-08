import java.time.LocalDate;
import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {

        String file = "src/tree.txt";
        FamilyTree tree = finalTree();
//        FamilyTree tree = load(file);
        System.out.println(tree);
        save(tree, file);
    }

    private static FamilyTree load(String file) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(file);
    }

    private static void  save(FamilyTree tree, String file) {
        Writable writable = new FileHandler();
        writable.save(tree, file);
    }

    private static FamilyTree finalTree(){
        FamilyTree tree = new FamilyTree();

        Human petya = new Human("Петя", Gender.Male, LocalDate.of(1993,9,24));
        Human ira = new Human("Ира", Gender.Female, LocalDate.of(1992, 2,12));
        Human anya = new Human("Аня", Gender.Female, LocalDate.of(1974,10,2));
        Human pasha = new Human("Паша", Gender.Male, LocalDate.of(1973, 5,11));
        Human kolya = new Human("Коля", Gender.Male, LocalDate.of(2000, 4, 13), anya, pasha);
        Human sonya = new Human("Соня", Gender.Female, LocalDate.of(2010,2,1), anya);
        Human egor = new Human("Егор", Gender.Male, LocalDate.of(2015,8,11), anya, pasha);


        FamilyTree.addHuman(petya);
        FamilyTree.addHuman(petya);
        FamilyTree.addHuman(ira);
        FamilyTree.addHuman(anya);
        FamilyTree.addHuman(pasha);
        FamilyTree.addHuman(kolya);
        FamilyTree.addHuman(sonya);
        FamilyTree.addHuman(egor);

        System.out.println(FamilyTree.getHumansInfo());
        return tree;
    }
}
