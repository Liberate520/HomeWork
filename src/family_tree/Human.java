package family_tree;

import java.time.LocalDate;
import java.util.*;

public class Human {
    private String ID;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private String idMother;
    private String idFather;
    private List<String> children;

    @Override
    public String toString() {
        StringBuilder sb = new  StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("|%13s | " +
                "%13s |" +
                "%13s |" +
                "%14s |" +
                "%13s |" +
                "%13s |" +
                "%13s |" +
                "%20s |"
                , getNull(ID),
                getNull(name),
                getNull(getGenderText(gender)),
                getNull(birthDate),
                getNull(deathDate),
                getNull(idMother),
                getNull(idFather),
                getNull(children));

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(ID, human.ID) && Objects.equals(name, human.name) && gender == human.gender && Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, gender, birthDate);
    }

    public Human(String ID, String name, Gender gender, LocalDate birthDate) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public void setMother(String idMother) {
        this.idMother = idMother;
    }

    public void setFather(String idFather) {
        this.idFather = idFather;
    }

    public void  addChild(String idChild) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(idChild);
    }

    public String getID() {
        return ID;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    private String getGenderText(Gender value) {
        if (value == Gender.Male) {
            return "Мужской";
        }
        else {
            return "Женский";
        }
    }

    private Object getNull(Object o) {
        Object answer;
        if (o == null) {
            answer = "нет данных";
        }
        else {
            answer = o;
        }
        return answer;
    }



}
