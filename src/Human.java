

import java.time.LocalDate;
public class Human {

    private final String name;
    private LocalDate dateOfBirth;
    private Gender gender;

    //Конструктор

    public Human(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;

    }

    // Геттеры
    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    // Ещё методы
    @Override
    public String toString(){
        return  "Имя: " + name + "\n" +
                "Дата рождения: " + dateOfBirth + "\n" +
                "Пол:  " + gender + "\n";
    }
}
