import java.time.LocalDate;

public class Human extends TreeMember {

    public Human(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        super(name, birthDate, deathDate, gender);
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, TreeMember mother, TreeMember father) {
        super(name, birthDate, gender, mother, father);
    }
}
