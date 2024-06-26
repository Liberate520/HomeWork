package ru.gb.family_tree.model.builder;

import java.time.LocalDate;

import ru.gb.family_tree.model.item.FamilyTreeItem;
import ru.gb.family_tree.model.item.Gender;

public class ItemBuilder<E extends FamilyTreeItem<E>> {
    private long maxId;

    public FamilyTreeItem<E> build( String name,
                                    Gender gender,
                                    LocalDate birthDate,
                                    LocalDate deathDate,
                                    E father,
                                    E mother) {

        return new FamilyTreeItem<E>(maxId++, name, gender, birthDate, deathDate, father, mother);
    }

    public FamilyTreeItem<E> build( String name,
                                    Gender gender,
                                    LocalDate birthDate,
                                    E father,
                                    E mother) {
 
        return new FamilyTreeItem<E>(maxId++, name, gender, birthDate, null, father, mother);
    }
    
    public FamilyTreeItem<E> build( String name,
                                    Gender gender,
                                    LocalDate birthDate) {

        return new FamilyTreeItem<E>(maxId++, name, gender, birthDate, null, null, null);
    }    

}