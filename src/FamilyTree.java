import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> family;

public FamilyTree (){
    this(new ArrayList<>());
}

public FamilyTree(List<Human> family){ this.family = family; }

public boolean addHuman (Human human){
    if (human == null) {
        return false;
    }
    if (!family.contains(human)) {
        family.add(human);

        addToParents(human);
        addToChildren(human);

        return true;
    }
    return false;
}

private void addToParents(Human human){
    for (Human parrent : human.getParents()) {
       parrent.addChild(human);
    }
}

private void addToChildren(Human human){
    for (Human child : human.getChildren()) {
        child.addParent(human);
    }
}

public List<Human> getByName (String name){
    List<Human> res = new ArrayList<>();
    for (Human human : family) {
        if (human.getName().equals(name)) {
            res.add(human);
        }
    }
    return res;
}

@Override
public String toString() {
    return getInfo();
}

public String getInfo(){
    StringBuilder sb = new StringBuilder();
    for (Human human : family) {
        sb.append(human);
        sb.append("\n");
    }
    return sb.toString();
}
}
