package model.family_tree;

import model.Creatures.Creature;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Creature<T>> implements Serializable, Iterable<T> {
    private List<T> familyList;

    /**
     * Основной консруктор класса
     * @param familyList Arraylist<T>
     */
    public FamilyTree(List<T> familyList) {
        this.familyList = familyList;
    }

    /**
     * Добавляет creature в familyList
     * @param creature
     */
    public void addCreature(T creature) {
        this.familyList.add(creature);
    }

    /**
     * возвращает существо Creature в котором в имени встретилась искома строка
     * без учета регистра
     * @param text String
     * @return T
     */
    public T findFirsIn(String text) {
        for (T creature: familyList) {
            if (creature.getName().toLowerCase().contains(text.toLowerCase())){
                return creature;
            }
        }
        return null;
    }

    /**
     * возвращает ArrayList<T> в которых в имени встретилась искома строка
     * без учета регистра
     * @param text
     * @return ArrayList<T>
     */
    public List<T> findFirsAll(String text) {
        List<T> result = new ArrayList<>();
        for (T creature: familyList) {
            if (creature.getName().toLowerCase().contains(text.toLowerCase())){
                result.add(creature);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < familyList.size(); i++) {
        txt.append(i + 1).append(". ").append(familyList.get(i).getName()).append(", ");
        txt.append("Возраст: ").append(familyList.get(i).getAge()).append(", ");
        txt.append("детей: ").append(familyList.get(i).getChildren().size()).append("\n");
        }
        return txt.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(familyList);
    }

    /**
     * Реализует сортировку по имени
     */
    public void sortByName() {
        familyList.sort(new HumanComparatorByName<>());
    }

    /**
     * Реализует сортировку по возрасту
     */
    public void sortByAge() {
        familyList.sort(new HumanComparatorByAge<>());
    }

    /**
     * Реализует сортировку по количеству детей
     */
    public void sortByNumberChildren() {
        familyList.sort(new HumanComparatorByNumberChildren<>());
    }

    /**
     * Возвращает размер дерева (количество людей)
     * @return int
     */
    public int getSize() {
        return familyList.size();
    }

    /**
     * Возвращает ArrayList<T> всех существ в дереве
     * @return ArrayList<T>
     */
    public List<T> getFamilyList() {
        return familyList;
    }
}
