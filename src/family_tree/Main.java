package family_TREE;

import family_TREE.model.FamilyTreeService;
import family_TREE.model.family_tree.FamilyTree;
import family_TREE.model.save.FileHandlerForFamilyTree;
import family_TREE.model.human.Human;
import family_TREE.model.human.Gender;
import java.io.Console;
import java.time.LocalDate;
import family_TREE.model.save.base.FileHandler;
import family_TREE.view.*;

public class Main {
    public static void main(String[] args) {
        View view = new family_TREE.view.Console();
        view.start();
    }

//    public static FamilyTree<Human> main(String[] args) {
//        FamilyTree<Human> tree = new FamilyTree<>();
//        String filePath = "src/family_TREE/model/save/tree.txt";
//
//        FamilyTree tree = read(filePath);
////        FamilyTree tree = testTree();
//
//        System.out.println(tree);
//        save(tree, filePath);
//    }
//
//static FamilyTree read(String filePath) {
//    FileHandler fileHandler = new FileHandler();
//    return (FamilyTree) fileHandler.read(filePath);
//}
//
//static void save(FamilyTree familyTree, String filePath) {
//    FileHandler fileHandler = new FileHandler();
//    fileHandler.save(familyTree, filePath);
//}
//
//
//    static FamilyTree testTree() {
//        FamilyTree tree = new FamilyTree();
//
//        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
//        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
//        tree.add(masha);
//        tree.add(vasya);
//        tree.setWedding(vasya, masha);
//
//        Human chrictina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
//                vasya, masha);
//        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
//                vasya, masha);
//        tree.add(semyon);
//        tree.add(chrictina);
//
//        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
//        grandMother.addChild(vasya);
//        tree.add(grandMother);
//
//        System.out.println(tree);
//
//        FamilyTreeService service = new FamilyTreeService(tree);
//        service.setWritable(new FileHandlerForFamilyTree());
//        service.save();
//
//        View view = new Console();
//        view.start();
//
//
//        return tree; heeelllooooo
//    }
}
