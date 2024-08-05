package familyTree;

import familyTree.model.familyTree.ServiceFamilyTree;
import familyTree.model.human.Gender;
import familyTree.view.ConsoleUI;
import familyTree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    final static String fileName = "src/familyTree/file.txt";

    public static void main(String[] args) throws IOException {
//
//        ServiceFamilyTree service = new ServiceFamilyTree();
//        service.addHuman("Петров", "Валентин", "Петрович",
//                Gender.Male, LocalDate.of(1944, 4, 12), null, null, null, null, "г.Уфа");
//
//        service.addHuman("Петрова", "Галина", "Николаевна",
//                Gender.Female,LocalDate.of(1949, 8, 6), null, null, null, null, "Сибирь");
//
//        service.addHuman("Петров", "Дмитрий", "Валентинович",
//                Gender.Male, LocalDate.of(1970, 11, 6), null, service.getHuman(0), service.getHuman(1), null, "Сибирь");
//
//        service.addHuman("Смирнова", "Татьяна", "Валентиновна",
//                Gender.Female, LocalDate.of(1974, 3, 23), null, service.getHuman(0), service.getHuman(1), null, "Сибирь");
//
//        service.addHuman("Петрова", "Марина", "Сергеевна",
//                Gender.Female, LocalDate.of(1974, 3, 23), LocalDate.of(1995, 1, 15), null, null, null, "г. Казань");
//
//        service.addHuman("Петрова", "Олег", "Дмитриевич",
//                Gender.Male, LocalDate.of(1991, 10, 19), null, service.getHuman(2), service.getHuman(2), null, "Сибирь");
//
//        service.addHuman("Петрова", "Виталий", "Дмитриевич",
//                Gender.Male, LocalDate.of(1993, 3, 7), null, service.getHuman(2), service.getHuman(2), null, "Сибирь");
//
//        service.getFamilyTree();
//
//        service.saveFile("src/familyTree/file.txt");
//
//        ServiceFamilyTree serviceFamilyTreeNEW = new ServiceFamilyTree();
//        serviceFamilyTreeNEW.openFile("src/familyTree/file.txt");
//        serviceFamilyTreeNEW.getFamilyTree();
//
//        System.out.println(serviceFamilyTreeNEW.getFamilyTreeList());
//        serviceFamilyTreeNEW.sortByName();
//        System.out.println(serviceFamilyTreeNEW.getFamilyTreeList());
//
//        serviceFamilyTreeNEW.sortByAge();
//        System.out.println(serviceFamilyTreeNEW.getFamilyTreeList());
        View view = new ConsoleUI();
        view.start();
    }
}
