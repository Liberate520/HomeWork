


public class Human {
    Integer age;
    String name;
    gender sex;
    String lastName;

    public Human(String name, Integer age, gender sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + " " + lastName; 
    }

    
    
}
