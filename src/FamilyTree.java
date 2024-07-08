import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> family;

    public FamilyTree(){
        family = new ArrayList<>();
    }

    public void addPerson(Human human){
        family.add(human);
    }

    public Human getPerson(String name){
        for(Human person: family){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи: \n");
        for(Human person : family){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
