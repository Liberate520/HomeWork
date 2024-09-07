import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Human human:familyTree) {
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String findByName(String name) {
        String humanToFind = "Поиск не дал результата";
        for(Human human:familyTree) {
            if(human.getFirstName().equalsIgnoreCase(name)) {
                humanToFind = human.toString();
            }
            if(human.getSecondName().equalsIgnoreCase(name)) {
                humanToFind = human.toString();
            }
        }
        return humanToFind;
    }

    public String findByBirthDate(LocalDate birthDate) {
        String humanToFind = "Поиск не дал результата";
        for(Human human:familyTree) {
            if(human.getBirthDate().equals(birthDate)) {
                humanToFind = human.toString();
            }
        }
        return humanToFind;
    }
}
