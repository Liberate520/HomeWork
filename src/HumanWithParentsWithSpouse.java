import java.time.LocalDate;

public class HumanWithParentsWithSpouse extends HumanWithParents{

    private Human spouse;

    //Конструктор
    public HumanWithParentsWithSpouse(String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother, Human spouse){
        super(name,dateOfBirth,gender,father,mother);
        this.spouse = spouse;
    }

    //Геттер

    public Human getSpouse() {
        return spouse;
    }


    // Переопределение метода
    @Override
    public String toString(){
        return  super.toString()+ "Супруг/супруга:\n " + spouse.getName() + "\n";
    }
}