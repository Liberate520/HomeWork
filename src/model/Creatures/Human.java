package model.Creatures;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Creature<Human> {
    private final String name;
    private final LocalDate dob;
    private LocalDate dod;
    private List<Human> children;
    private Human father, mother;
    private final Gender gender;

    /**
     * Основной консруктор класса
     * Дети и родители добавляются другим методом
     * @param name ФИО человека
     * @param gender пол выбирается либо "Male", либо "Female"
     * @param dob дата рождения в формате строки "ГГГГ-ММ-ДД"
     * @param dod дата смерти в формате строки "ГГГГ-ММ-ДД", при отсуствии передается null
     */
    public Human (String name, Gender gender, String dob, String dod) {
        this.name = name;
        this.dob = LocalDate.parse(dob);
        if (dod != null) {
            this.dod = LocalDate.parse(dod);
        } else {
            this.dod = null;
        }
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    /**
     * Консруктор класса для живых
     * в дату смерти автоматически передается null
     * Дети и родители добавляются другим методом
     * @param name ФИО человека
     * @param gender пол выбирается либо "Male", либо "Female"
     * @param dob дата рождения в формате строки "ГГГГ-ММ-ДД"
     */
    public Human (String name, Gender gender, String dob) {
        this(name, gender, dob, null);
    }

    /**
     * Возвращает возраст человека
     * Для живых на текущую дату,
     * Для умерших на дату смерти
     * @return int
     */
    public int getAge() {
        if (dod == null) {
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        }
        return Period.between(dob, dod).getYears();
    }

    /**
     * Возвращает список детей
     * @return
     */
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Возвращает список родителей
     * @return
     */
    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        parents.add(mother);
        parents.add(father);
        return parents;
    }
    /**
     * Возвращает список бабушек и дедушек
     * @return
     */
    public List<Human> getGrandparents() {
        List<Human> grandparents = new ArrayList<>();
        if (mother != null) {
            grandparents.add(mother.mother);
            grandparents.add(mother.father);
        }
        if (father != null) {
            grandparents.add(father.mother);
            grandparents.add(father.father);
        }
        return grandparents;
    }
    /**
     * Возвращает список внуков
     * @return
     */
    public List<Human> getGrandsons () {
        List<Human> grandsons = new ArrayList<>();
        for (Human child: children) {
            if (child == null) {
                continue;
            }
            grandsons.addAll(child.getChildren());
        }

        return grandsons;
    }

    /**
     * Возвращает true если dod = null
     * @return
     */
    public boolean alive() {
        if (dod == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder("\n" + name + "\n" + "Пол " + gender + "\n" + "Родился " + dob);
        if (!alive()) {
            txt.append(", Умер ").append(dod);
        }
        txt.append("\n" + "Папа ");
        if (father != null) {
            txt.append(father.name);
        } else {
            txt.append("не известен");
        }
        txt.append("\n" + "Мама ");
        if (mother != null) {
            txt.append(mother.name);
        } else {
            txt.append("не известена");
        }
        txt.append("\n" + "Дети ");
        if (children != null){
            for (Human child: children) {
                txt.append(child.name).append(" ");
            }
        } else {
            txt.append("отсуствуют");
        }
        txt.append("\n");
        return txt.toString();
    }

    /**
     * добавляет родителей если их ранее было, при условии соотвествии пола.
     * @param mother ссылка на маму
     * @param father ссылка на папу
     */
    public void setParents(Human mother, Human father) {
        if (this.mother == null && mother.gender == Gender.Female) {
            this.mother = mother;
            this.mother.setChildren(this);
        }
        if (this.father == null && father.gender == Gender.Male) {
            this.father = father;
            this.father.setChildren(this);
        }
    }

    /**
     * добавляет в список ребенка если его там не было
     * @param child
     */
    public void setChildren(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    /**
     * Возвращает имя ввиде String
     * @return String
     */
    public String getName() {
        return name;
    }
}
