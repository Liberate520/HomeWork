import writer.DataHandler;
import human.Gender;
import service.Service;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {

    final static String filePath = "src/writer/tree.txt";
    public static void main(String[] args) {
        Service service = new Service();

        service.addHuman("Mike", Gender.MALE, LocalDate.of(1979, 5,1));
        service.addHuman("Jack", Gender.MALE, LocalDate.of(1999, 6,21), null, "Mike");
        service.addHuman("Tack", Gender.MALE, LocalDate.of(1998, 6,21), null, "Mike");
        service.addHuman("Pack", Gender.MALE, LocalDate.of(1997, 6,21), null, "Mike");
        service.addHuman("Lack", Gender.MALE, LocalDate.of(1996, 6,21), null, "Mike");
        service.addHuman("Rose", Gender.FEMALE, LocalDate.of(2000, 7,28));
        service.addHuman("Annie", Gender.FEMALE, LocalDate.of(2021, 1,8), "Rose", "Jack");
        service.setWedding("Jack", "Rose");



//        System.out.println(service);
//        service.sortByName();
//        System.out.println(service);
        service.sortByAge();
        System.out.println(service);
//        save(service);

//        Service service = (Service) load();
//        System.out.println(service.getPeopleInfo());

    }
    private static void save(Serializable serializable) {
        DataHandler dataHandler = new DataHandler();
        dataHandler.setPath(filePath);
        dataHandler.save(serializable);
    }
    private static Serializable load() {
        DataHandler dataHandler = new DataHandler();
        dataHandler.setPath(filePath);
        return (Serializable) dataHandler.read();
    }
}
