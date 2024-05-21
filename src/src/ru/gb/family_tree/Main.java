package src.ru.gb.family_tree;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Node;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создаем узлы для семейного дерева
        Node father = new Node("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Node mother = new Node("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        Node child1 = new Node("Кристина", Gender.Female, LocalDate.of(1988, 7, 5));
        Node child2 = new Node("Семен", Gender.Male, LocalDate.of(1991, 1, 25));

        // Устанавливаем отношения супругов
        father.setSpouse(mother);

        // Устанавливаем родителей для детей
        father.addChild(child1);
        mother.addChild(child1);
        father.addChild(child2);
        mother.addChild(child2);

        // Добавляем узлы в семейное дерево
        familyTree.addNode(father);
        familyTree.addNode(mother);
        familyTree.addNode(child1);
        familyTree.addNode(child2);

        // Выводим информацию о всех узлах семейного дерева
        for (Node node : familyTree.getAllNodes()) {
            System.out.println(node.getInfo());
        }
    }
}