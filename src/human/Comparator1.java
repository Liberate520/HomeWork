package human;

import java.util.Comparator;
public class Comparator1 implements Comparator<Human> {
   @Override
    public int compare(Human o1,Human o2){
       return o1.getBrthDate().compareTo(o2.getBrthDate());
   }


}
