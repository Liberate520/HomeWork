package model.essences;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.handlers.Saveable;

public abstract class Creature<E> implements Saveable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Set<E> parents;
    private Set<E> children;
    private List<E> creatureList;

    public Creature(String firstName, String lastName, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.parents = new HashSet<>();
        this.children = new HashSet<>();
        this.creatureList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract Set<E> getParents();

    public abstract Set<E> getChildren();

}
