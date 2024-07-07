import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanInfo {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private HumanInfo father, mother;
    private List<HumanInfo> children;

    public HumanInfo(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public HumanInfo(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }

    public HumanInfo getFather() {
        return father;
    }

    public HumanInfo getMother() {
        return mother;
    }

    public List<HumanInfo> getChildren() {
        return new ArrayList<>(children);
    }

    public void setFather(HumanInfo father) {
        this.father = father;
    }

    public void setMother(HumanInfo mother) {
        this.mother = mother;
    }

    public void addChild(HumanInfo child) {
        children.add(child);
    }
}
