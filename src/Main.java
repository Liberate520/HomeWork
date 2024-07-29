import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        /**
         *Создаем людей
         * */
        Human Ivan = new Human("Иван", LocalDate.of(1990, 1, 1), Gender.Male);
        Human Luda = new Human("Людмила", LocalDate.of(1992, 2, 2), Gender.Female);
        Human Larisa = new Human("Лариса", LocalDate.of(2010, 3, 3), Gender.Female);
        Human Petr = new Human("Петр", LocalDate.of(2012, 4, 4), Gender.Male);

        tree.addHuman(Ivan);
        tree.addHuman(Luda);
        tree.addHuman(Larisa);
        tree.addHuman(Petr);

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
