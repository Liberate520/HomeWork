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

public class HumanService {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    private Writer rw;
    private String path;

    public HumanService(){
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
        rw = new FileHandler();
        path = "tree.out";
    }

    public int size(){
        return tree.size();
    }

    // HUMAN
    public boolean setParent(int childId, int parentId){
        return tree.getById(childId).setParent(tree.getById(parentId));
    }

    public Human getById(int id){
        return tree.getById(id);
    }

    // TREE
    public boolean addHumanToTree(String name, LocalDate birthDate, Gender gender){
        Human human = builder.create(name, birthDate, gender);
        return tree.add(human);
    }

    public String printTreeInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human human : tree){
            sb.append(human).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void setRelationships(){
        tree.setAllRelationships();
    }

    public Set<Human> getSiblings(int id){
        Human human = tree.getById(id);
        return tree.getSiblings(human);
    }

    public Set<Human> getDescendants(int id, int generation){
        Human human = tree.getById(id);
        return tree.getDescendants(human, generation);
    }

    public Set<Human> getAncestors (int id, int generation){
        Human human = tree.getById(id);
        return tree.getAncestors(human, generation);
    }

    //Sorts
    public void sortById(){
        tree.sortById();
    }

    public Set<Human> getChildren(int id){
        return tree.getById(id).getChildren();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    // FILEHANDLER
    public void save(String path) throws IOException {
        rw.write(path, tree);
    }

    public void save() throws IOException {
        rw.write(this.path, tree);
    }

    public void load(String path) throws IOException, ClassNotFoundException {
        this.tree = rw.read(path);
    }
    public FamilyTree load() throws IOException, ClassNotFoundException {
        return rw.read(this.path);
    }

}
