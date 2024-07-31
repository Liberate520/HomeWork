import FamilyTree.ServiceFamilyTree;
import Human.Gender;

import java.io.IOException;
import java.time.LocalDate;


public class Main {
    final static String fileName = "file.txt";

    public static void main(String[] args) throws IOException {

        ServiceFamilyTree service = new ServiceFamilyTree();
        service.addHuman("Сорокин", "Олег", "Иванович",
                Gender.Male, LocalDate.of(1991, 4, 21), null, null, null, null, "г.Уфа");

        service.addHuman("Сорокина", "Марьяна", "Валерьевна",
                Gender.Female,LocalDate.of(1991, 3, 6), null, null, null, null, "Сибирь");

        service.addHuman("Иванов", "Абдул", "Викторов",
                Gender.Male, LocalDate.of(2000, 11, 6), null, service.getHuman(0), service.getHuman(1), null, "Сибирь");

        service.addHuman("Хмель", "Аннет", "Хрум",
                Gender.Female, LocalDate.of(1987, 3, 26), null, service.getHuman(0), service.getHuman(1), null, "Сибирь");

        service.addHuman("Петрова", "Марина", "Сергеевна",
                Gender.Female, LocalDate.of(1974, 3, 23), LocalDate.of(1995, 1, 15), null, null, null, "г. Казань");

        service.addHuman("Петрова", "Олег", "Дмитриевич",
                Gender.Male, LocalDate.of(1991, 10, 19), null, service.getHuman(2), service.getHuman(2), null, "Сибирь");

        service.addHuman("Петрова", "Виталий", "Дмитриевич",
                Gender.Male, LocalDate.of(1993, 3, 7), null, service.getHuman(2), service.getHuman(2), null, "Сибирь");

        service.getFamilyTree();

        service.saveFile("file.txt");

        ServiceFamilyTree serviceFamilyTreeNEW = new ServiceFamilyTree();
        serviceFamilyTreeNEW.openFile("file.txt");
        serviceFamilyTreeNEW.getFamilyTree();

        System.out.println(serviceFamilyTreeNEW.getfamilyTreeList());
        serviceFamilyTreeNEW.sortByName();
        System.out.println(serviceFamilyTreeNEW.getfamilyTreeList());

        serviceFamilyTreeNEW.sortByAge();
        System.out.println(serviceFamilyTreeNEW.getfamilyTreeList());
    }
}
