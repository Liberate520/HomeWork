package homeWork.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import homeWork.model.human.Human;
import homeWork.model.familyTree.FamilyTree;
import homeWork.model.familyTree.FamilyTreeSorter;
import homeWork.model.gender.Gender;

public class Service implements Writable {
    private FamilyTree<Human> tree1;
    private FamilyTreeSorter<Human> tree2;


    public Service() {
        tree1 = new FamilyTree<>();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father){
        Human human = new Human(name, dob, dod, gender, mother, father);
        tree1.addHuman(human);
    }

    public void addHuman(String name, LocalDate dob, Gender gender, Human mother, Human father){
        addHuman(name, dob, null, gender, mother, father);
    }

    public void addHuman(String name, LocalDate dob, Gender gender){
        addHuman(name, dob, null, gender, null, null);
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod ,Gender gender){
        addHuman(name, dob, dod, gender, null, null);
    }

    public String getTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (Human human: tree1){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Human findPerson(String name, LocalDate dob) {
        for (Human human : tree1) {
            if (human.getName().equals(name) && human.getDob().equals(dob)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getTree();
    }

    public void sortbyName(){
        tree2.sortbyName();
    }

    public void sortbyDate(){
        tree2.sortbyDate();
    }

    public void writeFile(Serializable serializable, String filename) {
        try(ObjectOutputStream objectOutputStream  = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream .writeObject(serializable);
            objectOutputStream.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public Object readFile(String filename) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object list = objectInputStream.readObject();
            objectInputStream.close();
            return list;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
