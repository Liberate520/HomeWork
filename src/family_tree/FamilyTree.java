package family_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a family tree with a list of humans and provides methods to manipulate the tree.
 */
public class FamilyTree {
    private long idForGen;
    private final List<Human> humanList;

    /**
     * Constructs a FamilyTree with the specified list of humans.
     *
     * @param humanList the initial list of humans
     */
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    /**
     * Constructs an empty FamilyTree.
     */
    public FamilyTree() {
        this(new ArrayList<>());
    }

    /**
     * Adds a human to the family tree if they are not already present.
     *
     * @param human the human to add
     * @return true if the human was added, false otherwise
     */
    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(idForGen++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    /**
     * Gets the siblings of a human specified by their ID.
     *
     * @param id the ID of the human
     * @return a list of siblings, or null if the human is not found
     */
    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
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

    /**
     * Gets a list of humans by their name.
     *
     * @param name the name to search for
     * @return a list of humans with the specified name
     */
    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    /**
     * Sets a wedding between two humans if both are not already married.
     *
     * @param human1 the first human
     * @param human2 the second human
     * @return true if the wedding was set, false otherwise
     */
    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets a divorce between two humans if both are married to each other.
     *
     * @param human1 the first human
     * @param human2 the second human
     * @return true if the divorce was set, false otherwise
     */
    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a human from the family tree by their ID.
     *
     * @param humanId the ID of the human to remove
     * @return true if the human was removed, false otherwise
     */
    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            Human human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < idForGen && id >= 0;
    }

    /**
     * Gets a human by their ID.
     *
     * @param id the ID of the human to retrieve
     * @return the human with the specified ID, or null if not found
     */
    public Human getById(long id) {
        if (checkId(id)) {
            for (Human human : humanList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    /**
     * Gets information about the family tree.
     *
     * @return a string containing information about the family tree
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}