package ru.gb.model.person;

import ru.gb.model.node.TreeItem;
import ru.gb.model.treeItem.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements TreeItem<Person> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father,
                  Person mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public Person(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name,gender, birthDate, deathDate, null, null);
    }
    public Person(String name, Gender gender, LocalDate birthDate) {
        this(name,gender, birthDate, null, null, null);
    }

    public Person(String name, Gender gender, LocalDate birthDate, Person father,
                  Person mother) {
        this(name,gender, birthDate, null, father, mother);
    }

    @Override
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateToCalculate = deathDate != null ? deathDate : currentDate;

        int age = dateToCalculate.getYear() - birthDate.getYear();
        if (dateToCalculate.getMonthValue() < birthDate.getMonthValue() ||
                (dateToCalculate.getMonthValue() == birthDate.getMonthValue() &&
                        dateToCalculate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    @Override
    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addParent(Person parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public Person getFather() {
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Person getMother() {
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    @Override
    public List<Person> getParents() {
        return parents;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    public void setDeathDate(LocalDate deathDate) {

        if (this.birthDate.isBefore(deathDate)) {this.deathDate = deathDate;}
        else System.out.println("Дата смерти не может быть раньше даты рождения");
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        if (deathDate != null) {
            sb.append(", Умер в возрасте: ");
        } else {
            sb.append(", Возраст: ");
        }
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        Person mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        Person father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");

        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public void setGender(String genderStr) {
        if (Gender.Male.toString().equalsIgnoreCase(genderStr)) {
            this.gender = Gender.Male;
        } else if (Gender.Female.toString().equalsIgnoreCase(genderStr)) {
            this.gender = Gender.Female;
        } else {
            System.out.println("Введен неверный гендер!");
        }
    }
}