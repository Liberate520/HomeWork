package familly_tree;

import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }


    public void addHuman(Human human) {
        this.people.add(human);
    }


    public List<Human> getPeople() {
        return this.people;
    }


    public Human findHuman(String personName) {
        for (Human person : people) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        return null;
    }


    public void printTree() {
        // Создаем список, чтобы отслеживать уже выведенных людей
        List<Human> printedPeople = new ArrayList<>();


        for (Human person : people) {
            if (!printedPeople.contains(person)) {
                printPerson(person, 0, printedPeople);
            }
        }
    }


    private void printPerson(Human person, int level, List<Human> printedPeople) {

        if (!printedPeople.contains(person)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            sb.append(person.getName());
            System.out.println(sb.toString());


            printedPeople.add(person);


            for (Human child : person.getChildren()) {
                printPerson(child, level + 1, printedPeople);
            }
        }
    }

    // Метод для преобразования древа в текстовый формат
    public List<String> convertTreeToText() {
        List<String> lines = new ArrayList<>();
        for (Human person : people) {
            StringBuilder sb = new StringBuilder();
            sb.append(person.getName()).append(",").append(person.getGender()).append(",").append(person.getBirthDate()).append(",").append(person.getDeathDate());
            lines.add(sb.toString());
            for (Human parent : person.getParents()) {
                lines.add(parent.getName() + "," + person.getName());
            }
        }
        return lines;
    }
}