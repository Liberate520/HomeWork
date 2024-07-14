package familyTreeSrc;

import person.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int currentId;
    private List<Human> people;

    public FamilyTreeIterator(int currentId, List<Human> people) {
        this.people = people;
    }

    // Метод проверки, есть ли следующий элемент в списке
    @Override
    public boolean hasNext() {
        return currentId < people.size();
    }

    // Метод для получения следующего элемента в списке
    @Override
    public Human next() {
        return people.get(currentId++);
    }
}
