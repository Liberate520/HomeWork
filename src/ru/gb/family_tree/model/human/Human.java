package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.service.FamilyTreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyTreeItem<Human> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private Human spouse;
    private final List<Human> children;

    public Human() {
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDate,
                 Human father, Human mother) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDay) {
        this(name, gender, birthDay, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDay,
                 Human father, Human mother) {
        this(name, gender, birthDay, null, father, mother);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getGenderInfo() {
        String result = "пол: ";
        if (getGender().equals(Gender.MALE)) {
            result += "Мужской";
        } else {
            result += "Женский";
        }
        return result;
    }

    @Override
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public String getDeathDateInfo() {
        String result = "дата смерти: ";
        if (getDeathDate() != null) {
            result += getDeathDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        } else {
            result += "неизвестена";
        }
        return result;
    }

    @Override
    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDay, LocalDate.now());
        } else {
            return getPeriod(birthDay, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDay, LocalDate deathDate) {
        Period diff = Period.between(birthDay, deathDate);
        return diff.getYears();
    }

    @Override
    public Human getFather() {
        return father;
    }

    public String getFatherInfo() {
        String result = "отец: ";
        if (getFather() == null) {
            result += "неизвестен";
        } else {
            result += getFather().getName();
        }
        return result;
    }

    @Override
    public Human getMother() {
        return mother;
    }

    public String getMotherInfo() {
        String result = "мать: ";
        if (getMother() == null) {
            result += "неизвестена";
        } else {
            result += getMother().getName();
        }
        return result;
    }

    @Override
    public Human getSpouse() {
        return spouse;
    }

    public String getSpouseInfo() {
        String result = "супруг(а): ";
        if (getSpouse() == null) {
            result += "нет";
        } else {
            result += getSpouse().getName();
        }
        return result;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String getChildrenInfo() {
        StringBuilder result = new StringBuilder();
        result.append("дети: ");
        if (!children.isEmpty()) {
            result.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                result.append(", ").append(children.get(i).getName());
            }
        } else {
            result.append("отсутствуют");
        }
        return result.toString();
    }

    @Override
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean delChild(Human child) {
        if (children.contains(child)) {
            children.remove(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.MALE)) {
            setFather(parent);
        } else {
            setMother(parent);
        }
        return true;
    }

    @Override
    public List<Human> getParents() {
        List<Human> result = new ArrayList<>(2);
        if (father != null) {
            result.add(father);
        }
        if (mother != null) {
            result.add(mother);
        }
        return result;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append("Id: ").append(getId())
                .append(", Имя: ").append(getName())
                .append(", ").append(getGenderInfo())
                .append(", возраст: ").append(getAge());
        if (getAge() % 10 == 1) {
            result.append(" год");
        } else if (getAge() % 10 > 1 && getAge() % 10 < 5) {
            result.append(" года");
        } else {
            result.append(" лет");
        }
        result.append(", дата рождения: ").append(getBirthDay().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        result.append(", ").append(getDeathDateInfo())
                .append(", ").append(getFatherInfo())
                .append(", ").append(getMotherInfo())
                .append(", ").append(getSpouseInfo())
                .append(", ").append(getChildrenInfo());
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    public static class HumanBuilder {
        private int id;
        private String name;
        private Gender gender;
        private LocalDate birthDay;
        private LocalDate deathDate;
        private Human father;
        private Human mother;
        private Human spouse;
        private final List<Human> children;

        public HumanBuilder(String name, Gender gender, LocalDate birthDay, Human father,
                            Human mother) {
            this.id = -1;
            this.name = name;
            this.gender = gender;
            this.birthDay = birthDay;
            this.deathDate = null;
            this.father = father;
            this.mother = mother;
            this.spouse = null;
            this.children = new ArrayList<>();
        }

        public HumanBuilder setHumanId(int id) {
            this.id = id;
            return this;
        }

        public HumanBuilder setHumanName(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder setHumanGender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public HumanBuilder setHumanBirthDay(LocalDate birthDay) {
            this.birthDay = birthDay;
            return this;
        }
        public HumanBuilder setHumanDeathDate(LocalDate deathDate) {
            this.deathDate = deathDate;
            return this;
        }
        public HumanBuilder setHumanFather (Human father) {
            this.father = father;
            return this;

        }
        public HumanBuilder setHumanMother (Human mother) {
            this.mother = mother;
            return this;
        }
        public HumanBuilder setHumanSpouse (Human spouse) {
            this.spouse = spouse;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }

    private Human(HumanBuilder builder) {
        id = builder.id;
        name = builder.name;
        gender = builder.gender;
        birthDay = builder.birthDay;
        deathDate = builder.deathDate;
        father = builder.father;
        mother = builder.mother;
        spouse = builder.spouse;
        children = builder.children;
    }
}
