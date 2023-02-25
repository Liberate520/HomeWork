import java.util.Comparator;

public class HumanComparatorByYearBirth<T extends Individual> implements Comparator<T>{

    @Override
    public int compare (T o1, T o2) {       
        return Integer.compare(o1.getYearofbirth(), o2.getYearofbirth());
    }
    
}
