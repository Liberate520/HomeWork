package family_tree;


import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.sorter.HumanSorter;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Service service = new Service();

        service.addHuman("Наталия", LocalDate.of(1964, 1, 16), Gender.женский);
        service.addHuman("Иван", LocalDate.of(1967, 1, 16), Gender.мужской);
        service.addHuman("Ольга", LocalDate.of(1989, 3, 20), Gender.женский);
        service.addHuman("Елена", LocalDate.of(1994, 12, 23), Gender.женский);

        System.out.println(service.getHumanListInfo());
        service.HumanSortByName();
        System.out.println("После сортировки по имени:");
        System.out.println(service.getHumanListInfo());
        service.HumanSortByAge();
        System.out.println("После сортировки по возрасту:");
        System.out.println(service.getHumanListInfo());

//        Human natalya = new Human("Наталья", LocalDate.of(1964, 9, 19), Gender.женский);
//        Human ivan = new Human("Иван", LocalDate.of(1967, 1, 16), Gender.мужской);
//        Human olga = new Human("Ольга", LocalDate.of(1989, 3, 20), Gender.женский);
//        Human elena = new Human("Елена", LocalDate.of(1994, 12, 23), Gender.женский);

//        familyTree.addHuman(natalya);
//        familyTree.addHuman(ivan);
//        familyTree.addHuman(olga);
//        familyTree.addHuman(elena);

        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath("family_tree.txt");

        // Сохранение семейного дерева
        fileHandler.save(familyTree);

        // Чтение семейного дерева
        FamilyTree loadedFamilyTree = (FamilyTree) fileHandler.read();

    }
}

