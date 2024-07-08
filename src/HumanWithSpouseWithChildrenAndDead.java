

import java.time.LocalDate;
import java.util.List;
public class HumanWithSpouseWithChildrenAndDead extends HumanWithSpouseWithChildren {

    private LocalDate dateOfDeath;

    //Конструкторы



    public HumanWithSpouseWithChildrenAndDead(String name, LocalDate dateOfBirth, Gender gender, Human spouse, List<Human> children, LocalDate dateOfDeath) {
        super(name,dateOfBirth,gender,spouse,children);
        this.dateOfDeath = dateOfDeath;
    }

    // Геттер

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    //Сеттеры

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    // Ещё методы

    @Override
    public String toString(){
        return  super.toString()+
                "Дата смерти: " + dateOfDeath + "\n";
    }

}
