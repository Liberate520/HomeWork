package service;

import familiTree.FamilyTree;
import human.Human;

public class Service {

    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void sortByName() { // сортировка по имени
        familyTree.sortByName();
    }

    public void sortByAge() { // сортировка по возрасту
        familyTree.sortByAge();
    }

    public String getHumanListInfo() {
        // метод для вывода информации о человеке

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Отсортированный список генеалогического древа:\n");

        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
