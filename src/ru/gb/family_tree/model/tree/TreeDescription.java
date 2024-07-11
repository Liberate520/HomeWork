package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.tree.interfaces.TreeDescriptionable;

import java.util.List;

class TreeDescription<T> implements TreeDescriptionable<T> {
    public String getFullTree(List<T> tree){
        StringBuilder sb = new StringBuilder();
        sb.append("Древо: \n");
        for (T member: tree){
            sb.append(member);
            sb.append("\n");
    }
        return sb.toString();
}
}
