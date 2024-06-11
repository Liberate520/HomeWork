package model;

import model.person.Human;
import model.tree.FamilyTree;
import model.tree.file.FilleHander;

import java.io.IOException;

public class Service {
    private FamilyTree familyTree;
    private Human human;
    private int id;
    private FilleHander filehander;
    public void CreateTree(){
        FamilyTree tree = new FamilyTree();
    }

    public FamilyTree LoadTree(String path) throws IOException, ClassNotFoundException {
        FilleHander filehander = new FilleHander();
        FamilyTree tree = new FamilyTree();
        return  tree = (FamilyTree) filehander.reading(path);

    }
//    public void CreateHuman(String string){
//        Human human = new Human();
//        human.setId(id++);
//
//    }

}
