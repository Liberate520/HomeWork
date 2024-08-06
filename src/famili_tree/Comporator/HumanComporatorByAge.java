package Comporator;

import java.util.*;

import Filehendler.FileHandler;
import Human.*;
import family_tree.*;


public class HumanComporatorByAge<T extends FamilyTreeItem> implements Comparator <T>{
    
    public int compare (T o1, T o2){
        return Integer.compare(o1.getAge(),o2.getAge() );
    }
}