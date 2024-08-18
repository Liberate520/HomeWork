package Model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember {
    int getId();
    String getFirstName();
    String getLastName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    Person.Gender getGender();
    FamilyMember getMother();
    FamilyMember getFather();
    List<? extends FamilyMember> getChildren();
    void addChild(FamilyMember child);
    void setMother(FamilyMember mother);
    void setFather(FamilyMember father);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setBirthDate(LocalDate birthDate);
    void setDeathDate(LocalDate deathDate);
    void setGender(Person.Gender gender);

}

