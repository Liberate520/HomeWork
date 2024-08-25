package family_free.family.buider.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    //My
    private static int idCounter = 0; // Статический счетчик id, общий для всех объектов класса
    private int id;
    String name;
    Gender gender;
    private LocalDate birthday;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(){

    }

//My
    public Human(String name, Gender gender, LocalDate birthday, LocalDate deathDate, Human mother, Human father) {
        this.name = name;
        this.id = idCounter;
        idCounter++;
        this.birthday = birthday;
        this.deathDate = deathDate;
        this.gender=gender;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }
 //В соответствии с принципом Don’t repeat yourself. Перегрузка
    public Human (String name,Gender gender, LocalDate birthday){
        //вызов конструктора текущего класса
        this(name,gender,birthday,null,null,null);
    }

    public Human (String name,Gender gender, LocalDate birthday,Human mother, Human father){
        this(name,gender,birthday,null,mother,father);
    }

    public void addParent(Human parent){
        if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        else if (parent.getGender().equals(Gender.Male)){
            setMother(parent);
        }

    }

    //SomeMy
    public boolean addChild(Human name){
        if(!children.contains(children)){
            children.add(name);
            for (Human child:children)
                child.addParent(this);
            return true;
        }
        return false;
    }

    // My
    public String AboutChidren(){
        StringBuilder res = new StringBuilder();
        res.append("У этого человека ");
        if (children.size() == 0) {
            res.append("нет детей.");
            res.append("\n");
            return res.toString();
        }
        else{
            res.append(children.size());
            res.append(" детей:\n");
            for (Human human:children){
                res.append(human);
                res.append(";\n");
            }
            res.append("\n");
            return res.toString();
        }
    }

    // сетеры и гетеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name;}
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}
    public void setMother(Human mother) {this.mother = mother;}
    public Human getMother() {return mother;}
    public void setFather(Human father) {this.father = father;}
    public Human getFather() {return father;}
    public void setChildren(List<Human> children) {this.children = children;}
    public List<Human> getChildren() {return children;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge(){
        if(deathDate==null){
            return getPeriod(birthday,LocalDate.now());
        }
        else {
            return getPeriod(birthday,deathDate);
        }
    }

    private int getPeriod(LocalDate Birthday, LocalDate deathDate){
        Period diff = Period.between(Birthday,deathDate);
        return diff.getYears();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
//        stringBuilder.append(", ");
//        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    //My
    public String getParantsToString(){
        String res =new String();
        if (father!=null){
            res += "отец: ";
            res+="id - "+father.getId()+", ";
            res+="name - " +father.getName()+".";
        }
        else if(mother!=null){
            res += "мать: ";
            res+="id - "+mother.getId()+", ";
            res+= "name - " +mother.getName()+".";
        }
        return res;
    }

    public List<Human> getParants(){
        List<Human> parants = new ArrayList<>(2);
        if (father!=null){
            parants.add(father);
        }
        else if(mother!=null){
            parants.add(mother);
        }
        return parants;
    }

    public String getMotherInfo(){
        String res = ", мать: ";
        Human mother = getMother();
        if(mother != null){
            res+=mother.getName();
        }else {
            res +="неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String str = "отец: ";
        Human father = getFather();
        if (father!=null){
            str+=father.getName();
        }
        else {
            str+="Неизвестен";
        }
        return str;
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() ==getId();
    }
}





















