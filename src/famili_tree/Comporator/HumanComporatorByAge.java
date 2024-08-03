package Comporator;

import java.util.*;

import Filehendler.FileHandler;
import Human.Human;




public class HumanComporatorByAge implements Comparator <Human>{
    
    public int compare (Human o1, Human o2){
        return Integer.compare(o1.getAge(),o2.getAge() );
    }
}