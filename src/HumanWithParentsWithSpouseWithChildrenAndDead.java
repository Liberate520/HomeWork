
import java.util.List;
import java.time.LocalDate;

public class HumanWithParentsWithSpouseWithChildrenAndDead extends HumanWithParentsWithSpouseWithChildren{
    private LocalDate dateOfDeath;

    //Конструктор

    public HumanWithParentsWithSpouseWithChildrenAndDead (String name, LocalDate dateOfBirth, Gender gender,Human father, Human mother, Human spouse, List<Human>children, LocalDate dateOfDeath) {
        super(name,dateOfBirth,gender, father, mother, spouse, children);
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