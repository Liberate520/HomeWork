package familytree.service;

import familytree.model.TreeMember;

import java.util.List;

public class Research {
    public static <T extends TreeMember> List<T> findChildren(T member) {
        return (List<T>) member.getChildren();
    }
}