import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TypeOfRelationship implements Serializable {
    private Set<Рerson> family;

    public TypeOfRelationship(HashSet<Рerson> family) {
        this.family = family;
    }

    public TypeOfRelationship() {
        this(new HashSet<>());
    }
    public void addHuman(Рerson person){
        family.add(person);
        if (person.getFather() != null){
            person.getFather().addChild(person);
        }
        if (person.getMother() != null){
            person.getMother().addChild(person);
        }
    }

    public Рerson getByName(String firstName, String lastName){
        for (Рerson person: family) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                return person;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Рerson person: family){
            sb.append(person.toString()).append("\n");
        }
        return "В родословной: " + family.size() + " количество человек: " + "\n" + sb.toString();
    }
}