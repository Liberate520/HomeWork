package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
//    final static String filePath = "";
    public static void main(String[] args) {
//        FamilyTree familyTree = load();
        FamilyTree familyTree = createTree();
//        save(familyTree);
        familyTree.sortByAge();
        System.out.println(familyTree);
    }

    private static FamilyTree createTree() {
        FamilyTree familyTree = new FamilyTree();

        Human BuryakovskyKirillBorisovich = new Human("Буряковский", "Кирилл", "Борисович", Gender.Male, LocalDate.of(1972, 9, 19));
        Human BuryakovskayaVarvaraViktorovna = new Human("Буряковская(Попкова)", "Варвара", "Викторовна", Gender.Female, LocalDate.of(1978, 3, 1));

        familyTree.add(BuryakovskyKirillBorisovich);
        familyTree.add(BuryakovskayaVarvaraViktorovna);
        familyTree.setWedding(BuryakovskyKirillBorisovich,BuryakovskayaVarvaraViktorovna);

        Human BuryakovskyPavelKirillovich = new Human("Буряковский", "Павел", "Кириллович", Gender.Male, LocalDate.of(2000, 4, 22), BuryakovskyKirillBorisovich, BuryakovskayaVarvaraViktorovna);
        familyTree.add(BuryakovskyPavelKirillovich);

        Human BuryakovskyBorisAnatolyevich = new Human("Буряковский", "Борис", "Анатольевич", Gender.Male, LocalDate.of(1949, 9, 27), LocalDate.of(2005, 1, 7), null, null);
        Human BuryakovskayaLyubovVasilevna = new Human("Буряковская(Феофанова)", "Любовь", "Васильевна", Gender.Female, LocalDate.of(1949, 1, 18));
        BuryakovskyBorisAnatolyevich.addChild(BuryakovskyKirillBorisovich);
        familyTree.add(BuryakovskyBorisAnatolyevich);
        BuryakovskayaLyubovVasilevna.addChild(BuryakovskyKirillBorisovich);
        familyTree.add(BuryakovskayaLyubovVasilevna);
        familyTree.setWedding(BuryakovskyBorisAnatolyevich, BuryakovskayaLyubovVasilevna);

//        System.out.println(familyTree.searchByFullName("Буряковский", "Павел", "Кириллович"));
//        System.out.println(familyTree.searchByFullName("Буряковский", "Валентин", "Кириллович"));
        return familyTree;
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.load();
    }
}
