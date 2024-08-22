package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

/**
 * Класс Human представляет человека в семейном дереве и реализует интерфейс {@link FamilyTreeElement}.
 * Хранит основную информацию о человеке, его родственных связях, супругах и жизненном статусе.
 */
public class Human implements Serializable, FamilyTreeElement<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob, dod;
    private List<Human> children;
    private Human mother, father;
    private HashMap<Human, SpouseStatus> spouses = new HashMap<>();

    /**
     * Конструктор для создания объекта Human.
     *
     * @param name   имя человека
     * @param gender пол человека
     * @param dob    дата рождения человека (в формате "yyyy-mm-dd")
     */
    public Human(String name, Gender gender, String dob) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = LocalDate.parse(dob);
        this.children = new ArrayList<>();
        this.spouses = new HashMap<>();
    }

    /**
     * Возвращает уникальный идентификатор человека.
     *
     * @return уникальный идентификатор
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор человека.
     *
     * @param id уникальный идентификатор
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Возвращает имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     *
     * @param name имя человека
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает дату рождения человека.
     *
     * @return дата рождения
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Устанавливает дату рождения человека.
     *
     * @param dob дата рождения
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Возвращает дату смерти человека (если применимо).
     *
     * @return дата смерти или null, если человек еще жив
     */
    public LocalDate getDod() {
        return dod;
    }

    /**
     * Устанавливает дату смерти человека.
     *
     * @param dod дата смерти
     */
    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    /**
     * Возвращает пол человека.
     *
     * @return пол человека
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Устанавливает пол человека.
     *
     * @param gender пол человека
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Возвращает список детей человека.
     *
     * @return список детей
     */
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Добавляет ребенка к списку детей человека.
     *
     * @param child ребенок для добавления
     * @return true, если ребенок был успешно добавлен, иначе false
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Возвращает информацию о детях человека в виде строки.
     *
     * @return информация о детях
     */
    public String getChildrenAbout() {
        StringBuilder childrenAbout = new StringBuilder();
        childrenAbout.append("Children: ");
        if (children.size() > 0) {
            childrenAbout.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                childrenAbout.append(", ");
                childrenAbout.append(children.get(i).getName());
            }
        } else {
            childrenAbout.append("None");
        }
        return childrenAbout.toString();
    }

    /**
     * Возвращает мать человека.
     *
     * @return мать человека или null, если информация отсутствует
     */
    public Human getMother() {
        return mother;
    }

    /**
     * Устанавливает мать человека.
     *
     * @param mother мать человека
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**
     * Возвращает информацию о матери человека в виде строки.
     *
     * @return информация о матери
     */
    public String getMotherAbout() {
        String motherAbout = "Mother: ";
        Human mother = getMother();
        if (mother == null) {
            motherAbout += "Unknown";
        } else {
            motherAbout += mother.getName();
        }
        return motherAbout;
    }

    /**
     * Возвращает отца человека.
     *
     * @return отец человека или null, если информация отсутствует
     */
    public Human getFather() {
        return father;
    }

    /**
     * Устанавливает отца человека.
     *
     * @param father отец человека
     */
    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Возвращает информацию об отце человека в виде строки.
     *
     * @return информация об отце
     */
    public String getFatherAbout() {
        String fatherAbout = "Father: ";
        Human father = getFather();
        if (father == null) {
            fatherAbout += "Unknown";
        } else {
            fatherAbout += father.getName();
        }
        return fatherAbout;
    }

    /**
     * Добавляет родителя к человеку (мать или отец).
     *
     * @param parent родитель для добавления
     */
    public void addParent(Human parent) {
        if (parent.gender.equals(Gender.male)) {
            this.setFather(parent);
            if (!parent.getChildren().contains(this)) {
                parent.addChild(this);
            }
        } else if (parent.gender.equals(Gender.female)) {
            this.setMother(parent);
            if (!parent.getChildren().contains(this)) {
                parent.addChild(this);
            }
        }
    }

    /**
     * Возвращает список супругов человека и их статус.
     *
     * @return карта супругов и их статусов
     */
    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    /**
     * Добавляет супруга к человеку с указанным статусом.
     *
     * @param spouse супруг для добавления
     * @param status статус супруга
     */
    public void addSpouse(Human spouse, SpouseStatus status) {
        if (!this.spouses.containsKey(spouse)) {
            this.spouses.put(spouse, status);
            spouse.addSpouse(this, status);
        }
    }

    /**
     * Возвращает информацию о супругах человека в виде строки.
     *
     * @return информация о супругах
     */
    public String getSpousesAbout() {
        StringBuilder spousesAbout = new StringBuilder();
        spousesAbout.append("Spouses: ");

        if (!spouses.isEmpty()) {
            boolean first = true;
            for (Map.Entry<Human, SpouseStatus> entry : spouses.entrySet()) {
                if (!first) {
                    spousesAbout.append(", ");
                } else {
                    first = false;
                }
                spousesAbout.append(entry.getKey().getName());
                spousesAbout.append(": ");
                spousesAbout.append(entry.getValue());
            }
        } else {
            spousesAbout.append("None");
        }

        return spousesAbout.toString();
    }

    /**
     * Возвращает возраст человека, основываясь на его дате рождения и, если применимо, дате смерти.
     *
     * @return возраст человека
     */
    public int getAge() {
        if (dod == null) {
            return getInterval(dob, LocalDate.now());
        } else {
            return getInterval(dob, dod);
        }
    }

    /**
     * Возвращает жизненный статус человека ("Alive" или "Dead").
     *
     * @return жизненный статус человека
     */
    public String getLifeStatus() {
        if (dod == null) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    /**
     * Возвращает полную информацию о человеке в виде строки.
     *
     * @return информация о человеке
     */
    public String getAbout() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("\nName: ");
        sb.append(name);
        sb.append("\nGender: ");
        sb.append(getGender());
        sb.append("\nAge: " + getAge() + ". " + getLifeStatus());
        sb.append("\n" + getChildrenAbout());
        sb.append("\n" + getMotherAbout());
        sb.append("\n" + getFatherAbout());
        sb.append("\n" + getSpousesAbout());
        return sb.toString();
    }

    /**
     * Возвращает строковое представление объекта человека.
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return getAbout();
    }

    /**
     * Проверяет равенство двух объектов Human на основе их уникальных идентификаторов.
     *
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false
     */
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

    /**
     * Возвращает количество полных лет между двумя датами.
     *
     * @param dob дата начала периода (дата рождения)
     * @param dod дата окончания периода (дата смерти или текущая дата)
     * @return количество полных лет
     */
    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }

}
