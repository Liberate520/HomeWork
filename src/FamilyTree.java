import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<HumanInfo> people;
    
    public FamilyTree() {
        people = new ArrayList<>();
    }
    
    public void addPerson(HumanInfo person) {
        people.add(person);
    }

    public HumanInfo findPersonByName(String name) {
        for (HumanInfo person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null; // Для ситуаций когда человек не найден
    }

    public List<HumanInfo> getChildrenOfPerson(String name) {
        HumanInfo person = findPersonByName(name);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>(); //ДЛя ситуаций когда человек не найден или у него нет детей
    }

}
