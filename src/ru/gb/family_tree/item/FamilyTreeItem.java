package ru.gb.family_tree.item;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeItem<E> implements Serializable, Comparator<FamilyTreeItem<E>> {
    protected long id;
    protected String name;
    protected List<FamilyTreeItem<E>> parents;
    protected List<FamilyTreeItem<E>> children;
    protected LocalDate birthDate, deathDate;
    protected Gender gender;
    protected FamilyTreeItem<E> spouse;
    protected FamilyTreeItem<E> father;
    protected FamilyTreeItem<E> mother;

    public FamilyTreeItem(long id,
            String name,
            Gender gender,
            LocalDate birthDate,
            LocalDate deathDate,
            FamilyTreeItem<E> father,
            FamilyTreeItem<E> mother) {

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
            FamilyTreeItem<E> father,
            FamilyTreeItem<E> mother) {

        this(id, name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(FamilyTreeItem<E> child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(FamilyTreeItem<E> parent) {
        if (!parents.contains(parent) && parents.size() < 2) { /// && parents.size() < 2 ДОБАВИЛ Я
            parents.add(parent);
            return true;
        }
        return false;
    }

    public FamilyTreeItem<E> getMother() {
        for (FamilyTreeItem<E> parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public FamilyTreeItem<E> getFather() {
        for (FamilyTreeItem<E> parent : parents) {
            if (parent.getGender() == Gender.Male) {
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

    public String getSpouseInfo() {
        String res = "супруг[а]: ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother == null) {
            res += "неизвестна";
        } else {
            res += mother.getName();
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (father == null) {
            res += "неизвестен";
        } else {
            res += father.getName();
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName()); /// ОТ ЭТОГО МОЖНО ИЗБАВИТЬСЯ, НАВЕРНО???
            for (int i = 1; i < children.size(); i++) {
                res.append(", "); /// ВОТ ТУТ БУДЕТ НЕМНОГО НЕКРАСИВО
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public void setSpouse(FamilyTreeItem<E> spouse) {
        this.spouse = spouse;
    }

    public FamilyTreeItem<E> getSpouse() {
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

    public List<FamilyTreeItem<E>> getParents() {
        return parents;
    }

    public List<FamilyTreeItem<E>> getChildren() {
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

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FamilyTreeItem)) {
            return false;
        }
        FamilyTreeItem<E> item = (FamilyTreeItem<E>) obj;
        return item.getId() == getId();
    }

    @Override
    public int compare(FamilyTreeItem<E> o1, FamilyTreeItem<E> o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
