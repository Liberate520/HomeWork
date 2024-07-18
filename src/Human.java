import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Human {
    private String surname, name, middleName, spouse, dad, mom, children;
    private Gender gender;
    private LocalDate birthDate, deathDate;

    /**Добавление человека.
     * @param surname Укажите фамилию.
     * @param name Укажите имя.
     * @param middleName Укажите отчество.
     * @param gender Укажите гендер (мужской - Gender.Male, женский - Gender.Female).
     * @param birthDate Укажите дату рождения - LocalDate.of(год, месяц, число).
     * @param deathDate Укажите дату смерти - LocalDate.of(год, месяц, число). Если человек жив, то укажите null.
     * */
    public Human(String surname, String name, String middleName, Gender gender, LocalDate birthDate, LocalDate deathDate, String spouse, String dad, String mom, String children) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.spouse = spouse;
        this.dad = dad;
        this.mom = mom;
        this.children = children;
    }

    public int getAge() {
        if (deathDate == null) {
            deathDate = LocalDate.now();
            return Period.between(birthDate, deathDate).getYears();
        }
        return Period.between(birthDate, deathDate).getYears();
    }

    public String isAlive(){
        if (deathDate == null) {
            return "текущий";
        }
        return "на момент смерти";
    }

    @Override
    public String toString() {
        return "---------------------------------\n" +
                "ФИО: " + surname + " " + name + " " + middleName +
                "\nПол: " + gender +
                "\nВозраст (" + isAlive() + "): " + getAge() +
                "\nСупруг(а): " + spouse +
                "\nОтец: " + dad +
                "\nМать: " + mom +
                "\nДети: " + children;
    }
}
