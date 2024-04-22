import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/***
 Класс человека
 */
public class Human implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate dob, dod;
    private Human father;
    private Human mother;
    private final List<Human> children = new ArrayList<>();

    /***
     * Класс Human
     * @param name имя человека
     * @param gender пол
     * @param dob дата рождения
     */
//    public Human(String name, Gender gender, LocalDate dob) {
//        this.name = name;
//        this.gender = gender;
//        this.dob = dob;
//    }

    /***
     * Класс Human
     * @param name имя человека
     * @param gender пол
     * @param dob дата рождения
     * @param dod дата смерти
     */
    public Human(String name, Gender gender, LocalDate dob, LocalDate dod) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.dod = dod;
    }

    /***
     *Метод для даты рождения
     * @return возвращает дату рождения
     */
    public LocalDate getDob() {
        return this.dob;
    }

    /***
     * Метод для даты смерти
     * @return возвращает дату смерти
     */
    public LocalDate getDod(){
        return this.dod;
    }

    /***
     * Метод для даты смерти
     * @param dod добавление даты смерти
     */
    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    /***
     * Метод добавление матери для Human
     * @param mother ввести класс Human
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /***
     * Метод для матери
     * @return возвращает параметры матери (Имя, дату рождения и т.п.)
     */
    public Human getMother() {
        return this.mother;
    }

    /***
     * Метод добавление отца для Human
     * @param father ввести класс Human
     */
    public void setFather(Human father){
        this.father = father;
    }

    /***
     * Метод для отца
     * @return возвращает параметры отца (имя, дату рождения и т.п.)
     */
    public Human getFather(){
        return this.father;
    }

    /***
     * Метод добавления ребенка
     * @param human ввести класс Human
     */
    public void addChildren(Human human){
        children.add(human);
    }

    /***
     * Метод вывода списка детей
     * @return выводит список детей для человека и его родителей
     */
    public StringBuilder getChildren(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: children){
            stringBuilder.append(human);
            stringBuilder.append("\n\n");
        }
        return stringBuilder;
    }

    public String toString1(){
        String result;
        if(dod == null && mother == null && father == null) {
            result = "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + dob;
        }else if (dod == null && mother == null){
            result = "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + dob +
                    "\nОтец: " + father;
        }else if(dod == null && father == null){
            result = "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + dob + "\nМать: " + mother;
        }else if (mother == null && father == null){
            result = "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + dob + ", Дата сметри: " + dod;
        } else {
            result = "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + dob + ", Дата сметри: " + dod +
                    "\nМать: " + mother + "\nОтец: " + father;
        }
        return result;
    }
    @Override
    public String toString() {
        return toString1();
    }
}
