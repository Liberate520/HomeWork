package familytree;

import familytree.model.FamilyMember;
import familytree.model.FamilyTree;
import familytree.model.Gender;
import familytree.model.Human;
import familytree.writer.FileHandler;
import familytree.writer.Writer;
import familytree.sort.Sorter;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Human> familyTree = createFamilyTree();

        // Сохранение дерева в файл
        familyTree.save("src/familytree/writer/tree.txt");

        // Чтение дерева из файла
        FamilyTree<Human> loadedTree = FamilyTree.read("src/familytree/writer/tree.txt");

        // Сортировка и вывод по имени
        Sorter.sortByName(loadedTree.getMembers());
        System.out.println("Sorted by name:");
        printFamilyTree(loadedTree);

        // Сортировка и вывод по дате рождения
        Sorter.sortByBirthDate(loadedTree.getMembers());
        System.out.println("Sorted by birth date:");
        printFamilyTree(loadedTree);
    }

    private static FamilyTree<Human> createFamilyTree() {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        Human ivan = new Human("Иван", LocalDate.of(1974, 6, 1), Gender.MALE);
        Human maria = new Human("Мария", LocalDate.of(1979, 8, 15), Gender.FEMALE);
        Human mikhail = new Human("Михаил", LocalDate.of(2004, 11, 30), Gender.MALE);
        Human anna = new Human("Анна", LocalDate.of(2006, 5, 25), Gender.FEMALE);

        // Устанавливаем дату смерти (для демонстрации)
        maria.setDeathDate(LocalDate.of(2023, 4, 10));

        ivan.addChild(mikhail);
        ivan.addChild(anna);

        familyTree.addMember(ivan);
        familyTree.addMember(maria);
        familyTree.addMember(mikhail);
        familyTree.addMember(anna);

        return familyTree;
    }

    private static void printFamilyTree(FamilyTree<Human> familyTree) {
        for (Human person : familyTree) {
            printHumanDetails(person);
        }
    }

    private static void printHumanDetails(Human human) {
        System.out.print(human.getName() + ", Born: " + human.getBirthDate());
        if (human.isAlive()) {
            System.out.println(", Age: " + human.getAge());
        } else {
            System.out.println(", Died: " + human.getDeathDate() + ", Age: " + human.getAge());
        }
        List<FamilyMember> parents = human.getParents();
        if (!parents.isEmpty()) {
            System.out.print("Parents: ");
            for (FamilyMember parent : parents) {
                System.out.print(parent.getName() + " ");
            }
            System.out.println();
        }
    }
}