import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Human implements Serializable, TreeNode<Human> {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;

    // public enum Gender {
    //     Male, Female;
    // }

    public Human(String name, String surname, Gender gender, LocalDate birthDate, LocalDate deathDate,Human father, Human mother) {
        id = -1;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, String surname, Gender gender, LocalDate birthDate) {
        this(name, surname, gender, birthDate, null, null, null);
    }

    public Human(String name, String surname, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, surname, gender, birthDate, null, father, mother);

    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    
    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public boolean addChild(Human E) {
        return false;
    }

    @Override
    public boolean addParent(Human E) {
        return false;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null) {
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge() {
        if(deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod (LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate,deathDate);
        return diff.getYears();
   }

    public void setId(long id) {
        this.id = id;
    }
   
    public long getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Human> getChildren() {
        return children;
    }
    
    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }



    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        String childrenNames = children.stream()
                .map(Human::getName)
                .collect(Collectors.joining(", "));

        return "id: " + id +
                ", Имя: " + name +
                ", Фамилия: " + surname +
                ", Возраст: " + getAge() +
                ", Отец: " + (father != null ? father.getName() : "Неизвестен") +
                ", Мать: " + (mother != null ? mother.getName() : "Неизвестна") +
                ", Супруг(а): " + (spouse != null ? spouse.getName() : "Нет") +
                ", Дети: " + (childrenNames.isEmpty() ? "Нет" : childrenNames);
    }

//        public void addChild(Human child) {
//        children.add(child);
//    }

    public Human getSpouse() {
        return spouse;
    }
}

