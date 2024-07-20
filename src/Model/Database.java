package Model;

import Model.Interface.DatabaseInterface;
import Model.Interface.FamilyTreeInterface;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements DatabaseInterface, Serializable {
    public static final String SUCCESSFUL = "Successful";
    public static final String OBJECT_EXIST = "This object already exists";

    private final Creator creator = new Creator();


    public FamilyTreeInterface<?> createNewFamilyTree(String nameCreature) {
        return this.creator.createNewFamilyTree(nameCreature);
    }

    public FamilyTreeInterface<?> getFamilyTree(String name){
        return null;
    }

    public ArrayList<String> getAvailableCreatures() {
        return Creator.getAvailableCreatures();
    }
}


