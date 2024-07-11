package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByAge;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByName;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByNumberOfChild;
import ru.gb.family_tree.model.tree.interfaces.FamileTreeItems;
import ru.gb.family_tree.model.tree.interfaces.Searchable;
import ru.gb.family_tree.model.tree.interfaces.Sortable;
import ru.gb.family_tree.model.tree.interfaces.TreeDescriptionable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamileTreeItems<T>> implements Serializable, Iterable<T>, Sortable, Searchable {
    private List<T> tree;

    public FamilyTree(){
        tree = new ArrayList<>();
    }

    public void addMember(T member){
        tree.add(member);
    }
    //поиск любого упоминания имени человека
    public List<T> findAllInfoByName(String name){
        List<T> list = new ArrayList<>();
        for (T member: tree){
            if (member.toString().contains(name)){
                list.add(member);
            }
        }
        return list;
    }
    public T findMember(String name){
        for (T member: tree){
            if (member.getName().contains(name)){
                return member;
            }
        }
        return null;
    }

    public String getFullTree(){
        TreeDescriptionable df = new TreeDescription();
        return df.getFullTree(tree);
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
