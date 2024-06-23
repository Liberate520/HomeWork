import models.Human;
import models.Gender;
import presenters.Presenter;
import views.ConsoleView;
import views.View;

public class Main {
    public static void main(String[] args) {
        // Создание объектов класса Human
        Human ioann = new Human("Иоанн Алексеевич Романов", "06.09.1666", "08.02.1696", Gender.MALE);
        Human alexey = new Human("Алексей Михайлович Романов", "19.03.1629", "8.02.1676", Gender.MALE);
        Human maria = new Human("Мария Ильинична Милославская", "11.04.1624", "13.03.1669", Gender.FEMALE);
        Human dmitry = new Human("Дмитрий Алексеевич Романов", "01.11.1648", "16.10.1649", Gender.MALE);
        Human evdokia = new Human("Евдокия Алексеевна Романова", "17.02.1650", "10.05.1712", Gender.FEMALE);
        Human praskovya = new Human("Прасковья Фёдоровна Салтыкова", "22.10.1664", "24.10.1723", Gender.FEMALE);
        Human mariaIvanovna = new Human("Мария Ивановна Романова", "31.03.1689", "23.02.1692", Gender.FEMALE);
        Human feodosia = new Human("Феодосия Ивановна Романова", "14.06.1690", "22.05.1691", Gender.FEMALE);
        Human ekaterina = new Human("Екатерина Иоанновна Романова", "8.11.1691", "25.06.1733", Gender.FEMALE);
        Human anna = new Human("Анна Иоанновна Романова", "07.02.1693", "28.10.1740", Gender.FEMALE);
        Human praskovyaIoannovna = new Human("Прасковья Иоанновна Романова", "04.10.1694", "19.10.1731", Gender.FEMALE);

        // Создание объекта класса Presenter
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);

        // Добавление объектов в генеалогическое древо
        presenter.addHuman(ioann);
        presenter.addHuman(alexey);
        presenter.addHuman(maria);
        presenter.addHuman(dmitry);
        presenter.addHuman(evdokia);
        presenter.addHuman(praskovya);
        presenter.addHuman(mariaIvanovna);
        presenter.addHuman(feodosia);
        presenter.addHuman(ekaterina);
        presenter.addHuman(anna);
        presenter.addHuman(praskovyaIoannovna);

        // Установка родственных связей
        ioann.setMother(maria);
        ioann.setFather(alexey);
        dmitry.setMother(maria);
        dmitry.setFather(alexey);
        evdokia.setMother(maria);
        evdokia.setFather(alexey);
        mariaIvanovna.setMother(praskovya);
        mariaIvanovna.setFather(ioann);
        feodosia.setMother(praskovya);
        feodosia.setFather(ioann);
        ekaterina.setMother(praskovya);
        ekaterina.setFather(ioann);
        anna.setMother(praskovya);
        anna.setFather(ioann);
        praskovyaIoannovna.setMother(praskovya);
        praskovyaIoannovna.setFather(ioann);

        // Вывод неотсортированных данных
        presenter.displayFamilyTree();

        // Вывод сортированных данных по имени
        presenter.sortByName();

        // Вывод сортированных данных по дате рождения
        presenter.sortByBirthDate();

        // Сохранение данных в файл
        presenter.saveToFile("family_tree.txt");

        // Чтение данных из файла
        presenter.loadFromFile("family_tree.txt");
    }
}