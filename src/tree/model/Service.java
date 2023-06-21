package tree.model;

import tree.model.familyTree.FamilyTree;
import tree.model.familyTree.Tree;
import tree.model.handler.FileHandler;
import tree.model.handler.SaveReadable;
import tree.model.human.Gender;
import tree.model.human.Human;
import tree.model.humanService.AddHumanService;
import tree.model.humanService.FindHumanService;
import tree.model.humanService.DirectDescendant;
import tree.model.humanService.RemoveHumanService;
import java.io.IOException;


public class Service {

    private Tree<Human> tree;
    private SaveReadable fileHandler;
    private AddHumanService<Human> addHumanService;
    private FindHumanService<Human> findHumanService;
    private RemoveHumanService<Human> removeHumanService;
    private DirectDescendant<Human> directDescendant;

    public Service() {}

    public Service(Tree<Human> tree,
                   SaveReadable fileHandler,
                   AddHumanService<Human> addHumanService,
                   FindHumanService<Human> findHumanService,
                   RemoveHumanService<Human> removeHumanService,
                   DirectDescendant<Human> directDescendant) {
        this.tree = tree;
        this.fileHandler = fileHandler;
        this.addHumanService = addHumanService;
        this.removeHumanService = removeHumanService;
        this.findHumanService = findHumanService;
        this.directDescendant = directDescendant;
    }
    public Tree<Human> getTree() { return tree; }
    public void setTree(Tree<Human> tree) { this.tree = tree; }
    public void setSaveReadable() { fileHandler = new FileHandler(); }
    public void setAddHumanService() { addHumanService = new AddHumanService<>(); }
    public void setFindHumanService() { findHumanService = new FindHumanService<>(); }
    public void setRemoveHumanService() { removeHumanService = new RemoveHumanService<>(); }
    public void setDirectDescendant() { directDescendant = new DirectDescendant<>(); }

    public void addHuman(String name, Gender gender, String father, String mother) {
        Human human = new Human(name, gender);
        Human dad = findHumanService.findHuman(father, tree);
        Human mom = findHumanService.findHuman(mother, tree);
        addHumanService.addHuman(human, dad, mom, tree);
    }

    public boolean addParent(String child, String parent) {
        Human someChild = findHumanService.findHuman(child, tree);
        Human someParent = findHumanService.findHuman(parent, tree);
        if (someChild != null && someParent !=null)
            return addHumanService.addParent(someChild, someParent);
        else
            return false;
    }

    public String findHuman(String name) {
        Human human = findHumanService.findHuman(name, tree);
        if (human != null) return human.toString();
        else return "No human";
    }
    public boolean removeHumanFromTree(String name) {
        return removeHumanService.removeHumanFromTree(findHumanService.findHuman(name, tree), tree);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByChild() {
        tree.sortByChild();
    }

    public void printTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : tree) {
            stringBuilder.append(String.format("%s %s, (детей: %d)\n",
                    human.getName(),
                    human.getParent(),
                    human.getChildrenList().size()));
        }
        System.out.println(stringBuilder.toString());
    }

    public void saveObject() throws IOException {
        fileHandler.saveObject(tree);
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        tree = (FamilyTree) fileHandler.loadObject();
    }

    public boolean isDirectDescendant(String human1,String human2) {
        Human person1 = findHumanService.findHuman(human1, tree);
        Human person2 = findHumanService.findHuman(human2, tree);
        return directDescendant.isDirectDescendant(person1, person2, tree);
    }
}
