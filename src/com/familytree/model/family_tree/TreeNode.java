package com.familytree.model.family_tree;

import com.familytree.model.human.Gender;
import com.familytree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode extends Serializable {
    long getId();
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<Human> getParents();
    List<Human> getChildren();
    TreeNode getSpouse();
    void setSpouse(TreeNode spouse);
    void addParent(TreeNode parent);
    void addChild(TreeNode child);

}
