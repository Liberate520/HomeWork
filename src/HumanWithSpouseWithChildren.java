
import java.time.LocalDate;
import java.util.List;

public class HumanWithSpouseWithChildren extends HumanWithSpouse{
    private List<Human> children;

    //Конструктор
    public HumanWithSpouseWithChildren(String name, LocalDate dateOfBirth, Gender gender, Human spouse, List<Human>children){
        super(name,dateOfBirth,gender,spouse);
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
