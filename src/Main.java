import FamilyTree.FamilyTree;
import Human.Human;
import Human.Gender;
import Service.HumanService;
import Writer.Writer;
import Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HumanService humanService = new HumanService();

        humanService.testTree();
        System.out.println(humanService);

        FamilyTree familyTree = humanService.getFamilyTree();
        Writer fileWriter = new FileHandler(familyTree);
        fileWriter.saveToFile(familyTree);
        System.out.println("Семейное дерево сохранено");

        FamilyTree familyTreeRestored = fileWriter.readFromFile();
        System.out.println("Семейное дерево восстановлено");
        familyTreeRestored.showTree();

        System.out.println("Сортировка по имени:");
        humanService.SortByName();
        System.out.println(humanService);

        System.out.println("Сортировка по возрасту:");
        humanService.SortByAge();
        System.out.println(humanService);

        System.out.println("Сортировка по количеству детей:");
        humanService.SortByChildrenNum();
        System.out.println(humanService);

        System.out.println("Сортировка по дате рождения:");
        humanService.SortByBirthdate();
        System.out.println(humanService);
    }
}
