package model;
import Presenter.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Dog extends Node implements Serializable {
    private static final long serialVersionUID = 1L; // Опционально, для контроля версии класса
    private String name;
    private String gender;
    private LocalDate birthDate;

    public Dog(String name, String gender, LocalDate birthDate) {
        super(name, Gender.valueOf(gender), birthDate);
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', gender='" + gender + "', birthDate=" + birthDate + "}";
    }
}
