import java.time.LocalDate;

import human.Gender;
import service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.addHuman("Иванов Алексей Васильевич", Gender.Male, LocalDate.of(1957, 6, 30));
        service.addHuman("Иванова Маргарита Степановна", Gender.Female, LocalDate.of(1958, 3, 10));
        service.addHuman("Иванова Светлана Алексеевна", Gender.Female, LocalDate.of(1992, 2, 21));
        service.addHuman("Иванов Матвей Алексеевич", Gender.Male, LocalDate.of(1993, 4, 12));

        service.setDateOfDeath(0, LocalDate.of(2000, 4, 15));

        service.setMother(2, 1);
        service.setFather(2, 0);

        service.setMother(3, 1);
        service.setFather(3, 0);

        service.setChildren(0, 2);
        service.setChildren(0, 2);
        service.setChildren(1, 3);
        service.setChildren(1, 3);

        System.out.println(service.getHumansListInfo());

        System.out.println("Сортировка по имени:");
        service.sortByName();
        System.out.println(service.getHumansListInfo());

        System.out.println("Сортировка по возрасту:");
        service.sortByAge();
        System.out.println(service.getHumansListInfo());

    }

}
