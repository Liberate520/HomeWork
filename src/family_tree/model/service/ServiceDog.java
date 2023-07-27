package family_tree.model.service;

import family_tree.model.dog.Dog;
import family_tree.model.gender.Gender;
import family_tree.model.tree.Tree;

import java.time.LocalDate;


public class ServiceDog implements Service{
    private int idPerson;
    private Tree tree;
    private FileHandler fileHandler;

    public ServiceDog() {

        this.tree = new Tree<Dog>();
        this.fileHandler = new FileHandler();
    }

    public void add(String name,
                    LocalDate birthday,
                    LocalDate dayOfDeath,
                    Gender gender){
            this.tree.add(new Dog(name,
                    birthday,
                    dayOfDeath,
                    gender,
                    idPerson++));
    }

    public Object getPerson(String name){
        return tree.getPerson(name);
    }

    public void reviseDependencies() {
        tree.reviseDependencies();
    }

    public void print(){
        System.out.println(tree);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void saveTreeInFile(){
        fileHandler.save(tree);
    }

    public void readTreeFromFile(){
        tree = (Tree) fileHandler.read();
    }

}
