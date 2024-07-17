package Model.family_tree;


import Model.family_tree.human.*;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<C extends Item<C>> implements Iterable<C>, Serializable {

    private List<C> humans;
    private int humansId;
    private CommunicationTree communicationTree;
    private InformationTree informationTree;
    private SortTree sortTree;


    public FamilyTree(List<C> humanList) {
        this.humans = humanList;


    }


    public FamilyTree() {
        this(new ArrayList<>());

    }


    public boolean add(C human) {

        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public List<C> getHumans() {
        return humans;
    }


    private void addToParents(C human) {
        communicationTree.addToParents(human);

    }

    private void addToChildren(C human) {
        communicationTree.addToChildren(human);
    }

    public List<C> getSiblings(int id) {


        return communicationTree.getSiblings(id);
    }

    public C getById(int id) {
        for (C human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public boolean setWedding(C human1, C human2) {

        return communicationTree.setWedding(human1, human2);
    }


    public boolean setFamily(int id1, int id2) {

        return communicationTree.setFamily(id1, id2);

    }

    public String getInfo() {
        return informationTree.getInfo();
    }

    public void SortByName() {
        sortTree.SortByName();
    }

    public void SortByBrthDate() {
        sortTree.SortByBrthDate();
    }

    public void sortById() {
        sortTree.sortById();
    }

    @Override
    public Iterator<C> iterator() {
        return humans.iterator();
    }


    @Override
    public String toString() {
        return informationTree.getInfo();
    }


}
