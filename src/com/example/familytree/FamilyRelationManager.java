package com.example.familytree;

import com.example.familytree.model.Person;

public class FamilyRelationManager {
    public void setParentChildRelation(Person parent, Person child) {
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }
}
