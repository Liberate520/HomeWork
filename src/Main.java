import ru.gb.family_tree.*;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создаем узлы для семейного дерева
        Node father = new Node("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Node mother = new Node("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        Node child1 = new Node("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), null, father, mother);
        Node child2 = new Node("Семен", Gender.Male, LocalDate.of(1991, 1, 25), null, father, mother);

        // Добавляем узлы в семейное дерево
        familyTree.addNode(father);
        familyTree.addNode(mother);
        familyTree.addNode(child1);
        familyTree.addNode(child2);

        // Создаем узел для матери Василия и добавляем его в семейное дерево
        Node grandmother = new Node("Екатерина", Gender.Female, LocalDate.of(1940, 3, 14));
        familyTree.addNode(grandmother);

        // Устанавливаем Екатерину как мать Василия
        father.setMother(grandmother);

        // Сохраняем дерево в файл
        try {
            familyTree.saveTreeToFile("family_tree.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загружаем дерево из файла и выводим его
        FamilyTree loadedFamilyTree = new FamilyTree();
        try {
            loadedFamilyTree.loadTreeFromFile("family_tree.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Before sorting:");
        loadedFamilyTree.printTree();

        System.out.println("\nSorted by name:");
        loadedFamilyTree.sortByName();
        loadedFamilyTree.printTree();

        System.out.println("\nSorted by birth date:");
        loadedFamilyTree.sortByBirthDate();
        loadedFamilyTree.printTree();
    }
}