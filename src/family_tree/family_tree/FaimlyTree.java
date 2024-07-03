package family_tree.family_tree;

import java.util.ArrayList;
import java.util.List;

import family_tree.human.Human;

/**
 * FaimlyTree - операции непосредственно с самии деревом, связями
 */

public class FaimlyTree {
    private long humansId;
    private List<Human> humanList;

    public FaimlyTree() {
        this(new ArrayList<>());
    }

    public FaimlyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    // TODO переделать (сейчас сначала проверяем id и потом присваиваем)
    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            // 2 метода, создающие обратные связи
            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    // Перебор родителей данного человека и если они есть каждому добавляется
    // ребёнок
    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    // Перебор детей и если они есть добавляем родителей
    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    // Методы поиска братьев и сестёр
    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        // Получаем список братьев и сестёр, кроме самого себя
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    // Поиск по имени
    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        // res?
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    // public boolean setWedding(long humanId1, long humanId2) {
    // if (checkId(humanId1) && checkId(humanId2)) {
    // Human human1 = getById(humanId1);
    // Human human2 = getById(humanId2);
    // if (human1.getSpouse() == null && human2.getSpouse() == null) {
    // human1.setSpouse(human2);
    // human2.setSpouse(human1);
    // } else {
    // return false;
    // }
    // }
    // return false;
    // }

    // Вариант с перегрузкой setWedding: id & human

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    // public boolean setDivorce(long humanId1, long humanId2) {
    // if (checkId(humanId1) && checkId(humanId2)) {
    // Human human1 = getById(humanId1);
    // Human human2 = getById(humanId2);
    // if (human1.getSpouse() != null && human2.getSpouse() != null) {
    // human1.setSpouse(null);
    // human2.setSpouse(null);
    // } else {
    // return false;
    // }
    // }
    // return false;
    // }

    // Развод, по аналогии с setWedding

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    // Удаление записи, на случай ошибочного добавления
    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    // Проверка на диапазон id
    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    // Поиск Human по id
    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
