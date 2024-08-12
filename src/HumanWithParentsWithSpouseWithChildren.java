import java.time.LocalDate;
import java.util.List;

public class HumanWithParentsWithSpouseWithChildren extends HumanWithParentsWithSpouse{
    private List<Human> children;

    //Конструктор
    public HumanWithParentsWithSpouseWithChildren(String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother, Human spouse, List<Human>children){
        super(name,dateOfBirth,gender,father,mother,spouse);
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