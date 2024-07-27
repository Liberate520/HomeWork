// Класс Person - описывает человека с основными атрибутами и методами.

public class Person {
    private String name;
    private String birthDate;
    private Person mother;
    private Person father;

    public Person(String name, String birthDate, Person mother, Person father) {
        this.name = name;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }
}
