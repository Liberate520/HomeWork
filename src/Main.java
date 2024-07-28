import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human igor = new Human("Igor", LocalDate.of(1973, 1, 1), null, Gender.Male);
        Human mary = new Human("Mary", LocalDate.of(1978, 5, 15), null, Gender.Female);
        Human anna = new Human("Anna", LocalDate.of(2003, 8, 20), null, Gender.Female);
        Human vitaly = new Human("Vitaly", LocalDate.of(2005, 11, 10), null, Gender.Male);
        Human george = new Human("George", LocalDate.of(1948, 4, 12), LocalDate.of(2015, 8, 28), Gender.Male);
        Human inga = new Human("Inga", LocalDate.of(1949, 9, 20), LocalDate.of(2016, 4, 15), Gender.Female);
        Human anastasia = new Human("Anastasia", LocalDate.of(1951, 2, 4), null, Gender.Female);
        Human vladimir = new Human("Vladimir", LocalDate.of(1946, 12, 10), LocalDate.of(2019, 5, 13), Gender.Male);

        igor.addChild(anna);
        igor.addChild(vitaly);
        mary.addChild(anna);
        mary.addChild(vitaly);

        anastasia.addChild(mary);
        vladimir.addChild(mary);
        george.addChild(igor);
        inga.addChild(igor);

        familyTree.addPerson(igor);
        familyTree.addPerson(mary);
        familyTree.addPerson(anna);
        familyTree.addPerson(vitaly);
        familyTree.addPerson(inga);
        familyTree.addPerson(george);
        familyTree.addPerson(vladimir);
        familyTree.addPerson(anastasia);

        System.out.println("Семейное древо:");
        familyTree.printAllMembers();

        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println();
        System.out.println("Введите имя для отображения детей: ");
        String name = scanner.nextLine();

        List<Human> children = familyTree.getChildrenOf(name);
        if (children != null && !children.isEmpty()) {
            System.out.println("Дети " + name + ":");
            for (Human child : children) {
                System.out.println(child);
            }
        } else {
            System.out.println("У данного человека нет детей или человек с именем " + name + " не найден.");
        }
        scanner.close();
    }
}