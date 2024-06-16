package ru.gb.family_tree.model.item;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeItem<E> implements Serializable {
    protected long id;
    protected String name;
    protected List<E> parents;
    protected List<E> children;
    protected LocalDate birthDate, deathDate;
    protected Gender gender;
    protected E spouse;
    protected E father;
    protected E mother;

    public FamilyTreeItem(long id,
            String name,
            Gender gender,
            LocalDate birthDate,
            LocalDate deathDate,
            E father,
            E mother) {

        this.id = id;
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

    public FamilyTreeItem(long id,
            String name,
            Gender gender,
            LocalDate birthDate) {

        this(id, name, gender, birthDate, null, null, null);
    }

    public FamilyTreeItem(long id,
            String name,
            Gender gender,
            LocalDate birthDate,
            E father,
            E mother) {

        this(id, name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(E child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(E parent) {
        if (!parents.contains(parent) && parents.size() < 2) { /// && parents.size() < 2 ДОБАВИЛ Я
            parents.add(parent);
            return true;
        }
        return false;
    }

    @SuppressWarnings("rawtypes")
    public E getMother() {
        for (E parent : parents) {
            if (((FamilyTreeItem) parent).getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public E getFather() {
        for (E parent : parents) {
            if (((FamilyTreeItem) parent).getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    @SuppressWarnings("rawtypes")
    public String getSpouseInfo() {
        String res = "супруг[а]: ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += ((FamilyTreeItem) spouse).getName();
        }
        return res;
    }

    @SuppressWarnings("rawtypes")
    public String getMotherInfo() {
        String res = "мать: ";
        if (mother == null) {
            res += "неизвестна";
        } else {
            res += ((FamilyTreeItem) mother).getName();
        }
        return res;
    }

    @SuppressWarnings("rawtypes")
    public String getFatherInfo() {
        String res = "отец: ";
        if (father == null) {
            res += "неизвестен";
        } else {
            res += ((FamilyTreeItem) father).getName();
        }
        return res;
    }

    @SuppressWarnings("rawtypes")
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(((FamilyTreeItem) children.get(0)).getName()); /// ОТ ЭТОГО МОЖНО ИЗБАВИТЬСЯ, НАВЕРНО???
            for (int i = 1; i < children.size(); i++) {
                res.append(", "); /// ВОТ ТУТ БУДЕТ НЕМНОГО НЕКРАСИВО
                res.append(((FamilyTreeItem) children.get(i)).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public void setSpouse(E spouse) {
        this.spouse = spouse;
    }

    public E getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<E> getParents() {
        return parents;
    }

    public List<E> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FamilyTreeItem)) {
            return false;
        }
        E item = (E) obj;
        return ((FamilyTreeItem) item).getId() == getId();
    }

}
