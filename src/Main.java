import model.builder.Gender;
import model.builder.Human;
import view.DesktopUI;
import view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new DesktopUI();

        Human vasya = view.createHuman("Василий", Gender.Male, LocalDate.of(1963, 12, 18));
        Human masha = view.createHuman("Мария", Gender.Female, LocalDate.of(1965, 9, 15));

        ((DesktopUI) view).setWedding(vasya, masha);

        Human kristina = view.createHuman("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), vasya, masha);
        Human semyon = view.createHuman("Семён", Gender.Male, LocalDate.of(1991, 1, 25), vasya, masha);

        Human larisa = view.createHuman("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        ((DesktopUI) view).addChild(larisa, vasya);
        ((DesktopUI) view).saveFamilyTree();

        String familyTreeInfo = ((DesktopUI) view).showFamilyTreeInfo();
        System.out.println(familyTreeInfo);
    }
}