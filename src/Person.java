import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

    private String name;
    private Person parent;
    private List<Person> children;
    private Date dateOfBirth;

    public Person(String name, Person parent) {
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Person getParent() {
        return parent;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}