import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    public Human(String name,  String gender, Human father, Human mother,
            Human grandmother, Human grandfather) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.grandmother = grandmother;
        this.grandfather = grandfather;
    }
    String name;
    LocalDate dateOfBirth;
    LocalDate dateOfDeath;
    String gender;
    Human father, mother, grandmother, grandfather;
    List<Human> children;

    public void SetDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public void SetDateOfDeath(int year, int month, int day) {
        this.dateOfDeath = LocalDate.of(year, month, day);
    }

    public void getChildren() {
        for (Human child: children) {
            System.out.println(child + "\n");
        }
    }
    public String getName () {
        return name;
    }
    public void setChildren(List<Human> children) {
        children = new ArrayList<>();
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        if (dateOfDeath == null) {
            return now.getYear() - dateOfBirth.getYear();
        } else {
            return dateOfDeath.getYear() - dateOfBirth.getYear();
        }
    }
    
    public void addChild(Human h) {
        NullPointerException n = new NullPointerException();
        if (h == null) {
            children.add(null);
        } if (h!=null){
            children.add(h);
        }
    }

    public void getInfo () {
        NullPointerException n = new NullPointerException();
        System.out.println("Name: " + name);
        if (dateOfBirth != null) {
            System.out.println("date of birth: " + dateOfBirth.toString());
        }
        if (dateOfDeath != null) {
            System.out.println("date of death: " + dateOfDeath.toString());
        }
        System.out.println("age: " + getAge());
        System.out.println("gender: " + gender);
        if (father!=null) {
            System.out.println("father: " + father.getName());
        }
        if (mother!=null) {
            System.out.println("father: " + mother.getName());
        }
        if (grandfather!=null) {
            System.out.println("father: " + grandfather.getName());
        }
        if (grandmother!=null) {
            System.out.println("father: " + grandmother.getName());
        }
        if (children != null) {
            System.out.println("Children:");
            getChildren();
        } if (children == null) {
            System.out.println("children: no");
        }

    }
}