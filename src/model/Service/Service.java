package model.Service;

import java.time.LocalDate;

import Writers.Writer;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.ItemFamilyTree;
import model.Humans.Gender;
import model.Humans.Human;
import model.builder.HumanBuilder;

public class Service<U extends ItemFamilyTree<U>> {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    private Writer writer;
    private int humID;

    public Service(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender) {
        Human human = humanBuilder.build(name, dateOfBorn, dateOfDeath, gender);
        humID++;
        familyTree.addHuman(human);
    }

    public void setParents(int childID, int fatherID, int motherID) {
        Human child = familyTree.getByID(childID);
        Human father = familyTree.getByID(fatherID);
        Human mother = familyTree.getByID(motherID);

        child.addParent(father);
        child.addParent(mother);
    }



    public void sortByGender() {
        familyTree.sortByGender();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public String getHumansInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево:\n");
        for (Human human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean saveTree() {
        if (writer == null) {
            return false;
        }
        return writer.save(familyTree);
    }

    public boolean loadTree() {
        if (writer == null) {
            return false;
        }
        familyTree = writer.read();
        return true;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
