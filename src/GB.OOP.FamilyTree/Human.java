import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//   поля
public class Human {
    private String name;
    private LocalDate birthDate;
    private BirthPlace place;
    private List<Human> children;
    private Gender gender;
    private Human father;
    private Human mather;



    // конструкторы 1
    public Human(String name, LocalDate birthDate, Gender gender, BirthPlace place, Human father, Human mather) {
        this.name = name;
        this.birthDate = birthDate;
        this.place = place;
        this.gender = gender;
        this.father = father;
        this.mather = mather;
        children =new ArrayList<>();
    }
    // конструктор 2
    public Human(String name, LocalDate birthDate, Gender gender){
        this(name, birthDate, gender,null,null,null);
    }

    //методы
    public String getName() {
        return name;
    }
    public LocalDate getBirthDateDob() {
        return birthDate;
    }
    public BirthPlace getPlace() {
        return place;
    }
    public Gender getGender() {
        return gender;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setMather(Human mather) {
        this.mather = mather;
    }

    // метод добавмение отца и матери
    public boolean addFather(Human father){
        setFather(father);
        return true;
    }
    public boolean addMather(Human mather){
        setMather(mather);
        return true;
    }
    // метод добавдениея детей
    public boolean addChildren(Human child){
        if(!children.contains(child)){
            children.add(child);
        }
        return  true;
    }
    // переопределение метода toString()
    @Override
    public String toString() {
        return "Human" +
                "name : " + name +
                ", birthDate : " + birthDate +
                ", place : " + place +
                ", gender : " + gender;
    }
}