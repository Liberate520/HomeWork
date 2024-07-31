package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;
import Model.HumanBuilder.HumanBuilder;
import Model.Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    public HumanBuilder humanBuilder;
    public FamilyTree <Human> familyTree;
    public FileHandler fileHandler;

    public Service() {
        humanBuilder = new HumanBuilder();
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public boolean addHumanToTree(String name, LocalDate dateBrith, Gender gender){
        Human human = humanBuilder.buildHuman(name, dateBrith, gender);
        return familyTree.addHuman(human);
    }

    public FamilyTree<Human> getFamilyTree() {
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

    public boolean writeToFileTree(FamilyTree<Human> tree) throws IOException {
        if (fileHandler.writeToFileObject(tree)) {
            return true;
        }
        return false;

    }

    public FamilyTree <Human> readTreeInFile() throws IOException, ClassNotFoundException {
        return (FamilyTree<Human>) fileHandler.readObjectInFile();
    }

    public boolean addParent(long idParent, long idChild){
        return familyTree.getById(idChild).addParent(familyTree.getById(idParent));
    }

    public boolean addChild(long idParent, long idChild){
        return familyTree.getById(idParent).addChild(familyTree.getById(idChild));
    }
}
