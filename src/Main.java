import models.Gender;
import models.Human;
import presenters.Presenter;
import services.FamilyTreeService;
import views.ConsoleView;
import views.View;

/**
 * Класс Main является точкой входа в приложение для работы с генеалогическим древом.
 */
public class Main {
    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создание объектов представления, сервиса и презентера
        View view = new ConsoleView();
        FamilyTreeService familyTreeService = new FamilyTreeService();
        Presenter presenter = new Presenter(view, familyTreeService);

        // Добавление людей в генеалогическое древо
        presenter.addHuman(new Human("Иоанн Алексеевич Романов", "06.09.1666", "08.02.1696", Gender.MALE));
        presenter.addHuman(new Human("Алексей Михайлович Романов", "19.03.1629", "8.02.1676", Gender.MALE));
        presenter.addHuman(new Human("Мария Ильинична Милославская", "11.04.1624", "13.03.1669", Gender.FEMALE));
        presenter.addHuman(new Human("Дмитрий Алексеевич Романов", "01.11.1648", "16.10.1649", Gender.MALE));
        presenter.addHuman(new Human("Евдокия Алексеевна Романова", "17.02.1650", "10.05.1712", Gender.FEMALE));
        presenter.addHuman(new Human("Прасковья Фёдоровна Салтыкова", "22.10.1664", "24.10.1723", Gender.FEMALE));
        presenter.addHuman(new Human("Мария Ивановна Романова", "31.03.1689", "23.02.1692", Gender.FEMALE));
        presenter.addHuman(new Human("Феодосия Ивановна Романова", "14.06.1690", "22.05.1691", Gender.FEMALE));
        presenter.addHuman(new Human("Екатерина Иоанновна Романова", "8.11.1691", "25.06.1733", Gender.FEMALE));
        presenter.addHuman(new Human("Анна Иоанновна Романова", "07.02.1693", "28.10.1740", Gender.FEMALE));
        presenter.addHuman(new Human("Прасковья Иоанновна Романова", "04.10.1694", "19.10.1731", Gender.FEMALE));

        // Вывод неотсортированных данных
        presenter.displayFamilyTree();

        // Вывод сортированных данных по имени
        presenter.sortByName();

        // Вывод сортированных данных по дате рождения
        presenter.sortByBirthDate();

        // Сохранение данных в файл
        presenter.saveToFile("family_tree.txt");

        // Загрузка данных из файла
        presenter.loadFromFile("family_tree.txt");
    }
}