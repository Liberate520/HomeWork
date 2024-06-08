package Organisms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Organism<T extends Organism> implements Comparable<T> {
    protected String name;
    protected LocalDate birthday, deathDate;
    protected List<T> children;
    public String getName() {
        return this.name;
    };
    public LocalDate getBirthday() {
        return this.birthday;
    }
    public LocalDate getDeathDate() {
        return this.deathDate;
    }
    public String getChildren() {
        String out = "";
        for (T somePers : children) {
            out += somePers;
        }
        return out;
    }
    public void addChildren(T child) {
        this.children.add(child);
    }
    public void addBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void addDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    /**
     * @return Метод вовзращает динамический массив с датой рождения, датой смерти (при наличии), в формате `LocalDate`
     *  */
    public ArrayList getDates() {
        ArrayList<LocalDate> personDate = new ArrayList<LocalDate>();
        personDate.add(birthday);
        if (deathDate.getYear() != 9999)
            personDate.add(deathDate);
        return personDate;
    }
}
