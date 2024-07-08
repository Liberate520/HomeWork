

import java.time.LocalDate;
public class HumanWithParents extends Human {

    private Human father, mother;

    //Конструктор

    public HumanWithParents(String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother) {
        super(name,dateOfBirth,gender);
        this.father = father;
        this.mother = mother;

    }

    // Геттеры
    public Human getFather() {
        return father;
    }
    public Human getMother() {
        return mother;
    }

    // Переопределение метода
    @Override
    public String toString(){
        return  super.toString()+
                "Отец: " + father.getName() + "\n"+
                "Мать: " + mother.getName() + "\n";
    }
}
