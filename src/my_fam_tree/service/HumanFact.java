package my_fam_tree.service;

import my_fam_tree.model.Human;
import java.time.LocalDate;

public class HumanFact {
    public Human createHuman(String name, String gender, String birthDateInput) {
        String normalizedGender = gender.trim().equalsIgnoreCase("М") ? "Мужской" : "Женский";
        LocalDate birthDate = LocalDate.parse(birthDateInput);
        return new Human(name, normalizedGender, birthDate);
    }
}
