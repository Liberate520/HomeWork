import writer.FileHandler;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = makeTree();
//        saveTree(tree);

        System.out.println(readTree());
    }

    private static FamilyTree readTree() throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static void saveTree (FamilyTree tree) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);

    }

        public static FamilyTree makeTree() {
            FamilyTree tree = new FamilyTree();

            Human ivan = new Human("Ivan", Gender.male, LocalDate.of(2000, 02, 20));
            Human maria = new Human("Maria", Gender.female, LocalDate.of(1999, 01, 02));
            Human elena = new Human("Elena",Gender.female,LocalDate.of(1985,10,11));

            tree.add(ivan);
            tree.add(maria);
            tree.add(elena);
//        tree.setWedding(ivan,maria);
            return tree;

        }

}





