package Model.FamilyTree;

import Model.Creature.Entity;

import java.util.ArrayList;

public interface Tree{

    void addCreature(Entity creature);

    void removeCreature(int ID);

    Entity getCreature(int ID);

    int getLastHumanID();

    ArrayList<Entity> getCreature(String name, String surname);

    String getDescription();

    void setDescription(String description);

    void sortBySurname();

    void sortByChildren();

    void sortByName();

    void sortByID();

    @Override
    String toString();
}
