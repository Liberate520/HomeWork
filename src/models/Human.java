package models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс Human представляет человека в генеалогическом древе.
 * Он содержит информацию о человеке, такую как имя, дата рождения, дата смерти и пол.
 * Класс реализует интерфейсы Serializable и Comparable, что позволяет использовать его в качестве
 * элемента генеалогического древа и сохранять/загружать данные в/из файла.
 */
public class Human implements Serializable, Comparable<Human> {
    private static final long serialVersionUID = 1L;

    private String name;
    private String birthDate;
    private String deathDate;
    private Gender gender;
    private Human mother;
    private Human father;

    /**
     * Конструктор класса Human.
     *
     * @param name       имя человека
     * @param birthDate  дата рождения человека
     * @param deathDate  дата смерти человека
     * @param gender     пол человека
     */
    public Human(String name, String birthDate, String deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
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
     * Возвращает дату рождения человека.
     *
     * @return дата рождения человека
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает дату смерти человека.
     *
     * @return дата смерти человека
     */
    public String getDeathDate() {
        return deathDate;
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
     * Устанавливает мать человека.
     *
     * @param mother мать человека
     */
    public void setMother(Human mother) {
        this.mother = mother;
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
     * Возвращает строковое представление человека.
     *
     * @return строковое представление человека
     */
    @Override
    public String toString() {
        return name + ", " + birthDate + " - " + deathDate + ", " + gender;
    }

    /**
     * Сравнивает двух людей по их имени.
     *
     * @param other другой человек для сравнения
     * @return результат сравнения
     */
    @Override
    public int compareTo(Human other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Определяет, равны ли два человека.
     *
     * @param o другой объект для сравнения
     * @return true, если люди равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(birthDate, human.birthDate) &&
                Objects.equals(deathDate, human.deathDate) &&
                gender == human.gender;
    }

    /**
     * Возвращает хэш-код человека.
     *
     * @return хэш-код человека
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, deathDate, gender);
    }
}
