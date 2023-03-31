import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Person implements Serializable{
    
    private String firstname;
    private String secondname;
    private String dateofbirth;
    private String alive;
    private String dateofdeath;
    private List<Person> childrens = new ArrayList<>();
    private Person father;
    private Person mother;
    
    public Person(String firstname, String secondname, String dateofbirth){
        this.firstname = firstname;
        this.secondname = secondname;
        this.dateofbirth = dateofbirth;
    }


  
    

    public void getFirstName() {
        System.out.println(firstname);
    }

    public void getSecondName() {
        System.out.println(secondname);
    }

    public void getDateOfBirth() {
        System.out.println(dateofbirth);
    }

    public void getAlive() {
        System.out.println(alive);
    }

    public void getDateOfDeath() {
        System.out.println(dateofdeath);
    }

    public void getMother() {
        System.out.println(mother);
    }

    public void getFather() {
        System.out.println(father);
    }

    public void getChildren() {
        System.out.println(childrens);
    }




    public String setFirstName(String firstname){
        return this.firstname = firstname;
    }
    public String setSecondName(String secondname){
        return this.secondname = secondname;
    }
    public String setDateOfBirth(String dateofbirth){
        return this.dateofbirth = dateofbirth;
    }

    public String setAlive(Boolean alive){
        if (alive == true){
            return this.alive = "Жив";
        }
        return this.alive = "Мертв";
    }

    public String setDateOfDeath(String dateofdeath){
        return this.dateofdeath = dateofdeath;
    }

    public Person setMother(Person person) {
        return this.mother = person;
    }

    public Person setFather(Person person) {
        return this.father = person;
    }

    public void addChild(Person person){
        childrens.add(person);
    }


    @Override
    public String toString() {
        return firstname + " " + secondname
        // return "Имя, Фамилия: " + firstname + " " + secondname;
        +  " Дата рождения: " + dateofbirth + " Жив? " + alive;
        // +  ", Мать: " + mother + ", Отец: " + father
        // + " Дети:" + childrens;
    }


}
