package Family_tree;
import java.time.LocalDate;
import java.util.List;

public class Human {
    protected String name;
    private LocalDate birthDate, deathDate;
    private List<Human> children;
    private Human father, mother;
    private Gender gender;
    
    public Human(String name, LocalDate birthDate, LocalDate deathDate, /*List<Human> children,*/ Human father, Human mother, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        //this.children = children;
        this.father = father;
        this.mother = mother;
        this.gender = gender;
    }

    public void getChildren() {
        if (children == null) {
            System.out.println("No children");
        } else {
            for (Human child : children) {
                System.out.println(child);
            }
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Name: " + name + ", birthDate: " + birthDate + ", deathDate: " + deathDate + ", gender: " + gender;
    }
}
    
