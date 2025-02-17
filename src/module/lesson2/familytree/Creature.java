package module.lesson2.familytree;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Creature <T>{
    String getName();
    ArrayList<T> getParents();
    ArrayList<T> getAmountOfChildren();
    LocalDate getDateBirth();
    LocalDate getDateDeath();
    int howManyYears(LocalDate localDate, LocalDate localDateTwo);

    String getInfo();
}
