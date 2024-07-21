package Model;

import Model.Creatures.Gender.Gender;
import Model.Creatures.Human;
import Model.FamilyTree.FamilyTree;
import Model.Interface.Creature;
import Model.Interface.FamilyTreeInterface;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    private static final ArrayList<String> availableCreatures = new ArrayList<>(List.of(creatureType.human.toString()));
    private static final ArrayList<String> availableDataAboutCreature = new ArrayList<>(List.of(
            "name", "surname", "gender", "mather", "father", "spouse", "children", "data of birth", "data of death"
    ));

    public enum creatureType {
        human
    }

    public FamilyTreeInterface<?> createNewFamilyTree(String nameCreature) {

        if (nameCreature.equalsIgnoreCase(creatureType.human.toString()))
            return new FamilyTree<Human>(creatureType.human);

        return null;
    }

    public Creature<?> createNewCreature(String name, String surname, Gender gender, creatureType typeCreature){
        if (typeCreature.toString().equalsIgnoreCase(creatureType.human.toString()))
            return new Human(name, surname, gender);

        return null;
    }

    public ArrayList<String> getAvailableCreatures() {
        return availableCreatures;
    }

    public ArrayList<String> getAvailableDataAboutCreature() {
        return availableDataAboutCreature;
    }
}
