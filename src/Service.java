import java.io.Serializable;

public class Service implements Serializable {
    private FamilyTree familyTree;

    public Service() {
        FamilyTree familyTree = new FamilyTree();
    }

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void addFamilyMember(Human member) {
        familyTree.add(member);
    }

    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family members: \n");
        for (Human member: familyTree) {
            stringBuilder.append(member.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }
}
