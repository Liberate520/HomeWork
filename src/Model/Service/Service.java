package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.Human.Human;
import Model.Writer.FileHandler;

public class Service {
    private static int genLeafID;
    public static FamilyTree<Human> familyTree;

    public Service() {familyTree = new FamilyTree<>();}
    public static boolean addLeaf(Human leaf){
        if (leaf.getId() == -1){
            leaf.setId(genLeafID++);
            familyTree.addHuman(leaf);
            return true;
        }
        else return false;
    }
    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else return false;
    }
    public static void saveTree(FamilyTree<Human> tree, String filePath) {
        FileHandler handler = new FileHandler();
        handler.save(tree, filePath);
    }
    public static FamilyTree read(String filePath){
        FileHandler handler = new FileHandler();
        return (FamilyTree) handler.read(filePath);
    }
}
