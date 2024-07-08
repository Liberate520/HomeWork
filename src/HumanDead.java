

import java.time.LocalDate;

public class HumanDead extends Human {
    private LocalDate dateOfDeath;

    //Конструктор

    public HumanDead(String name, LocalDate dateOfBirth, Gender gender,LocalDate dateOfDeath) {
        super(name,dateOfBirth,gender);
        this.dateOfDeath = dateOfDeath;
    }

    // Геттер
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    // Переопределение метода
    @Override
    public String toString(){
        return  super.toString()+
                "Дата смерти: " + dateOfDeath + "\n";
    }
}
