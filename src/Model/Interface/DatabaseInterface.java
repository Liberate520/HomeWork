package Model.Interface;

import java.util.ArrayList;

public interface DatabaseInterface {
    FamilyTreeInterface<?> getFamilyTree(String name);
    ArrayList<String> getAvailableCreatures();
    FamilyTreeInterface<?> createNewFamilyTree(String nameCreature);
}
