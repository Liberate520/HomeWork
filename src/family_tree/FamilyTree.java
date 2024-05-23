package family_tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyList;

    /**
     * Основной консруктор класса
     * @param familyList Arraylist<human.Human>
     */
    public FamilyTree(List<Human> familyList) {
        this.familyList = familyList;
    }

    /**
     * Добавляет human.Human в familyList
     * @param human
     */
    public void addHuman(Human human) {
        this.familyList.add(human);
    }

    /**
     * возвращает первого human.Human в котором в имени встретилась искома строка
     * без учета регистра
     * @param text String
     * @return human.Human
     */
    public Human findFirsIn(String text) {
        for (Human human: familyList) {
            if (human.getName().contains(text)){
                return human;
            }
        }
        return null;
    }

    /**
     * возвращает ArrayList<human.Human> в которых в имени встретилась искома строка
     * без учета регистра
     * @param text
     * @return ArrayList<human.Human>
     */
    public List<Human> findFirsAll(String text) {
        List<Human> result = new ArrayList<>();
        for (Human human: familyList) {
            if (human.getName().contains(text)){
                result.add(human);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Human human: familyList) {
        txt.append(human.getName()).append("\n");
        }
        return txt.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(familyList);
    }

    /**
     * Реализует сортировку по имени
     */
    public void sortByName() {
        familyList.sort(new HumanComparatorByName());
    }

    /**
     * Реализует сортировку по возрасту
     */
    public void sortByAge() {
        familyList.sort(new HumanComparatorByAge());
    }

    /**
     * Реализует сортировку по количеству детей
     */
    public void sortByNumberChildren() {
        familyList.sort(new HumanComparatorByNumberChildren());
    }
}
