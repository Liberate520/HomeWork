import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private final List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human member) {
        members.add(member);
    }

    //Создаем супружескую связь.

    public void connectSpouses(Human person1, Human person2) {
        person1.setSpouse(person2);
        person2.setSpouse(person1);
    }

    public void connectParents(Human child, Human father, Human mother) {
        child.setFather(father);
        child.setMother(mother);
        father.addChild(child);
        mother.addChild(child);
    }


}
