package ru.gb2.family_tree7.model.group;

import ru.gb2.family_tree7.model.group.iterators.HumanIterator;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.model.human.comparators.HumanComparatorByDeathDate;
import ru.gb2.family_tree7.model.human.comparators.HumanComparatorByName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HumanGroup <E extends GroupItem> implements Iterable<E> {
    private List<E> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>(); // Инициализация списка людей
    }

    public void addHuman(E human) {
        if (human != null) {
            humanList.add(human); // Добавляем только ненулевые объекты
        } else {
            throw new IllegalArgumentException("Нельзя добавлять null"); // Исключение для null
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList); // Возвращаем новый итератор для списка
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName()); // Сортировка по имени
    }

    public void sortByDeathDate() {
        humanList.sort(new HumanComparatorByDeathDate<>()); // Сортировка по дате смерти
    }

    public void sortByGender() {
        humanList.sort(Comparator.comparing(human -> ((Human) human).getGender(), Comparator.nullsLast(Comparator.naturalOrder())));
    }

    public void sortByParents() {
        humanList.sort(Comparator.comparing(human -> {
            Human h = (Human) human;
            return (h.getFather() != null ? h.getFather().getId() : 0) + (h.getMother() != null ? h.getMother().getId() : 0);
        }));
    }

    public List<E> getHumanList() {
        return new ArrayList<>(humanList); // Добавляем возвращение списка
    }

    public void sortByChildren() {
        humanList.sort(Comparator.comparingInt(human -> ((Human) human).getChildren().size())); // Сортировка по количеству детей
    }

    public void sortByBirthDate() {
        humanList.sort(Comparator.comparing(
                human -> {
                    LocalDate birthDate = ((Human) human).getBirthDate(); // Здесь делаем приведение типов
                    return birthDate;
                },
                Comparator.nullsLast(Comparator.naturalOrder())
        ));
    }
}
