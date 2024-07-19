import java.util.ArrayList;
import java.util.List;

class GenealogyTree {
    private List<Person> persons;

    public GenealogyTree() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void printTree() {
        for (Person person : persons) {
            System.out.println(person);
            System.out.println("Отец: " + (person.getFather() != null ? person.getFather().getName() : ""));
            System.out.println("Мать: " + (person.getMother() != null ? person.getMother().getName() : ""));
            System.out.println("Дети: " + formatChildrenList(person.getChildren()));
            System.out.println();
        }
    }

    private String formatChildrenList(List<Person> children) {
        StringBuilder childrenList = new StringBuilder();
        for (Person child : children) {
            childrenList.append(child.getName()).append(", ");
        }
        if (childrenList.length() > 0) {
            childrenList.delete(childrenList.length() - 2, childrenList.length());
        }
        return childrenList.toString();
    }
}
