package ru.gb.family_tree.tree;

import ru.gb.family_tree.member_comparator.MemberComparatorByAge;
import ru.gb.family_tree.member_comparator.MemberComparatorByName;
import ru.gb.family_tree.member_comparator.MemberComparatorByNumberOfChild;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamileTreeItems<T>> implements Serializable, Iterable<T> {
    private List<T> tree;

    public FamilyTree(){
        tree = new ArrayList<>();
    }

    public void addHuman(T member){
        tree.add(member);
    }
    //поиск любого упоминания имени человека
    public List<T> findHuman(String name){
        List<T> list = new ArrayList<>();
        for (T member: tree){
            if (member.toString().contains(name)){
                list.add(member);
            }
        }
        return list;
    }

    public String getFullTree(){
        StringBuilder sb = new StringBuilder();
        sb.append("Древо: \n");
        for (T member: tree){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        tree.sort(new MemberComparatorByName<>());
    }
    public void sortByAge(){
        tree.sort(new MemberComparatorByAge<>());
    }
    public void sortByChild(){
        tree.sort(new MemberComparatorByNumberOfChild<>());
    }
    @Override
    public Iterator<T> iterator() {
        return new FTiterator<>(tree);
    }
}
