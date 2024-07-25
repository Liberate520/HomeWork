package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.util.List;
import java.util.ArrayList;

public class FamilyTree {
    private long humanId;
    private List<Human> humanList;

    /**
     * Конструктор по умолчанию, инициализирующий список людей.
     */
    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    /**
     * Добавляет человека в семейное древо.
     * @param human объект класса Human
     * @return true если человек успешно добавлен, иначе false
     */
    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            addParentsRelations(human);
            addChildrenRelations(human);

            return true;
        }
        return false;
    }

    /**
     * Добавляет родительские связи для человека.
     * @param human объект класса Human
     */
    private void addParentsRelations(Human human) {
        Human mother = human.getMother();
        if (mother != null) {
            mother.addChild(human);
        }

        Human father = human.getFather();
        if (father != null) {
            father.addChild(human);
        }
    }

    /**
     * Добавляет детские связи для человека.
     * @param human объект класса Human
     */
    private void addChildrenRelations(Human human) {
        if (human.getChildren().size() > 0) {
            for (Human child : human.getChildren()) {
                if (human.getGender() == Gender.female) {
                    child.setMother(human);
                } else {
                    child.setFather(human);
                }
            }
        }
    }

    /**
     * Ищет человека в семейном древе по ID.
     * @param id идентификатор человека
     * @return объект класса Human, если найден, иначе null
     */
    public Human findById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                System.out.println(human);
                return human;
            }
        }
        return null;
    }

    /**
     * Ищет людей в семейном древе по имени.
     * @param name имя человека
     * @return список объектов класса Human с заданным именем
     */
    public List<Human> findByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        for (Human human : res) {
            System.out.println(human);
        }
        return res;
    }

    /**
     * Возвращает информацию о семейном древе.
     * @return строка с информацией о семейном древе
     */
    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Humans in family: ");
        sb.append(humanList.size() + "\n\n------------\nThey are:\n\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getAboutFamily();
    }
}