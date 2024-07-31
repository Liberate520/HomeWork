package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyTreeElement;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

/**
 * Класс, представляющий человека в семейном древе.
 * Реализует интерфейсы Serializable и FamilyTreeElement<Human>.
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
     * Конструктор класса Human.
     *
     * @param name   имя человека
     * @param gender пол человека
     * @param dob    дата рождения
     * @param dod    дата смерти (может быть null)
     * @param mother мать человека
     * @param father отец человека
     */
    public Human(String name, Gender gender, LocalDate dob, LocalDate dod, Human mother, Human father) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.dod = dod;
        this.children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        this.spouses = new HashMap<>();
    }

    /**
     * Перегруженный конструктор без даты смерти.
     *
     * @param name   имя человека
     * @param gender пол человека
     * @param dob    дата рождения
     * @param mother мать человека
     * @param father отец человека
     */
    public Human(String name, Gender gender, LocalDate dob, Human mother, Human father) {
        this(name, gender, dob, null, mother, father);
    }

    /**
     * Перегруженный конструктор без родителей.
     *
     * @param name   имя человека
     * @param gender пол человека
     * @param dob    дата рождения
     * @param dod    дата смерти
     */
    public Human(String name, Gender gender, LocalDate dob, LocalDate dod) {
        this(name, gender, dob, dod, null, null);
    }

    /**
     * Перегруженный конструктор только с именем, полом и датой рождения.
     *
     * @param name   имя человека
     * @param gender пол человека
     * @param dob    дата рождения
     */
    public Human(String name, Gender gender, LocalDate dob) {
        this(name, gender, dob, null, null, null);
    }

    /**
     * Получить ID человека.
     *
     * @return ID человека
     */
    public long getId() {
        return id;
    }

    /**
     * Установить ID человека.
     *
     * @param id новый ID человека
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Вывести ID человека в консоль.
     */
    public void PrintId() {
        System.out.println("Id: " + this.getId());
    }

    /**
     * Получить имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя человека.
     *
     * @param name новое имя человека
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Вывести имя человека в консоль.
     */
    public void PrintName() {
        System.out.println("Surname Name Patronymic: " + this.getName());
    }

    /**
     * Получить дату рождения человека.
     *
     * @return дата рождения человека
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Установить дату рождения человека.
     *
     * @param dob новая дата рождения человека
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Вывести дату рождения человека в консоль.
     */
    public void PrintDob() {
        System.out.println("Date of Birth (year-month-day): " + this.getDob());
    }

    /**
     * Получить дату смерти человека.
     *
     * @return дата смерти человека (может быть null)
     */
    public LocalDate getDod() {
        return dod;
    }

    /**
     * Установить дату смерти человека.
     *
     * @param dod новая дата смерти человека
     */
    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    /**
     * Вывести дату смерти человека в консоль.
     * Если дата смерти null, выводится сообщение, что человек жив.
     */
    public void PrintDod() {
        if (dod == null) {
            System.out.println("Is alive");
        } else {
            System.out.println("Date of Death (year-month-day): " + this.getDod());
        }
    }

    /**
     * Получить пол человека.
     *
     * @return пол человека
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Установить пол человека.
     *
     * @param gender новый пол человека
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Вывести пол человека в консоль.
     */
    public void PrintGender() {
        System.out.println("Gender: " + this.getGender());
    }

    /**
     * Получить список детей человека.
     *
     * @return список детей
     */
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Добавить ребенка к человеку.
     *
     * @param child ребенок для добавления
     * @return true, если ребенок успешно добавлен, иначе false
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Получить строку с информацией о детях человека.
     *
     * @return строка с именами детей или сообщение "None", если детей нет
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
     * Вывести информацию о детях человека в консоль.
     */
    public void PrintChildren() {
        System.out.println(getChildrenAbout());
    }

    /**
     * Получить мать человека.
     *
     * @return мать человека
     */
    public Human getMother() {
        return mother;
    }

    /**
     * Установить мать человека.
     *
     * @param mother новая мать человека
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**
     * Получить строку с информацией о матери человека.
     *
     * @return строка с именем матери или сообщение "Unknown", если мать неизвестна
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
     * Вывести информацию о матери человека в консоль.
     */
    public void PrintMother() {
        System.out.println(getMotherAbout());
    }

    /**
     * Получить отца человека.
     *
     * @return отец человека
     */
    public Human getFather() {
        return father;
    }

    /**
     * Установить отца человека.
     *
     * @param father новый отец человека
     */
    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Получить строку с информацией об отце человека.
     *
     * @return строка с именем отца или сообщение "Unknown", если отец неизвестен
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
     * Вывести информацию об отце человека в консоль.
     */
    public void PrintFather() {
        System.out.println(getFatherAbout());
    }

    /**
     * Получить карту с супругами человека и их статусами.
     *
     * @return карта с супругами и их статусами
     */
    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    /**
     * Добавить супруга к человеку.
     *
     * @param spouse супруг для добавления
     * @param status статус супруга
     * @return true, если супруг успешно добавлен, иначе false
     */
    public boolean addSpouse(Human spouse, SpouseStatus status) {
        if (this.spouses.containsKey(spouse)) {
            return false;
        } else {
            this.spouses.put(spouse, status);
        }
        return true;
    }

    /**
     * Получить строку с информацией о супругах человека.
     *
     * @return строка с именами и статусами супругов или сообщение "None", если супругов нет
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
     * Вывести информацию о супругах человека в консоль.
     */
    public void PrintSpouses() {
        System.out.println(getSpousesAbout());
    }

    /**
     * Рассчитать интервал в годах между двумя датами.
     *
     * @param dob дата начала
     * @param dod дата окончания
     * @return количество лет между датами
     */
    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }

    /**
     * Получить возраст человека.
     * Если человек жив, возраст считается до текущей даты.
     * Если умер, возраст считается до даты смерти.
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
     * Получить статус жизни человека (жив или мертв).
     *
     * @return "Alive" если человек жив, иначе "Dead"
     */
    public String getLifeStatus() {
        if (dod == null) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    /**
     * Вывести возраст и статус жизни человека в консоль.
     */
    public void PrintAge() {
        if (dod == null) {
            System.out.println(getLifeStatus() + ", age is: " + this.getAge());
        } else {
            System.out.println(getLifeStatus() + ", age was: " + this.getAge());
        }
    }

    /**
     * Возвращает строку с полной информацией о человеке.
     *
     * @return строка с информацией о человеке
     */
    @Override
    public String toString() {
        return getAbout();
    }

    /**
     * Получить строку с информацией о человеке.
     *
     * @return строка с информацией о человеке
     */
    public String getAbout() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name);
        sb.append("\nGender: ");
        sb.append(getGender());
        sb.append("\nAge: ").append(getAge()).append(". ").append(getLifeStatus());
        sb.append("\n").append(getChildrenAbout());
        sb.append("\n").append(getMotherAbout());
        sb.append("\n").append(getFatherAbout());
        sb.append("\n").append(getSpousesAbout());
        return sb.toString();
    }

    /**
     * Сравнивает текущий объект с другим объектом на равенство.
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
}
