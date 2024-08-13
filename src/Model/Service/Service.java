package src.Model.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import src.Model.FamilyTree.FamilyTree;
import src.Model.FileHandling.FileHandler;
import src.Model.FileHandling.Writer;
import src.Model.Human.Gender;
import src.Model.Human.Human;
import src.Model.Human.HumanBuilder;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;
    private Writer writer;

    public Service() throws SecurityException, IOException {
        humanBuilder = new HumanBuilder();
        familyTree = new FamilyTree<>();
        writer = new FileHandler();
    }

    public FamilyTree<Human> createTree() {
        return familyTree;
    }

    public Human addToTree(String name, LocalDate dateofbirth, LocalDate dateofdeath, Gender gender, Human mother,
            Human father, List<Human> children) {
        Human member = humanBuilder.build(name, dateofbirth, dateofdeath, gender, mother, father, children);
        familyTree.addMember(member);
        return member;
    }

    public Human addToTreeShort(String name, LocalDate dateofbirth, Gender gender) {
        Human member = humanBuilder.build(name, dateofbirth, gender);
        familyTree.addMember(member);
        return member;
    }

    public Human getMember(String name) {
        Human member = familyTree.getMember(name);
        return member;
    }

    public void addParentOrChild(Human child, Human parent) {
        child.addParentOrChild(child, parent);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthday() {
        familyTree.sortByBirthday();
    }

    public void sortByChildren() {
        familyTree.sortByChildren();
    }

    public String printTreeInfo() {
        String info = familyTree.GetFamilyInfo();
        return info;
    }

    public void load() throws ClassNotFoundException, IOException {
        writer.read();
    }

    public void save() throws FileNotFoundException, IOException {
        writer.write(familyTree);
    }
}
