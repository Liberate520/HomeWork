import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private String secondName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human husband;

    public Human(String name, String secondName, Gender gender, LocalDate birthDate, LocalDate
            deathDate, Human mother, Human father) {
        id = 0;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, String secondName, Gender gender) {
        this(name, secondName, gender, null, null, null, null);
    }

    public Human(String name, String secondName, Gender gender, LocalDate birthDate) {
        this(name, secondName, gender, birthDate, null, null, null);
    }

    public Human(String name, String secondName, Gender gender, LocalDate birthDate,
                 Human mother, Human father) {
        this(name, secondName, gender, birthDate, null, mother, father);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public Gender getGender(){
        return gender;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }
    public String getSecondName(){
        return secondName;
    }


    public void setMother(Human mother){
        this.mother = mother;
    }

    public Human getMother(){
        return mother;
    }

    public void setFather(Human father){
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if(deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setHusband(Human husband){
        this.husband = husband;
    }

    public Human getHusband(){
        return husband;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setDeathDateDate(LocalDate deathDate){
        this.deathDate = deathDate;
    }

    public LocalDate getDeathDateDate(){
        return deathDate;
    }

    public List<Human> getChildren(){
        return children;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Номер: ");
        stringBuilder.append(id);
        stringBuilder.append(", Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", Фамилия: ");
        stringBuilder.append(secondName);
        stringBuilder.append(", Пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", Возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(" ");
        stringBuilder.append(getHusbandInfo());
        stringBuilder.append(" ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(" ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(" ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    public String getHusbandInfo(){
        String res = "Супруг(а): ";
        if(husband == null){
            res += "нет";
        }
        else {
            res += husband.getName();
            res += " ";
            res += husband.getSecondName();
        }
        return res;
    }
    public String getMotherInfo(){
        String res = "Мать: ";
        Human mother = getMother();
        if(mother != null){
            res += mother.getName();
            res += " ";
            res += mother.getSecondName();
        }
        else{
            res += "Нет информации";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "Отец: ";
        Human father = getFather();
        if(father != null){
            res += father.getName();
            res += " ";
            res += father.getSecondName();
        }
        else{
            res += "Нет информации";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if(!children.isEmpty()){
            res.append(children.get(0).getName());
            for(int i = 1; i < children.size(); i++){
                res.append(" ");
                res.append(children.get(i).getName());
            }
        }
        else{
            res.append("Отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Human human){
            return human.getId() == getId();
        }
        return false;
    }
}
