package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTreeList = new ArrayList<>();

    public void addHumansInFamTree(Human... human) {
        for (Human fam: human) {
            familyTreeList.add(fam);
        }

    }

    public Human findHuman(String firstName){
        for (Human el : familyTreeList) {
            if (el.getFirstName().equals(firstName)){
                return el;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Human el: familyTreeList) {
            str.append(el + "\n");
        }
        String res = String.valueOf(str);
        return res;
    }
}
