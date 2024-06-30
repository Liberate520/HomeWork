import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class FamilyTree {
    private static int lastID = 0;
    private final int ID = lastID;
    private final TreeMap<Integer, Human> familyTree= new TreeMap<>();

    public FamilyTree(){
        lastID++;
    }

    public void addHuman(Human human) {
        if (!this.familyTree.containsValue(human) && human != null) {
            this.familyTree.put(human.getID(), human);

            addHuman(human.getSpouse());

            addHuman(human.getMather());

            addHuman(human.getFather());

            for (Human kid : human.getChildren()) addHuman(kid);
        }
    }

    public void removeHuman(int ID){
        this.familyTree.remove(ID);
    }

    public Human getHuman(int ID){
        if (this.familyTree.containsKey(ID)){
            return this.familyTree.get(ID);
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        for (Human human: this.familyTree.values()){
            info.append(human);
        }

        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() == obj.getClass()) return false;

        return this.ID == ((FamilyTree) obj).getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ID);
    }
}
