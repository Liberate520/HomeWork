import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/ramilbagirov/Desktop/Murad/GeekBrains/git_education/Git_Java/homeWork/src/tree.txt";


        FamilyTree tree = testTree();
        System.out.println(tree.getFamilyTree());

        save(tree, filePath);
    
    }


        static void save(FamilyTree familyTree, String filePath) {
            FileHandler fileHandler = new FileHandler();
            fileHandler.save(familyTree, filePath);
        }

        static FamilyTree read(String filePath) {
            FileHandler fileHandler = new FileHandler();
            return (FamilyTree) fileHandler.read(filePath);
        }

        static FamilyTree testTree() {
            FamilyTree familyTree = new FamilyTree();

            List<Human> treeList = new ArrayList<>();
            List<Human> children1 = new ArrayList<>();
            List<Human> children2 = new ArrayList<>();
            Human human1 = new Human("Vagif", "male", null, null);
            Human human2 = new Human("Naila", "female", null, null);
            Human human3 = new Human("Ramil", "male", human1, human2);
            Human human4 = new Human("Nigar", "female", null, null);
            Human human5 = new Human("Murad", "male", human3, human4);
            Human human6 = new Human("Ayla", "female", human3, human4);
            human1.SetDateOfBirth(1954, 4, 15);
            human2.SetDateOfBirth(1950, 1, 21);
            human3.SetDateOfBirth(1981, 9, 27);
            human4.SetDateOfBirth(1983, 3, 28);
            human5.SetDateOfBirth(2008, 2, 24);
            human6.SetDateOfBirth(2010, 12, 1);;
            human1.addChild(children1, human3);
            human2.addChild(children1, human3);
            human3.addChild(children2, human5);
            human3.addChild(children2, human6);
            human4.addChild(children2, human5);
            human4.addChild(children2, human6);
            familyTree.add(treeList, human1);
            familyTree.add(treeList, human2);
            familyTree.add(treeList, human3);
            familyTree.add(treeList, human4);
            familyTree.add(treeList, human5);
            familyTree.add(treeList, human6);
            human1.setChildren(children1);
            human2.setChildren(children1);
            human3.setChildren(children2);
            human4.setChildren(children2);
            familyTree.SetFamilyTree(treeList);
            familyTree.getFamilyTree();
            return familyTree;
        }
    
}