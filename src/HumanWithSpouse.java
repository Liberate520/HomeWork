

import java.time.LocalDate;

public class HumanWithSpouse extends Human{
    private Human spouse;

    //Конструктор
    public HumanWithSpouse(String name, LocalDate dateOfBirth, Gender gender, Human spouse){
        super(name,dateOfBirth,gender);
        this.spouse = spouse;
    }

    //Геттер

    public Human getSpouse() {
        return spouse;
    }


    // Переопределение метода
    @Override
    public String toString(){
        return  super.toString()+ "Супруг/супруга: " + spouse.getName() + "\n";
    }
}
