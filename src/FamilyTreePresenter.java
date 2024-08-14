import java.util.List;

public class FamilyTreePresenter {
    private final FamilyTreeModel<Human> model; // Ссылка на модель семейного дерева
    private final FamilyTreeView view; // Ссылка на представление

    public FamilyTreePresenter(FamilyTreeModel<Human> model, FamilyTreeView view) {
        this.model = model; // Инициализация модели
        this.view = view; // Инициализация представления
    }


    // Метод для добавления человека в модель
    public void addHuman(Human human) {
        if (model.addHuman(human)) {
            view.showMessage("Человек успешно добавлен: " + human.getName()); // Уведомление об успешном добавлении
        } else {
            view.showMessage("Не удалось добавить человека."); // Сообщение об ошибке
        }
    }

    // Метод для отображения всех людей в дереве
    public void showAllHumans() {
        List<Human> humans = model.getAllHumans(); // Получаем список людей из модели
        view.displayHumans(humans); // Отправляем список на отображение в представление
    }

    // Метод для сохранения дерева
    public void saveTree() {
        model.saveTree(); // Сохраняем дерево через модель
        view.showMessage("Дерево успешно сохранено."); // Уведомляем пользователя
    }

    // Сортировка по имени
    public void sortByName() {
        List<Human> humans = model.getAllHumans(); // Получаем людей
        humans.sort(new FamilyTreeComparatorByName<>()); // Сортируем по имени
        view.displayHumans(humans); // Отправляем список в представление
    }

    // Сортировка по дате рождения
    public void sortByBirthDate() {
        List<Human> humans = model.getAllHumans(); // Получаем людей
        humans.sort(new FamilyTreeComparatorByBirthDate<>()); // Сортируем по дате рождения
        view.displayHumans(humans); // Отправляем список в представление
    }


}