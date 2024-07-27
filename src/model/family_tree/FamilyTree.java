package model.family_tree;

import java.io.Serializable;
import java.util.*;

import model.builder.Gender;
import model.builder.Human;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private static final long serialVersionUID = 1L;
    private final List<E> humanList;
    private int humansId;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public E getById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    /**
     * Потенциальные кандидаты на супруга(у)
     * список не содержит детей и родителей текущего человека и исключает себя
     * @param human текущий человек
     * @return потенциальные кандидаты
     */
    public List<E> getPotentialSpouses(E human) {
        List<E> potentialSpouses = new ArrayList<>();
        for (E person : humanList) {
            boolean isNotChildOrParent = !human.getParents().contains(person) && !human.getChildren().contains(person);
            boolean isEligibleSpouse = !person.equals(human) && person.getSpouse() == null && human.getGender() != person.getGender();

            if (isNotChildOrParent && isEligibleSpouse) {
                potentialSpouses.add(person);
            }
        }
        return potentialSpouses;
    }

    public void addParent(E human, E parent) {
        if (parent.getGender() == Gender.MALE && !human.getParents().contains(parent)) {
            human.addParent(parent);
            parent.addChild(human);
        } else if (parent.getGender() == Gender.FEMALE && !human.getParents().contains(parent)) {
            human.addParent(parent);
            parent.addChild(human);
        }
    }

    public void addChild(E parent, E child) {
        if (!parent.getChildren().contains(child)) {
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return humanList.iterator();
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public int getHumanListSize() {
        return humanList.size();
    }

    /**
     * Поиск потенциальных родителей по гендеру
     * @param gender искать по гендеру
     * @param human для кого искать
     * @return список потенциальных родителей (исключает себя, супруга(у), детей)
     */
    public <T extends Human> List<T> getPotentialParentsByGender(Gender gender, T human) {
        List<T> potentialParents = new ArrayList<>();
        if (humanList != null) {
            for (E person : humanList) {
                boolean isNotSelf = !person.equals(human);
                boolean isNotSpouse = human.getSpouse() == null || !human.getSpouse().equals(person);
                boolean isNotChild = !human.getChildren().contains(person);

                if (person.getGender() == gender && isNotSelf && isNotSpouse && isNotChild) {
                    potentialParents.add((T) person);
                }
            }
        }
        return potentialParents;
    }

    /**
     * Поиск потенциальных детей
     * @param human пользователь, для которого идёт поиск
     * @return список потенциальных детей (исключает себя, имеющихся детей, родителей, супруга(у))
     */
    public <T extends Human> List<T> getPotentialChildren(T human) {
        List<T> potentialChildren = new ArrayList<>();
        for (E person : humanList) {
            boolean isNotSelf = !person.equals(human);
            boolean isNotChild = !human.getChildren().contains(person);
            boolean isNotParent = !human.getParents().contains(person);
            boolean isNotSpouse = human.getSpouse() == null || !human.getSpouse().equals(person);

            if (isNotSelf && isNotChild && isNotParent && isNotSpouse) {
                potentialChildren.add((T) person);
            }
        }
        return potentialChildren;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FamilyTree{\n");
        sb.append("humanList=").append(" [\n");

        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            E human = iterator.next();
            sb.append("  ").append(human).append(",\n");
        }

        sb.append("]\n}");
        return sb.toString();
    }
}


