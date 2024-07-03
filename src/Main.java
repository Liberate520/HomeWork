import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();

        Human Molly = new Human("Molly", LocalDate.of(1949,10,30), Gender.Female);
        Human Artur = new Human("Artur", LocalDate.of(1950,2,6), Gender.Male);
        Human Ginny = new Human ("Ginny", LocalDate.of(1981,8,11), Gender.Female, Artur, Molly);
        Human Ron = new Human("Ron", LocalDate.of(1980, 3, 1), Gender.Male, Artur, Molly);

        tree.addHuman(Artur);
        tree.addHuman(Molly);
        tree.addHuman(Ginny);
        tree.addHuman(Ron);

        System.out.println(tree);

        writeToFileTree(tree);
        FamilyTree tree1 = readTreeInFile();

        System.out.println(tree1);
    }

    private static void writeToFileTree(FamilyTree tree) throws IOException {
        FileHandler fileHandler = new FileHandler();
        if (fileHandler.writeToFileObject(tree)) {
            System.out.println("Файл записан");
        }
    }

    private static FamilyTree readTreeInFile() throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.readObjectInFile();
    }

}
