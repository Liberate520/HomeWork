package Model.FamilyTree;

import java.io.Serializable;
import java.util.*;

import Model.Creature.Info;
import Model.FamilyTree.Comparators.*;
import Model.Creature.Entity;

public class FamilyTree<T extends Entity> implements Serializable {
    private final ArrayList<T> familyTree = new ArrayList<>();
    private int lastEntityID = 0;

    public void addEntity(T entity) {
        entity.setID(this.lastEntityID++);

        this.familyTree.add(entity);
    }

    public void removeEntity(int ID) {
        T entity = getEntity(ID);

        if (entity != null) {
            Entity mather = entity.getMather();
            Entity father = entity.getFather();
            Entity spouse = entity.getSpouse();
            ArrayList<T> children = (ArrayList<T>) new ArrayList<>(entity.getChildren());

            if (mather != null) mather.removeKid(entity);
            if (father != null) father.removeKid(entity);
            if (spouse != null) spouse.setSpouse(null);

            if (!children.isEmpty()) {
                for (T kid : children) {
                    if (kid.getFather().equals(entity)) kid.setFather(null);
                    else kid.setMather(null);
                }
            }
            this.familyTree.remove(entity);
        }
    }

    public T getEntity(int ID) {
        for (T entity : this.familyTree) {
            if (entity.getID() == ID) {
                return entity;
            }
        }
        return null;
    }

    public int getLastEntityID() {
        return lastEntityID;
    }

    public void sortBySurname() {
        this.familyTree.sort(new ComparatorBySurname<T>());
    }

    public void sortByID() {
        this.familyTree.sort(new ComparatorByID<T>());
    }

    public void sortByChildren() {
        this.familyTree.sort(new ComparatorByChildren<T>());
    }

    public void sortByName() {
        this.familyTree.sort(new ComparatorByName<T>());
    }

    public ArrayList<T> getFamilyTree() {
        return familyTree;
    }

    public ArrayList<Info> getInfo(){
        ArrayList<Info> infos = new ArrayList<>();;

        if (!this.familyTree.isEmpty()){
            for (T entity: this.familyTree) infos.add(entity.getInfo());
        }

        return infos;
    }
}
