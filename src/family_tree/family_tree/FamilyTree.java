package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.human.HumanComparatorByName;
import family_tree.human.HumanComparatorByBirthDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// Определение класса FamilyTree
public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private List<Human> humanList; // Список людей в дереве

    // Конструктор класса
    public FamilyTree() {
        this.humanList = new ArrayList<>(); // Создание пустого списка людей
    }

    // Метод добавления члена семьи
    public void addMember(Human member) {
        this.humanList.add(member); // Добавление члена семьи в список
    }

    // Метод получения всех членов семьи
    public List<Human> getMembers() {
        return humanList; // Возвращаем список всех членов семьи
    }

    // Метод сортировки по имени
    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>()); // Сортировка списка по имени
    }

    // Метод сортировки по дате рождения
    public void sortByDateOfBirth() {
        humanList.sort(new HumanComparatorByBirthDate<>()); // Сортировка списка по дате рождения
    }

    // Реализация интерфейса Iterable<Human>
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
}
