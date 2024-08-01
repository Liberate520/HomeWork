import family_tree.FamilyTree;
import family_tree.Service;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/writer/tree.txt";

    public static void main(String[] args) {
//        FamilyTree tree = load();
        Service <Human>  service= new Service<>();
        FamilyTree <Human> ft = service.getFamilyTree();
        service.addHuman("Leha",Gender.Male, LocalDate.of(1999,9,9));
        service.addHuman("Oleg", Gender.Male, LocalDate.of(1995,7,2));
        service.addHuman("Nastya", Gender.Female, LocalDate.of(2001,3,16));
        service.addHuman("Nadezhda", Gender.Female, LocalDate.of(1974,6,26));
        service.setWedding("Oleg", "Nastya");
        service.addHuman("Andrey", Gender.Male, LocalDate.of(1970,7,25));
        service.setWedding("Nadezhda", "Andrey");
        service.addHuman("Katya", Gender.Female, LocalDate.of(2004,12,24));
        ft.findByName("Katya").addParent(ft.findByName("Andrey"));
        ft.findByName("Katya").addParent(ft.findByName("Nadezhda"));
        ft.findByName("Oleg").addParent(ft.findByName("Andrey"));
        ft.findByName("Oleg").addParent(ft.findByName("Nadezhda"));
        ft.findByName("Nadezhda").addChild(ft.findByName("Oleg"));
        ft.findByName("Nadezhda").addChild(ft.findByName("Katya"));
//        ft.sortByName();
//        ft.sortByAge();
//        ft.sortByBirthDate();
        save(service.getFamilyTree());

        System.out.println(service.getFamilyTree());

    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree<Human> familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

}
