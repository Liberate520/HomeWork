package Human;
import Pol.Pol;
import java.util.*;
import java.io.Serializable;
import java.time.*;

public interface FamilyTreeItem<T>  extends Serializable{

    T getSuprug();
    List <T> getChildren();
    String getName();
    String getFamilia();
    int getId();
    LocalDate getBirtdayDate();
    Pol getPol();
    int getAge();
    int compareTo(T t);
}

