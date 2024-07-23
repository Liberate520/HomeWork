import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {    
    private String name;
    private LocalDate birthDate;
    private List<Human> children;

    public Human(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name) 
          .append(", Age: ").append(calculateAge())
          .append(", Birth Date: ").append(birthDate)
          .append(", Children: ");
        if (children.isEmpty()) {
            sb.append("None");
        } else {          
               for (Human child : children) {
                 //sb.append("\n ").append(child.toString());
                 sb.append(child.name).append(", ");
            }
        }
        return sb.toString();
    }

    public int calculateAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
