package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс Human представляет человека в генеалогическом древе.
 * Он содержит информацию о человеке, такую как имя, дата рождения, дата смерти и пол.
 * Класс реализует интерфейсы Serializable и Comparable для сериализации и сортировки.
 */
public class Human implements Serializable, Comparable<Human> {
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;

    /**
     * Конструктор класса Human.
     *
     * @param name       имя человека
     * @param birthDate  дата рождения человека в формате "дд.мм.гггг"
     * @param deathDate  дата смерти человека в формате "дд.мм.гггг"
     * @param gender     пол человека
     */
    public Human(String name, String birthDate, String deathDate, Gender gender) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, dateFormatter);
        this.deathDate = LocalDate.parse(deathDate, dateFormatter);
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
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает дату смерти человека.
     *
     * @return дата смерти человека
     */
    public LocalDate getDeathDate() {
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
     * Сравнивает двух людей по имени.
     *
     * @param other другой человек для сравнения
     * @return результат сравнения (-1, 0, 1)
     */
    @Override
    public int compareTo(Human other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Возвращает строковое представление человека.
     *
     * @return строковое представление человека
     */
    @Override
    public String toString() {
        return name + " (" + birthDate.format(dateFormatter) + " - " + deathDate.format(dateFormatter) + "), " + gender;
    }
}