

import java.time.LocalDate;
import java.util.List;

public class HumanWithParentsWithChildren extends HumanWithParents{
    private List<Human> children;

    //Конструктор
    public HumanWithParentsWithChildren(String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother, List<Human>children){
        super(name,dateOfBirth,gender,father,mother);
        this.children = children;
    }

    //Геттер

    public List <Human> getChildren() {
        return children;
    }


    // Переопределение метода
    @Override
    public String toString(){
        return  super.toString()+ "Дети: " + children + "\n";
    }
}
