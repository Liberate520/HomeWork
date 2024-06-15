

package com.familytree.model.human;

import com.familytree.model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode, Serializable {
    private long id;
    private String name;
    private LocalDate birthDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
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
        return birthDate;
    }
}


