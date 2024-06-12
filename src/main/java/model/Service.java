package model;

import model.person.Human;
import model.tree.FamilyTree;
import model.tree.file.FilleHander;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private Human human;
    private int id;
    private FilleHander filehander;

    public Service() {
        familyTree =  new FamilyTree<>();
    }

    public void loadTree(String path) throws IOException, ClassNotFoundException {
        FilleHander filehander = new FilleHander();
        this.familyTree = (FamilyTree) filehander.reading(path);

    }

    public void saveTree(String path) throws IOException, ClassNotFoundException {
        FilleHander filehander = new FilleHander();
        if(filehander.saveing(this.familyTree, path)) System.out.println("Дерево cохранено по пути:" + path);

    }

    public void addHuman(String name, String gen, LocalDate birthDay){
        Human hum = new Human(name, gen, birthDay);
        this.familyTree.add(hum);
    }




//    public void CreateHuman(String string){
//        Human human = new Human();
//        human.setId(id++);
//
//    }

}
