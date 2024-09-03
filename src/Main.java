import model.FamilyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import model.writer.FileHandler;






public class Main {
//final static String filePath = "src/model/writer/tree.txt";

    public static void main(String[] args) throws IOException {
////        FamilyTree tree = load();
//        FamilyTree tree = testTree();
//        System.out.println(tree);
//        save(tree);
//        tree.sortByAge();
//        System.out.println(tree);
//        tree.sortByName();
//        System.out.println(tree);

    }




//    private static FamilyTree testTree() {
//            FamilyTree tree = new FamilyTree();
//
//            Human grisha = new Human("Гриша", Gender.Male, LocalDate.of(1952, 12, 12), null, null, null, null);
//            Human masha = new Human("Мария", Gender.Female, LocalDate.of(1951, 1, 2), null, null, null, null);
//
//            tree.add(grisha);
//            tree.add(masha);
//            Human gena = new Human("Геннадий",Gender.Male, LocalDate.of(1971, 4, 29),null,null, masha, grisha);
//            tree.add(gena);
//            Human sveta = new Human("Светлана", Gender.Female, LocalDate.of(1976, 2, 17), null, null, masha, grisha);
//            tree.add(sveta);
//
//            return tree;
//
//        }
//
//
//
//    private static  void save(FamilyTree familyTree) {
//        FileHandler fileHandler = new FileHandler(filePath);
//
//        fileHandler.save(familyTree);
//
//    }
//
//    private static FamilyTree load() {
//        FileHandler fileHandler = new FileHandler(filePath);
//
//        return (FamilyTree) fileHandler.read();
//
//
//    }

}