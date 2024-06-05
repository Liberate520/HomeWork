package presenter;
import model.family_tree.instances.Human;
import model.family_tree.tree.FamilyTree;
import model.family_tree.writer.FileHandler;
import model.family_tree.writer.Writable;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private FamilyTree familyTree;
    private Writable writable;

    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<Human>();
        writable = new FileHandler();
    }

    public boolean addToTree(Human human){
        return familyTree.addToTree(human);
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        familyTree = writable.readFromFamilyTree("savesFamilyTree.ftr");
    }

    public void saveToFile() throws IOException {
        writable.writeToFamilyTree(familyTree, "savesFamilyTree.ftr");
    }

    public void showTree(){
        System.out.println(familyTree);
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByDeathDate() {
        familyTree.sortByBirthDate();
    }

    public boolean setMother(Human oojToSet, Human mother){
        return familyTree.setMother(oojToSet, mother);
    }

    public boolean setFather(Human oojToSet, Human father){
        return familyTree.setFather(oojToSet, father);
    }

    public int getNumbeInfamily(){
        return familyTree.getNumInFamily();
    }

    public Human getFamilyMember(int index){
        return (Human)familyTree.getFamilyMenber(index);
    }
}
