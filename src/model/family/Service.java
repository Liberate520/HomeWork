package model.family;

import model.family.human.Gender;
import model.family.human.Human;
import model.family.human.HumanBuilder;
import model.family.tree.FamilyTree;
import model.rw.FileHandler;
import model.rw.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public abstract class Service<T extends Alivable<T>> {
    protected FamilyTree<T> tree;
    protected Builder<T> builder;
    protected Writer rw;
//    protected String path;

    public Service(FamilyTree<T> tree, Builder<T> builder, Writer rw) {
        this.tree = tree;
        this.builder = builder;
        this.rw = rw;
//        this.path = path;
    }

    public int size(){
        return tree.size();
    }

    // HUMAN
    public boolean setParent(int childId, int parentId){
        return tree.getById(childId).setParent(tree.getById(parentId));
    }

    public T getById(int id){
        return tree.getById(id);
    }

    // TREE
    public boolean addHumanToTree(String name, LocalDate birthDate, Gender gender){
        T human = builder.create(name, birthDate, gender);
        return tree.add(human);
    }

    public String printTreeInfo(){
        StringBuilder sb = new StringBuilder();
        for (T human : tree){
            sb.append(human).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void setRelationships(){
        tree.setAllRelationships();
    }

    public Set<T> getSiblings(int id){
        T human = tree.getById(id);
        return tree.getSiblings(human);
    }

    public Set<T> getDescendants(int id, int generation){
        T human = tree.getById(id);
        return tree.getDescendants(human, generation);
    }

    public Set<T> getAncestors (int id, int generation){
        T human = tree.getById(id);
        return tree.getAncestors(human, generation);
    }

    //Sorts
    public void sortById(){
        tree.sortById();
    }

    public Set<T> getChildren(int id){
        return tree.getById(id).getChildren();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    // FILEHANDLER
    public void save() throws IOException {
        rw.write(tree);
    }

    public void load() throws IOException, ClassNotFoundException {
        this.tree = rw.read();
    }

    public void setWriter(Writer writer) {
        this.rw = writer;
    }

    public String getPath(){
        return rw.getPath();
    }

}