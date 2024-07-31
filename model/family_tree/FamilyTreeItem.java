package model.family_tree;

import model.human.Gender;

public interface FamilyTreeItem {
    int getId();

    int getAge();

    String getName();

    Gender getGender();
}