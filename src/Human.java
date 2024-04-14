import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//Определяем метод для создания экземпляра класса человека
public class Human implements Serializable {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;
    private boolean check;

    //Первый конструктор
    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.check = false;
    }

    //Второй. Расширенный конструктор, если имеется дата смерти и-или информация о детях и родителях
    public Human(String name, LocalDate dob, Gender gender, LocalDate dod,
                 Human mother, Human father, List<Human> children) {
        this(name, dod, gender);
        this.dod = dod;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.check = true;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }
    public boolean addParents(Human parent){
        if(parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        else if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getMother() {
        return mother;
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


    // Возвращает возраст к экземпляру класса
    public String getAge() {
        String age = new String();
        age += "Возраст " + name +": ";
        if (dod != null) {
            age += Period.between(dob, dod).getYears();
        } else {
            age += Period.between(dob, LocalDate.now()).getYears();
        }
        return age;
    }

//Метод тустринг выбирает, как осуществлять вывод на экран для полного конструктора или нет

    @Override
    public String toString() {
        if(check == true){
        return getInfoTrue();}
    else {
        return getInfoFalse();
        }
    }
    public String getMotherInfo(){
        String res = "Мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        }
        else{
            res += " неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "Отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        }
        else{
            res += " неизвестен \n";
        }
        return res;
    }

    public String getInfoTrue(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name = " + name + "\n");
        sb.append("DOB = " + dob + "\n");
        sb.append("Gender = " + gender + "\n");
        sb.append("Children = " + children + "\n");
        sb.append(getMotherInfo() + "\n");
        sb.append(getFatherInfo() + "\n");
        return sb.toString();
    }
    public String getInfoFalse(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name = " + name + "\n");
        sb.append("DOB = " + dob + "\n");
        sb.append("Gender = " + gender + "\n");
        return sb.toString();
    }
}