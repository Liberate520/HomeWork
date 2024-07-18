import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public int size(){
        return  familyMembers.size();
    }

    public void addFamilyMember(Human human){
        familyMembers.add(human);
    }
}
