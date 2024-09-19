package ru.gb.family_tree.model.builder;

import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable, HumanBuilderInterface {
    private static final long serialVersionUID = 1L;

    public long genID;

    public Human build(String lastName, String name, Gender gender, LocalDate birthDate) {
        return new Human(genID++, lastName, name, gender, birthDate);
    }

    public void setStartId(long id) {
        this.genID = id;
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        out.defaultWriteObject();
    }


}