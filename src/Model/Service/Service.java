package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;
import Model.HumanBuilder.HumanBuilder;
import Model.Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Service extends ServiceAbstract<Human>{
//    public HumanBuilder humanBuilder;
//    public FamilyTree <Human> familyTree;
//    public FileHandler fileHandler;

    public Service() {
        super(new FamilyTree<Human>(), new HumanBuilder(), new FileHandler());
    }

    public boolean addHumanToTree(String name, LocalDate dateBrith, Gender gender){
//        Human human = humanBuilder.buildHuman(name, dateBrith, gender);
//        return familyTree.addHuman(human);
        return super.addHumanToTree(name, dateBrith, gender);
    }

    public FamilyTree<Human> getFamilyTree() {
//        return familyTree;
        return super.getFamilyTree();
    }

    public String familyTreeInfo (){
//        return familyTree.toString();
        return super.familyTreeInfo();
    }

    public void sortByNameFamilyTree(){
//        familyTree.sortByName();
        super.sortByNameFamilyTree();
    }
    public void sortByBirthDayFamilyTree(){
//        familyTree.sortByBirthDay();
        super.sortByBirthDayFamilyTree();
    }

    public boolean writeToFileTree(FamilyTree<Human> tree) throws IOException {
//        if (fileHandler.writeToFileObject(tree)) {
//            return true;
//        }
//        return false;
            return super.writeToFileTree(tree);

    }

    public FamilyTree <Human> readTreeInFile() throws IOException, ClassNotFoundException {
//        return (FamilyTree<Human>) fileHandler.readObjectInFile();
        return super.readTreeInFile();
    }

    public boolean addParent(long idParent, long idChild){
//        return familyTree.getById(idChild).addParent(familyTree.getById(idParent));
        return super.addParent(idParent, idChild);
    }

    public boolean addChild(long idParent, long idChild){
//        return familyTree.getById(idParent).addChild(familyTree.getById(idChild));
        return super.addChild(idParent, idChild);
    }
}
