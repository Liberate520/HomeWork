package Human.comparators;

import Human.Human;

import java.util.Comparator;
import java.time.LocalDate;
import java.time.Period;

public class HumanComparatorByBirthdate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Period.between(o1.getBirthDate(), LocalDate.now()).getYears() -
                Period.between(o2.getBirthDate(), LocalDate.now()).getYears();
    }
}
