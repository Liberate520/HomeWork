package family_tree;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
//        FamilyTree familyTree = load();
//        FamilyTree<Human> familyTree = createTree();
//        save(familyTree);
//        familyTree.sortByAge();
//        System.out.println(familyTree);
    }

//    private static FamilyTree<Human> createTree() {
//        FamilyTree<Human> familyTree = new FamilyTree<>();
//
//        Human BuryakovskyKirillBorisovich = new Human("Буряковский", "Кирилл", "Борисович", Gender.М, LocalDate.of(1972, 9, 19));
//        Human BuryakovskayaVarvaraViktorovna = new Human("Буряковская(Попкова)", "Варвара", "Викторовна", Gender.Ж, LocalDate.of(1978, 3, 1));
//
//        familyTree.add(BuryakovskyKirillBorisovich);
//        familyTree.add(BuryakovskayaVarvaraViktorovna);
//        familyTree.setWedding(BuryakovskyKirillBorisovich,BuryakovskayaVarvaraViktorovna);
//
//        Human BuryakovskyPavelKirillovich = new Human("Буряковский", "Павел", "Кириллович", Gender.М, LocalDate.of(2000, 4, 22), BuryakovskyKirillBorisovich, BuryakovskayaVarvaraViktorovna);
//        familyTree.add(BuryakovskyPavelKirillovich);
//
//        Human BuryakovskyBorisAnatolyevich = new Human("Буряковский", "Борис", "Анатольевич", Gender.М, LocalDate.of(1949, 9, 27), LocalDate.of(2005, 1, 7), null, null);
//        Human BuryakovskayaLyubovVasilevna = new Human("Буряковская(Феофанова)", "Любовь", "Васильевна", Gender.Ж, LocalDate.of(1949, 1, 18));
//        BuryakovskyBorisAnatolyevich.addChild(BuryakovskyKirillBorisovich);
//        familyTree.add(BuryakovskyBorisAnatolyevich);
//        BuryakovskayaLyubovVasilevna.addChild(BuryakovskyKirillBorisovich);
//        familyTree.add(BuryakovskayaLyubovVasilevna);
//        familyTree.setWedding(BuryakovskyBorisAnatolyevich, BuryakovskayaLyubovVasilevna);
//
////        System.out.println(familyTree.searchByFullName("Буряковский", "Павел", "Кириллович"));
////        System.out.println(familyTree.searchByFullName("Буряковский", "Валентин", "Кириллович"));
//        return familyTree;
//    }
//
//    private static void save(FamilyTree<Human> familyTree) {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(familyTree);
//    }
//
//    private static FamilyTree<Human> load() {
//        FileHandler fileHandler = new FileHandler();
//        return (FamilyTree) fileHandler.load();
//    }
}
