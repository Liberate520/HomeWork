package familytree.model;

import familytree.writer.FileHandler;
import familytree.writer.Writer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Iterable<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }

    public List<T> getChildrenOf(T member) {
        return (List<T>) member.getChildren();
    }

    public T findMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getParentsOf(T member) {
        return (List<T>) member.getParents();
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    // Методы для сохранения и чтения дерева
    public void save(String filePath) {
        Writer fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(this);
    }

    public static <T extends FamilyMember> FamilyTree<T> read(String filePath) {
        Writer fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        FamilyTree<T> tree = (FamilyTree<T>) fileHandler.read();
        return tree != null ? tree : new FamilyTree<>(); // Возвращаем пустое дерево, если файл не существует
    }
}