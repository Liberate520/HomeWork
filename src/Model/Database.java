package Model;

import Model.Creatures.Human;
import Model.FamilyTree.FamilyTree;
import Model.Interface.DatabaseInterface;
import Model.Interface.FamilyTreeInterface;

import java.io.Serializable;

public class Database implements DatabaseInterface, Serializable {
    public enum creatureType {
        human
    }

    public FamilyTreeInterface<?> createNewFamilyTree(String nameCreature) {
        if (nameCreature.equalsIgnoreCase(creatureType.human.toString()))
            return new FamilyTree<Human>(Human::new);

        return null;
    }

    public FamilyTreeInterface<?> getFamilyTree(String name){
        return null;
    }
}


