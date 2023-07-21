import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    public String name;
    public LocalDate birthDate;
    public  LocalDate deathDate;
    public  Sex sex;
    public  Person mother;
    public  Person father;
    public List<Person> children;
    public Person spouse;

    public Person(String name, LocalDate birthDate, Sex sex, LocalDate deathDate,
                  Person mother, Person father, List<Person> children, Person spouse) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.spouse = spouse;
    }
    public Person(String name, LocalDate birthDate, Sex sex){
        this(name, birthDate, sex, null, null, null, null, null);
    }

    public void setChild (Person adult, Person child){
        if (adult.children == null) {
            adult.children = new ArrayList<>();
            }
        if(!adult.children.contains(child)) {
            adult.children.add(child);
            if (adult.sex.equals(Sex.male)){
                setFather(adult, child);
            }else {
                setMother(adult, child);
            }
            if(adult.spouse != null){
                setChild(adult.spouse, child);
            }
        }

    }
    private void setFather(Person father, Person child) {
        child.father = father;
    }
    private void setMother(Person mother, Person child) {
        child.mother = mother;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: "+name+"; Birthday: "+birthDate+"\n");
        return sb.toString();
    }



}
