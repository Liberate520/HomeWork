package FamilyTree.Model.Service;

import FamilyTree.Model.Human;
import FamilyTree.Model.ItemTree.Gender;
import FamilyTree.Model.Tree.FamilyTree;
import FamilyTree.Model.Tree.Writable;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> tree;
    private Writable fileHandler;

    public Service(Writable fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void beginTree(Human root) {
        this.tree = new FamilyTree<>(root);

    }

    public List<String> getListInfo() {
        return this.tree.getAllFamilyTree();
    }

    /**
     * Метод устанавливает родителя персоне дерева.
     */
    public void establishPaternity(int innParent, int innChildren) {
        this.tree.establishPaternity(innParent, innChildren);
    }


    public void establishPaternity(String fName, String lName, Gender gender, LocalDate dataB, int innChildren) {
        this.tree.establishPaternity(Human.create(fName, lName, gender, dataB), innChildren);
    }

    public void establishPaternity(int innParent, String fName, String lName, Gender gender, LocalDate dataB) {
        this.tree.establishPaternity(innParent, Human.create(fName, lName, gender, dataB));
    }

    public void establishMarriage(int innParent, int innChildren) {
        this.tree.establishMarriage(innParent, innChildren);
    }

    public void establishMarriage(int innPartner, String fName, String lName, Gender gender, LocalDate dataB) {
        this.tree.establishPaternity(innPartner, Human.create(fName, lName, gender, dataB));
    }


    public void sortByName() {
        this.tree.sortByName();
    }

    public void sortByAge() {
        this.tree.sortByName();
    }


    public void readToFile(String namefile) throws IOException {
        File file = new File(namefile);
        this.tree = this.fileHandler.read(file);

    }

    public void saveToFile(String namefile) throws IOException {
        this.fileHandler.save(this.tree, new File(namefile));
    }
}