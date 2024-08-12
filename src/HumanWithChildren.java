import java.time.LocalDate;
import java.util.List;

public class HumanWithChildren extends Human {
    private List <Human> children;

    //Конструктор
    public HumanWithChildren(String name, LocalDate dateOfBirth, Gender gender, List<Human>children){
        super(name,dateOfBirth,gender);
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