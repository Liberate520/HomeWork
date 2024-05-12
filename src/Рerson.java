import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Рerson {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Рerson mother;
    private Рerson father;
    private Set<Рerson> children;

    public Рerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Рerson mother,
                 Рerson father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new HashSet<>();
    }
//сбор информации
    public Рerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, gender, birthDate, deathDate, null, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Рerson getMother() {
        return mother;
    }

    public Рerson getFather() {
        return father;
    }

    public Set<Рerson> getChildren() {
        return children;
    }
    public void setMother(Рerson mother) {
        this.mother = mother;
    }

    public void setFather(Рerson father) {
        this.father = father;
    }

    public void setChildren(Set<Рerson> children) {
        this.children = children;
    }

    public String getAge(){
        return "Прожито: " + Period.between(birthDate, deathDate).getYears() + " years";
    }

    public void addChild(Рerson person){
        children.add(person);
    }
//связь матери
    public String getMotherInfo(){
        String str = "мать: ";
        if (mother != null){
            str += mother.getFirstName() + " " + mother.getLastName();
        }else {
            str += "не определено";
        }
        return str;
    }
//связь отца
    public String getFatherInfo(){
        String str = "отец: ";
        if (father != null){
            str += father.getFirstName() + " " + father.getLastName();
        }else {
            str += "не определено";
        }
        return str;
    }
//связь дети
    public String getChildrenInfo(){
        String str = "дети: ";
        if (children.size() != 0){
            for (Рerson child: children) {
                str += child.getFirstName() + " " + child.getLastName() + ", ";
            }
        }else {
            str += "не определено";
        }
        return str.replaceAll(", $", "");
    }
//Вывод списком всех персон с полученной информацией
    public String toString() {
        return "Имя: " + firstName + " " + lastName + ", пол: " + gender + ", дата рождения: " + birthDate +
                ", дата смерти: " + deathDate + ", " + getAge() + ", " + getMotherInfo() + ", " + getFatherInfo() +
                ", " + getChildrenInfo();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Рerson person = (Рerson) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && gender == person.gender && Objects.equals(birthDate, person.birthDate) && Objects.equals(deathDate, person.deathDate) && Objects.equals(mother, person.mother) && Objects.equals(father, person.father) && Objects.equals(children, person.children);
    }
}