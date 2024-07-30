package family_tree;

import human.Gender;

public interface FamilyTreeItem {
    int getId();

    int getAge();

    String getName();

    Gender getGender();
}