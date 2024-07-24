import java.util.ArrayList;
import java.util.Calendar;

public class Human {
    private String firstname;
    private String lastname;
    private String surname;
    private Calendar birthday = Calendar.getInstance();
    private Gender gender;
    private boolean alive;
    private Human spouse;
    Human mother;
    Human father;
    ArrayList<Human> childrens;

    /**
     * Корструктор с 5 полями
     * @param firstname Имя
     * @param lastname Фамилия
     * @param surname Отчество
     * @param gender Пол
     * @param childrens Дети
     */
    public Human(String firstname, String lastname, String surname, Gender gender, ArrayList<Human> childrens) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.gender = gender;
        this.childrens = new ArrayList<>();
    }

    /**
     * Констурктор с 5 полями
     * @param firstname Имя
     * @param lastname Фамилия
     * @param surname Отчество
     * @param gender Пол
     * @param alive Статус жив/мертв
     */
    public Human(String firstname, String lastname, String surname, Gender gender, boolean alive) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.gender = gender;
        this.alive = alive;
    }

    /**
     * Конструктор с 6 полями
     * @param firstname
     * @param lastname
     * @param surname
     * @param gender
     * @param alive
     * @param birthday
     */
    public Human(String firstname, String lastname, String surname, Gender gender, boolean alive, Calendar birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.gender = gender;
        this.alive = alive;
        this.birthday = birthday;
    }

    /**
     * Переопределение метода
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s, %s %s %s, %s year of birth", gender, lastname, firstname, surname,
                birthday.get(Calendar.YEAR));
    }

    /**
     * Метод дата рождения
     * @param year Год
     * @param month Месяц
     * @param day День
     */
    public void addBirthday(int year, int month, int day) {
        birthday.set(year, month, day);
    }

    public int getAge() {
        Calendar date = Calendar.getInstance();
        int calYear = date.get(Calendar.YEAR);
        int calMonth = date.get(Calendar.MONTH);
        int calDay = date.get(Calendar.DAY_OF_MONTH);
        int birthYear = date.get(Calendar.YEAR);
        int birthDay = date.get(Calendar.DAY_OF_MONTH);
        int age = this.birthday.get(Calendar.DAY_OF_YEAR);
        if (calMonth < birthDay) {
            if (calDay < birthDay) {
                age -= 1;
            }
        }
        return age;
    }

    public ArrayList<Human> getParents() {
        ArrayList<Human> parents = new ArrayList<>();
        parents.add(this.father);
        parents.add(this.mother);
        return parents;
    }

    public Human getMother() {
        return this.mother;
    }

    public Human getFather() {
        return this.father;
    }

    public Human getSpouse() {
        return this.spouse;
    }

    public ArrayList<Human> getChildrens() {
        return this.childrens;
    }

    public static void setParent(Human parent, Human child) {
        Gender gender = parent.gender;
        if (Gender.Female == gender) {
            child.mother = parent;
        } else {
            child.father = parent;
        }
    }

    public static void setParent(Human mother, Human father, Human child) {
        child.mother = mother;
        child.father = father;
        setChild(mother. child);
        setChild(father, child);
    }

    public static void setChild(Human parent, Human child) {
        parent.childrens.add(child);
        setParent(parent, child);
    }

    public static void setSpouse(Human spouse_1, Human spouse_2) {
        spouse_1.spouse = spouse_2;
        spouse_2.spouse = spouse_1;
    }
}