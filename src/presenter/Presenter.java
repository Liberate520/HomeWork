package presenter;
import model.family_tree.instances.Human;
import model.family_tree.service.Service;
import model.family_tree.tree.FamilyTree;
import model.family_tree.writer.FileHandler;
import model.family_tree.writer.Writable;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private FamilyTree<Human> familyTree;
    private FileHandler writable;
    private Service<Human> service;

    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<Human>();
        writable = new FileHandler();
        service = new Service<Human>(familyTree, writable);
    }

    public boolean addToTree(Human human){
        return service.addToTree(human);
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        service.readFromFamilyTree("savesFamilyTree.ftr");
    }

    public void saveToFile() throws IOException {
        service.writeToFamilyTree("savesFamilyTree.ftr");
    }

    public void showTree(){
        System.out.println(service.ShowTree());
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
    }

    public boolean setMother(Human objToSet, Human mother){
        return service.setMother(objToSet, mother);
    }

    public boolean setFather(Human objToSet, Human father){
        return service.setFather(objToSet, father);
    }

    public int getNumbeInfamily(){
        return service.getNumInFamily();
    }

    public Human getFamilyMember(int index){
        return service.getFamilyMember(index);
    }
}
