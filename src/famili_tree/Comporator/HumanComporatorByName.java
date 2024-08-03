package Comporator;

import Human.Human;

import java.util.Comparator;

import Filehendler.FileHandler;
import family_tree.FamilyTree;

public class HumanComporatorByName implements Comparator <Human> {
    public int compare (Human o1, Human o2){
        return o1.compareTo(o2);
    }
}