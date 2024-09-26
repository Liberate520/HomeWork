package family_tree.model.service;

import family_tree.model.family.FamilyTree;
import family_tree.model.family.TreeNode;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import family_tree.model.writer.Writer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service {
    private FamilyTree<Human> familyTree;
    private Writer writer;

    public Service(FamilyTree<Human> tree, Writer writer) {
        this.familyTree = tree;
        this.writer = writer;
    }

    public Service(Writer writer) {
        this(new FamilyTree<>(), writer);
    }

    public void sortByName(FamilyTree<Human> tree) {
        tree.sortByName();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge(FamilyTree<Human> tree) {
        tree.sortByAge();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void addFamilyMember(String gender, String name, String familyName, String strDate) {
        Gender newGender = Gender.valueOf(gender);
        LocalDate birthDate = getLocalDate(strDate);
        Human human = new Human(newGender, name, familyName, birthDate);
        familyTree.addFamilyMember(human);
    }

    public LocalDate getLocalDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(strDate, formatter);
    }

    public String getFamilyTreeMembers() {
        return familyTree.getFamilyTreeMembers();
    }

    public boolean saveTreeToFile() {
        return writer.write(familyTree);
    }

    public FamilyTree<Human> getTreeFromFile() {
        familyTree = (FamilyTree<Human>) writer.read();
        return familyTree;
    }

    public void setWedding(long humanId1, long humanId2) {
        familyTree.setWeddingById(humanId1, humanId2);
    }

    public void setParent(long childId, long parentId) {
        familyTree.setParent(childId, parentId);
    }

    public String getChildrenList(long parentId) {
        if (familyTree.getChildrenListById(parentId) != null) {
            return familyTree.getChildrenListById(parentId);
        }
        return null;
    }
}
