package enums;

/**
 * Перечисление для представления пола человека.
 */
public enum Gender {

    /**
     * Мужской пол.
     */
    MALE("Мужской"),

    /**
     * Женский пол.
     */
    FEMALE("Женский");

    /**
     * Описание пола.
     */
    private String description;

    /**
     * Конструктор перечисления Gender.
     *
     * @param description Описание пола.
     */
    Gender(String description) {
        this.description = description;
    }

    /**
     * Возвращает описание пола.
     *
     * @return Описание пола.
     */
    public String getDescription() {
        return description;
    }
}