package src;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;
    private LocalDate dateB;
    private LocalDate dateD;
    private List<Person> children;
    private Person mother;
    private Person father;

    public Person(String name, String surname, String patronymic, Gender gender, LocalDate dateB, LocalDate dateD,
            Person mother, Person father) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateB = dateB;
        this.dateD = dateD;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();

    }

    public Person(String name, Gender gender, LocalDate dateB) {
        this(name, null, null, gender, dateB, null, null, null);
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }
    
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    
    public String getPatronymic() {
        return patronymic;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
    
    public void setDateB(LocalDate dateB) {
        this.dateB = dateB;
    }

    public LocalDate getDateB() {
        return dateB;
    }
    
    public void setDateD(LocalDate dateD) {
        this.dateD = dateD;
    }
    
    public LocalDate getDateD() {
        return dateD;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getMother() {
        return mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }
    
    public Person getFather() {
        return father;
    }

    public List<Person> getChildren(){
        return children;
    }
    
    public Integer getAge(LocalDate dateB, LocalDate dateD){
        Integer years;
        if (dateD==null){
            years = Period.between(dateB, LocalDate.now()).getYears();
            return years;
        }else{
            years = Period.between(dateB, dateD).getYears();
            return years;
        }
    }
    
    // public String toString(){
    //     String ps=getPersCard().toString();
    //     return ps;

    // }

    public String getNumOfChild (List<Person> children){
        if (children != null) {
            int count=0;
            for (Person person : children) {
                count++;
            }
            String num = Integer.toString(count);
            return "Кол-во детей:" + num;
        }else{
            return "Детей нет";
        }
        
    }
    
    // public String getStatusLiveOrDead(LocalDate dateD){
    //     if (dateD== null) {
    //         return "Жива";
            
    //     }
    //     return "Умерла:" + dateD;
    // }

    public String getStatusLiveOrDead(LocalDate dateD,Gender gender){
        if (dateD== null) {
            if (gender== Gender.female) {
                return "Жива";                
            }else{
                return "Жив";
            }
            
        }else{
            if (gender == Gender.female) {
                return "Умерла:" + dateD;                
            }else{
                return "Умер:" + dateD;
            }
        }
    }

    public StringBuilder getOffspring(List<Person> children){
        StringBuilder child= new StringBuilder();
        if (children.isEmpty()) {
            child.append("");
            return child;                       
        }else{
        child.append("Дети: ");       
        for (int i=0; i< children.size(); i++){
            child.append(children.get(i).getName());}
            return child;
        }
    }
    
    public void getParent (Person parent){
        if (parent.getGender().equals(Gender.male)){
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.female)) {
            setMother(parent);
            
        }
    }
    
    public void setChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            
        }

    }

    public StringBuilder getPersCard(){
        StringBuilder pc = new StringBuilder();
        pc.append("_____Личная карточка____\n");
        pc.append("Имя: ");
        pc.append(name);
        pc.append(". Фамилия: ");
        pc.append(surname);
        pc.append(". Отчество: ");
        pc.append(patronymic);
        pc.append("\n");
        pc.append("Возраст: ");
        pc.append(getAge(dateB, dateD));
        pc.append(" ");
        pc.append(getNumOfChild(children));
        pc.append(" ");
        pc.append(getStatusLiveOrDead(dateD,gender));
        pc.append("\n");
        pc.append(getOffspring(children));
        pc.append("\n");
        return pc;
    }

}
