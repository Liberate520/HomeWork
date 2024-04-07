package src.service;

import src.familyTree.FamilyTree;
import src.human.Gender;
import src.human.Human;

import java.time.LocalDate;

public class Service {
    //  Поля:
    private int genId;

    //  Constructor:
    public void addHuman(FamilyTree tree, String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(genId++, name, gender, birthDate);
        tree.add(human);
    }

    //  Method:
    //  Setters:

    /**
     * Add parent boolean.
     *
     * @param tree       the tree
     * @param thisName   this name
     * @param parentName parent name
     * @return the boolean
     */
    public boolean addParent(FamilyTree tree, String thisName, String parentName) {
        return tree.getByName(thisName).getFirst().addParent(tree.getByName(parentName).getFirst());
    }

    /**
     * Add parent boolean.
     *
     * @param tree     the tree
     * @param thisId   this id
     * @param parentId parent id
     * @return the boolean
     */
    public boolean addParent(FamilyTree tree, int thisId, int parentId) {
        return tree.getById(thisId).addParent(tree.getById(parentId));
    }

    /**
     * Sets wedding.
     *
     * @param tree          the tree
     * @param OneSpouseName the one spouse name
     * @param twoSpouseName the two spouse name
     * @return the wedding
     */
    public void setWedding(FamilyTree tree, String OneSpouseName, String twoSpouseName) {
        tree.setWedding(tree.getByName(OneSpouseName).getFirst(), tree.getByName(twoSpouseName).getFirst());
    }

    /**
     * Sets wedding.
     *
     * @param tree        the tree
     * @param OneSpouseId the one spouse id
     * @param twoSpouseId the two spouse id
     * @return the wedding
     */
    public void setWedding(FamilyTree tree, int OneSpouseId, int twoSpouseId) {
        tree.setWedding(OneSpouseId, twoSpouseId);
    }

    //  Getters:
    public String getHumanListInfo(FamilyTree tree) {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(tree.size());
        sb.append(" объектов: \n");
        for (Human human : tree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    //  Sorting:
    public void sortByName(FamilyTree tree) {
        tree.sortByName();
    }

    public void sortByAge(FamilyTree tree) {
        tree.sortByAge();
    }
    public void sortByDOB(FamilyTree tree) {
        tree.sortByDOB();
    }
    public void sortById(FamilyTree tree) {
        tree.sortById();
    }
}