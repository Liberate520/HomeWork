package Human;

import java.util.*;
import java.io.Serializable;


public interface FamilyTreeItem<T>  extends Serializable{
    
    T getSuprug();
    List <T> getChildren();
    String getName();
    int getAge();
    int compareTo(T t);
}
