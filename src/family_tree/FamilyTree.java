package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;  // Создание пустого списка класса Human

    public FamilyTree() {
        familyTree = new ArrayList<>();
    } // Создание пустого Array списка
    public void addHuman(Human human) {
        familyTree.add(human);
    } // Добавление людей в список familyTree
    public Human findHuman(String name) {
        for (Human human : familyTree) {
            if ( human.getName().equalsIgnoreCase(name)) {
                return human;   // Поиск человека в списке и его вывод
            }
        } return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Генеалогическое древо семьи:\n");
        for (Human human : familyTree) {
            sb.append(human);     // Вывод всех людей дерева
            sb.append("\n");
        }
        return sb.toString();
    }
}
