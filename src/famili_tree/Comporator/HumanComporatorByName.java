package Comporator;

import Human.*;

import java.util.Comparator;

import Filehendler.FileHandler;
import family_tree.FamilyTree;

import family_tree.*;

public class HumanComporatorByName<T extends FamilyTreeItem> implements Comparator <T> {
    public int compare (T o1, T o2){
        return o1.compareTo(o2);
    }
}

