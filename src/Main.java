import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Полина", "Пиантковская", LocalDate.of(1914, 12, 31), Gender.Female);
        //Human human = new Human("Полина", "Пиантковская", LocalDate.of(1914, 12, 31), Gender.Female);
        //Human human;
        //human.setName("Имя");
        //human.setSname("Фамилия");


        System.out.println(human.getDateOfBirth().toString());
        // Почему-то ошибка... н еразобрался что не так
        /*
        if(human.setDateOfDeath(LocalDate.of(1992, 1, 15))){
            System.out.println(human.getDateOfDeath().toString());

        }else{System.out.println("Дата рождения должна быть раньше смерти");}
        */
        //
    }
}