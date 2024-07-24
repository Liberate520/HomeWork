import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements FamilyTreeInterface {
    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    @Override
    public void addMember(Person person) {
        members.add(person);
    }

    @Override
    public Person findMember(int id) {
        for (Person member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void addChild(Person parent, Person child) {
        parent.addChild(child);
        if (parent.getGender() == Gender.MALE) {
            child.setFather(parent);
        } else if (parent.getGender() == Gender.FEMALE) {
            child.setMother(parent);
        }
    }
}