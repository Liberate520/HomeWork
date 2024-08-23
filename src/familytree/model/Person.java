package familytree.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends TreeMember {
    private List<Person> children;

    public Person(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        this.children = new ArrayList<>();
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public void addChild(TreeMember child) {
        if (child instanceof Person) {
            children.add((Person) child);
        }
    }
}