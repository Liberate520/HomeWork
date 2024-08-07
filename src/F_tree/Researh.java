package F_tree;

public class Research {
    private FamilyTree familyTree;

    public Research(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public List<Person> findChildren(Person person) {
        return person.getChildren();
    }
}