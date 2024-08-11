import java.time.LocalDate;

public class Human  extends HumanAbsract {
    public Human(String name, String gender, LocalDate dateOfBirth) {
        super(name, gender, dateOfBirth);
    }
    @Override
    public String getFullInfo(){
        return name + "(Пол: "+ gender + ", Дата рождения: " + dateOfBirth + ")";
    }
    @Override
    public String toString(){
        return getFullInfo();
    }
}




