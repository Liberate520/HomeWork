package ru.gb.family.humans;

import ru.gb.family.humans.enums.DegreeOfKinship;
import ru.gb.family.humans.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeneratHuman {
    public GeneratHuman() {
        List<Human> newHuman = new ArrayList<>();
    }

    public List<Human> GeneratHuman() {
        List<Human> newHuman = new ArrayList<>();
        Human human1 = new Human("Васильев Роман Максимович", LocalDate.of(2015, 5, 6), null, Gender.Male);
        Human human2 = new Human("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21), null, Gender.Male);
        Human human3 = new Human("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17), null, Gender.Female);

        Human human4 = new Human("Васильева Алина Андреевна", LocalDate.of(2018, 3, 8), null, Gender.Female);
        Human human5 = new Human("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1), null, Gender.Male);
        Human human6 = new Human("Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11), null, Gender.Female);

        Human human7 = new Human("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15), LocalDate.of(2010, 5, 1), Gender.Male);
        Human human8 = new Human("Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28), null, Gender.Female);

        human1.editHuman(human2, DegreeOfKinship.Father);
        human1.editHuman(human3, DegreeOfKinship.Mother);
        human2.editHuman(human3, DegreeOfKinship.Spouse);

        human4.editHuman(human5, DegreeOfKinship.Father);
        human4.editHuman(human6, DegreeOfKinship.Mother);
        human5.editHuman(human6, DegreeOfKinship.Spouse);

        human7.editHuman(human2, DegreeOfKinship.Children);
        human7.editHuman(human5, DegreeOfKinship.Children);
        human8.editHuman(human2, DegreeOfKinship.Children);
        human8.editHuman(human5, DegreeOfKinship.Children);

        human7.editHuman(human8, DegreeOfKinship.Spouse);

        newHuman.add(human1);
        newHuman.add(human2);
        newHuman.add(human3);
        newHuman.add(human4);
        newHuman.add(human5);
        newHuman.add(human6);
        newHuman.add(human7);
        newHuman.add(human8);
        return newHuman;
    }


}
