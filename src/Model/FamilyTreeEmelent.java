package Model;

import java.time.LocalDate;

public interface FamilyTreeEmelent {
    String getName();
    LocalDate getDateOfBirth();
    LocalDate getDeathDate();
    Gender getGender();
}