package models;

import enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс, представляющий человека в генеалогическом древе.
 * Содержит информацию о человеке, такую как имя, пол, дата рождения и дата смерти.
 */
public class Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;

    /**
     * Конструктор класса Human.
     *
     * @param name       Имя человека
     * @param gender     Пол человека
     * @param birthDate  Дата рождения человека
     * @param deathDate  Дата смерти человека
     */
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * Возвращает имя человека.
     *
     * @return Имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает пол человека.
     *
     * @return Пол человека
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Возвращает дату рождения человека.
     *
     * @return Дата рождения человека
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает дату смерти человека.
     *
     * @return Дата смерти человека
     */
    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("%s\nРождение: %s\nСмерть: %s", name, birthDate.format(formatter), deathDate.format(formatter));
    }
}