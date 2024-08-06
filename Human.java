package homeWork;
import java.time.LocalDate;

public class Human {
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthday;
    private String parent;
    private String children;

    public Human(String name, String surname, Gender gender, LocalDate birthday, String parent, String children) {
        this.birthday = birthday;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.parent = parent;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getParent() {
        return parent;
    }

    public String getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "name: " + name + ", surname: " + surname + ", gender: " + gender + ", birthday: " + birthday
                + ", parent: " + parent + "; children: " + children;
    }
}
