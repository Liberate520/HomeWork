
package com.familytree.model.animal;

import com.familytree.model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;

public class Dog implements TreeNode, Serializable {
    private long id;
    private String name;
    private String breed;

    public Dog(String name, String breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return null;
    }

    public String getBreed() {
        return breed;
    }
}


