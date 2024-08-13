package lv.homeWork.model;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static int calculateAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        LocalDate currentDate = dateOfDeath != null ? dateOfDeath : LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }
}

