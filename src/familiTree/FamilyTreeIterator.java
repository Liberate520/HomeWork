package familiTree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {


    private List<Human> list;
    private int currentId;

    public FamilyTreeIterator(List<Human> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() { // метод hasNext() проверяет есть ли следующий объект
        return list.size() > currentId;
    }

    @Override
    public Human next() { // метод next() возвращает следующий объект
        return list.get(currentId++);
    }
}
