package familyTree.humans;

import familyTree.humans.Gender;

import java.time.LocalDate;
import java.util.List;

public class Person {
    public String name;
    public LocalDate birth, death;
    public Gender gender;
    public List<Person> children;
    public Person mother, father;

    /**
     * Инициализация новой личности
     * @param name Имя
     * @param birth Дата рождения
     * @param gender Гендер (Их ДВА)
     * @param mother Мать
     * @param father Отец
     */
    public Person(String name, LocalDate birth, Gender gender, Person mother, Person father) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }
    /**
     * Инициализация новой личности
     * @param name Имя
     * @param birth Дата рождения
     * @param death Дата смерти (иначе- null)
     * @param gender Гендер (Их ДВА)
     * @param mother Мать
     * @param father Отец
     */
    public Person(String name, LocalDate birth, LocalDate death, Gender gender, Person mother, Person father) {
        this(name,birth, gender, mother, father);
        this.death = death;
    }

    /**
     * Инициализация новой личности
     * @param name Имя
     * @param birth Дата рождения
     * @param death Дата смерти (иначе- null)
     * @param gender Гендер (Их ДВА)
     * @param children Список детей
     * @param mother Мать
     * @param father Отец
     */
    public Person(String name, LocalDate birth, LocalDate death, Gender gender, List<Person> children, Person mother, Person father) {
        this(name, birth, death, gender, mother, father);
        this.children = children;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public String getFatherName(){
        return (this.father == null) ? "Otets unknown" : this.father.name;
    }
    public String getMotherName(){
        return (this.mother == null) ? "Mati unknown" : this.mother.name;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    /**
     * Вычисляет возраст с учетом дня рождения
     * @return количество лет в день вызова функции
     */
    public int getAge(){
        int age;
        if(this.death != null){
            age = LocalDate.now().compareTo(this.birth) - (this.birth.getDayOfYear() >= this.death.getDayOfYear() ? 1 : 0);
        } else {
            age = LocalDate.now().compareTo(this.birth) - (this.birth.getDayOfYear() >= LocalDate.now().getDayOfYear() ? 1 : 0);
        }
        return age;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n////////////////////");
        stringBuilder.append("\nName: " + this.getName());
        stringBuilder.append("\nBirth date: " + this.birth.toString());
        stringBuilder.append("\nAge: " + this.getAge() + ((this.death != null) ? " (" + this.death.toString() + ")" : ""));
        stringBuilder.append("\nParents: " + this.getFatherName() + " and " + this.getMotherName());
        if(this.children != null) {
            stringBuilder.append("\nChildren: ");
            for (Person person : children) {
                stringBuilder.append("\n\t" + person.getName());
            }
        }
        stringBuilder.append("\n////////////////////");
        return stringBuilder.toString();
    }
}
