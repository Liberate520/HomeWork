package Model.FamilyTree;

import java.io.Serializable;
import java.util.*;

import Model.FamilyTree.Comparators.*;
import Model.Creature.Entity;

public class FamilyTree implements Serializable, Tree {
    private int lastHumanID = 0;
    private final ArrayList<Entity> familyTree = new ArrayList<>();
    private String description;

    public FamilyTree(String description){
        this.description = description;
    }

    public void addCreature(Entity creature) {
        this.familyTree.add(creature);

        lastHumanID++;
    }

    public void removeCreature(int ID){
        Entity creature = getCreature(ID);

        if (creature != null){
            Entity mather = creature.getMather();
            Entity father = creature.getFather();
            Entity spouse = creature.getSpouse();
            ArrayList<Entity> children = new ArrayList<>(creature.getChildren());

            if (mather != null) mather.removeKid(creature);
            if (father != null) father.removeKid(creature);
            if (spouse != null) spouse.setSpouse(null);

            if (!children.isEmpty()){
                for (Entity kid: children){
                    if (kid.getFather().equals(creature)) kid.setFather(null);
                    else kid.setMather(null);
                }
            }
            this.familyTree.remove(creature);
        }
    }

    public Entity getCreature(int ID){
        for(Entity creature: this.familyTree){
            if (creature.getID() == ID){
                return creature;
            }
        }
        return null;
    }

    @Override
    public int getLastHumanID() {
        return lastHumanID;
    }

    public ArrayList<Entity> getCreature(String name, String surname){
        ArrayList<Entity> creatures = new ArrayList<>();

        for (Entity creature: this.familyTree){
            if (creature.getName().equalsIgnoreCase(name) && creature.getSurname().equalsIgnoreCase(surname)){
                creatures.add(creature);
            }
        }

        return creatures;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void sortBySurname(){
        this.familyTree.sort(new ComparatorBySurname<Entity>());
    }

    public void sortByID(){
        this.familyTree.sort(new ComparatorByID<Entity>());
    }

    public void sortByChildren(){
        this.familyTree.sort(new ComparatorByChildren<Entity>());
    }

    public void sortByName(){
        this.familyTree.sort(new ComparatorByName<Entity>());
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        if (!this.familyTree.isEmpty()){
            for (int index = 0; index != familyTree.size() - 1; index++){
                info.append(familyTree.get(index)).append("\n");
            }
            info.append(familyTree.getLast());
        }
        return info.toString();
    }
}
