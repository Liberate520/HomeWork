package model.Humans;
import java.time.LocalDate;
import java.util.List;

public class FamilyFriend extends Human {

    private LocalDate datingDate;

    public FamilyFriend(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender, Human father, Human mother,
            List<Human> children, LocalDate datingDate){
                super(name, dateOfBorn, dateOfDeath, gender, father, mother);
                this.datingDate = datingDate;
    }

    public LocalDate getDatingDate() {
        return datingDate;
    }

    public void setDatingDate(LocalDate datingDate) {
        this.datingDate = datingDate;
    }
    
    @Override
    public String toString() {
        return super.toString() + "DatingDate: " + datingDate;
    }

}
