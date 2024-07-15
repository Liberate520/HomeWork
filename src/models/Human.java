package models;

import java.io.*;

import enums.Gender;

/**
 * Класс Human представляет человека в генеалогическом древе.
 * Он содержит информацию о имени, дате рождения, дате смерти, поле,
 * а также ссылки на мать и отца.
 */
public class Human implements Serializable {
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
     * @param birthDate  дата рождения в формате "dd.MM.yyyy"
     * @param deathDate  дата смерти в формате "dd.MM.yyyy"
     * @param gender     пол человека (MALE или FEMALE)
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
     * @return дата рождения в формате "dd.MM.yyyy"
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает дату смерти человека.
     *
     * @return дата смерти в формате "dd.MM.yyyy"
     */
    public String getDeathDate() {
        return deathDate;
    }

    /**
     * Возвращает пол человека.
     *
     * @return пол человека (MALE или FEMALE)
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Возвращает мать человека.
     *
     * @return объект класса Human, представляющий мать
     */
    public Human getMother() {
        return mother;
    }

    /**
     * Устанавливает мать человека.
     *
     * @param mother объект класса Human, представляющий мать
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**
     * Возвращает отца человека.
     *
     * @return объект класса Human, представляющий отца
     */
    public Human getFather() {
        return father;
    }

    /**
     * Устанавливает отца человека.
     *
     * @param father объект класса Human, представляющий отца
     */
    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Возвращает строковое представление объекта класса Human.
     * Формат строки: "Имя Рождение: dd.MM.yyyy Смерть: dd.MM.yyyy Отец: Имя_отца Мать: Имя_матери"
     *
     * @return строковое представление объекта класса Human
     */
    @Override
    public String toString() {
        return name + " Рождение: " + birthDate + " Смерть: " + deathDate + " Отец: " + (father != null ? father.getName() : "Неизвестен") + " Мать: " + (mother != null ? mother.getName() : "Неизвестна");
    }
}