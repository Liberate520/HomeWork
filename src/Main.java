package src;

import src.familyTree.FamilyTree;
import src.human.Gender;
import src.backup.FileHandler;
import src.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/backup/myTree.out";
        FileHandler fh = new FileHandler();
        Service service = new Service();

//        FamilyTree tree = fh.read(filePath);

        FamilyTree tree = new FamilyTree();
        addHumanToFamilyTree(service, tree);

        System.out.println(service.getHumanListInfo(tree));

        service.sortByName(tree);
        System.out.println("Сортировка по имени:");
        System.out.println(service.getHumanListInfo(tree));

        service.sortByDOB(tree);
        System.out.println("Сортировка по дате рождения:");
        System.out.println(service.getHumanListInfo(tree));

        service.sortById(tree);
        System.out.println("Сортировка по Id:");
        System.out.println(service.getHumanListInfo(tree));

        fh.save(tree, filePath);
    }

    private static void addHumanToFamilyTree(Service service, FamilyTree tree) {
        service.addHuman(tree, "Ivan", Gender.Male, LocalDate.of(1945, 5, 28));
        service.addHuman(tree, "Zoia", Gender.Female, LocalDate.of(1950, 1, 1));
        service.addHuman(tree, "Kostia", Gender.Male, LocalDate.of(1973, 12, 13));
        service.addHuman(tree, "Irina", Gender.Female, LocalDate.of(1975, 3, 6));
        service.addHuman(tree, "Katia", Gender.Female, LocalDate.of(2001, 11, 29));

        tree.getByName("Zoia").getFirst().setDeathDate(LocalDate.of(2021, 2, 19));
        tree.getByName("Ivan").getFirst().setDeathDate(LocalDate.of(2021, 8, 22));

//        tree.getByName("Kostia").getFirst().addParent(tree.getByName("Ivan").getFirst());
//        tree.getByName("Kostia").getFirst().addParent(tree.getByName("Zoia").getFirst());
//        tree.getByName("Katia").getFirst().addParent(tree.getByName("Kostia").getFirst());
//        tree.getByName("Katia").getFirst().addParent(tree.getByName("Irina").getFirst());
        service.addParent(tree, "Kostia", "Ivan");
        service.addParent(tree, 2, 1);
        service.addParent(tree, 4, 2);
        service.addParent(tree, 4, 3);

//        tree.setWedding(tree.getByName("Ivan").getFirst(), tree.getByName("Zoia").getFirst());
//        tree.setWedding(tree.getByName("Kostia").getFirst(), tree.getByName("Irina").getFirst());
        service.setWedding(tree, "Zoia", "Ivan");
        service.setWedding(tree, 2,3);
    }
}