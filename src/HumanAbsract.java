import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class HumanAbsract implements Serializable {
    protected String name;
    protected HumanAbsract father;
    protected HumanAbsract mother;
    protected List<HumanAbsract> children;
    protected String gender;
    protected LocalDate dateOfBirth;

    public HumanAbsract(String name, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public HumanAbsract getFather() {
        return father;
    }

    public void setFather(HumanAbsract father) {
        this.father = father;
    }

    public HumanAbsract getMother() {
        return mother;
    }

    public void setMother(HumanAbsract mother) {
        this.mother = mother;
    }

    public List<HumanAbsract> getChildren() {
        return children;
    }

    public void addChild(HumanAbsract child) {
        this.children.add(child);
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public abstract String getFullInfo();
}
