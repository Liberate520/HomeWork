package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanBuilder;
import ru.gb.family_tree.human.HumanService;
import ru.gb.family_tree.writer.FileHandler;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    final static String filePath = "src/ru/gb/family_tree/writer/tree.txt";

    public static void main(String[] args) {
        HumanService service = new HumanService();
        FileHandler fileHandler = new FileHandler(filePath);

        if (!Files.isRegularFile(Path.of(filePath))) {
            createDefaultFamilyTree(service);
            System.out.println("Created for the first time: " + "\n");
        } else {
            service.addHumans((List<Human>) fileHandler.read());
            System.out.println("Restored: " + "\n");
        }
        System.out.println(service.getHumanListInfo());


        /**
        HumanService service2 = new HumanService();
        createDefaultSecondFamilyTree(service2);
        System.out.println(service2.getHumanListInfo());

        service.addHumans(service.getHumans());
        System.out.println(service.getHumanListInfo());
        */

/**
        System.out.println(service.getHumanListInfo());
        service.sortByName();
        System.out.println(service.getHumanListInfo());
        service.sortByAge();
        System.out.println(service.getHumanListInfo());
*/
        service.sortById();
        System.out.println(service.getHumanListInfo());

        fileHandler.save((Serializable) service.getHumans());

    }

    private static void createDefaultFamilyTree(HumanService service) {
        service.addHuman("Александр", 60);
        service.addHuman("Екатерина", 55);
        service.addHuman("Михаил", 35);
        service.addHuman("Евгения", 30);
    }

    private static void createDefaultSecondFamilyTree(HumanService service) {
        service.addHuman("Саша", 60);
        service.addHuman("Катя", 55);
        service.addHuman("Миша", 35);
        service.addHuman("Женя", 30);
    }

    /**
    private static void loadFamilyTree(HumanService service){
        FileHandler fileHandler = new FileHandler(filePath);
        //fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler(filePath);
        //fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }
*/
        /**
    private void getDefault() {

        service.addHuman("Александр", 60);
        service.addHuman("Екатерина", 55);
        service.addHuman("Михаил", 35);
        service.addHuman("Евгения", 30);

         /**

        Human human1 = new Human(1, "Александр", Gender.Male, LocalDate.of(1960, 10, 10));
        Human human2 = new Human(2, "Екатерина", Gender.Female, LocalDate.of(1965, 05, 05));
        Human human3 = new Human(3, "Михаил", Gender.Male, LocalDate.of(1985, 06, 15));
        Human human4 = new Human(4, "Евгения", Gender.Female, LocalDate.of(1990, 12, 25));
        Human human5 = new Human(5, "Геннадий", Gender.Male, LocalDate.of(2015, 7, 7));

        human1.setChildren(List.of(human3));
        human2.setChildren(List.of(human3));
        human3.setParents(List.of(human1, human2));
        human3.setChildren(List.of(human5));
        human4.setChildren(List.of(human5));
        human5.setParents(List.of(human3, human4));
        human2.setDeathDate(LocalDate.of(2020, 3, 25));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);

    }
    */

}
