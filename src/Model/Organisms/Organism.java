package Model.Organisms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Organism<T extends Organism> implements Comparable<T> {
    protected int id;
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
    public void addBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public int getId() {
        return this.id;
    }
}

