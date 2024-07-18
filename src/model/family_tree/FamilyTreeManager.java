package model.family_tree;

import model.builder.Human;

import java.util.List;

public interface FamilyTreeManager {
    boolean addHuman(Human human);
    boolean setWedding(Human human1, Human human2);
    boolean setDivorce(Human human1, Human human2);
    List<Human> getSiblings(Human human);
    List<Human> getByName(String name);
    String getFamilyTreeInfo();
}
