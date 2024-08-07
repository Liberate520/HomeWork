package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.ItemFamilyTree;
import Model.Human.Gender;
import Model.HumanBuilder.Builder;
import Model.Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public abstract class ServiceAbstract<T extends ItemFamilyTree<T>> {

    protected FamilyTree<T> familyTree;
    protected Builder<T> builder;
    protected FileHandler fileHandler;

    public ServiceAbstract(FamilyTree<T> familyTree, Builder<T> builder, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.builder = builder;
        this.fileHandler = fileHandler;
    }

    public boolean addHumanToTree(String name, LocalDate dateBrith, Gender gender){
        T human = builder.buildHuman(name, dateBrith, gender);
        return familyTree.addHuman(human);
    }

    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }

    public String familyTreeInfo (){
        return familyTree.toString();
    }

    public void sortByNameFamilyTree(){
        familyTree.sortByName();
    }
    public void sortByBirthDayFamilyTree(){
        familyTree.sortByBirthDay();
    }

    public boolean addParent(long idParent, long idChild){
        return familyTree.getById(idChild).addParent(familyTree.getById(idParent));
    }

    public boolean addChild(long idParent, long idChild){
        return familyTree.getById(idParent).addChild(familyTree.getById(idChild));
    }

    public boolean writeToFileTree(FamilyTree<T> tree) throws IOException {
        if (fileHandler.writeToFileObject(tree)) {
            return true;
        }
        return false;

    }

    public FamilyTree <T> readTreeInFile() throws IOException, ClassNotFoundException {
        return (FamilyTree<T>) fileHandler.readObjectInFile();
    }
}
