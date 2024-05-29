import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        FamilyTree familyTree = new FamilyTree();

        Human john = new Human("John", LocalDate.of(1980, 5, 15), Gender.Male);
        Human jane = new Human("Jane", LocalDate.of(1982, 7, 10), Gender.Female);
        Human mary = new Human("Mary", LocalDate.of(2010, 3, 25), Gender.Female);
        Human anna = new Human("Anna", LocalDate.of(1955, 2, 17), LocalDate.of(2020, 1, 20), Gender.Female);

        john.addChild(mary);
        jane.addChild(mary);
        anna.addChild(john);

        familyTree.addHuman(john);
        familyTree.addHuman(jane);
        familyTree.addHuman(mary);
        familyTree.addHuman(anna);

        // Проводим исследование: находим детей Anna
        Human targetHuman = familyTree.getHumanByName("Anna");
        if (targetHuman != null) {
            List<Human> children = familyTree.getChildrenOf(targetHuman);
            System.out.println("Дети " + targetHuman.getName() + ": " + children);
        } else {
            System.out.println("Человек не найден");
        }
    }
}

