package family_tree;

import family_tree.model.*;
import family_tree.presenter.FamilyTreePresenter;
import family_tree.view.ConsoleFamilyTreeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeModel model = new FamilyTreeModel();
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view);
        TextTreeReaderWriter readerWriter = new TextTreeReaderWriter();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Показать неотсортированный список членов семьи");
            System.out.println("2. Выполнить сортировку по имени");
            System.out.println("3. Выполнить сортировку по дате рождения");
            System.out.println("4. Найти человека по имени");
            System.out.println("5. Добавить нового человека");
            System.out.println("6. Сохранить дерево в файл");
            System.out.println("7. Загрузить дерево из файла");
            System.out.println("0. Выйти из программы");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера ввода

            switch (choice) {
                case 1:
                    presenter.onDisplayUnsortedTree();
                    break;
                case 2:
                    presenter.onSortByName();
                    break;
                case 3:
                    presenter.onSortByBirthDate();
                    break;
                case 4:
                    System.out.print("Введите имя для поиска: ");
                    String name = scanner.nextLine(); // Считываем имя ввода
                    presenter.onSearch(name);
                    break;
                case 5:
                    System.out.print("Введите имя нового человека: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите пол нового человека: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Введите дату рождения нового человека в формате день-месяц-год: ");
                    String newBirthDate = scanner.nextLine();
                    System.out.print("Введите дату смерти нового человека в формате день-месяц-год (оставьте пустым если нет информации): ");
                    String newDeathDate = scanner.nextLine();
                    Human newPerson = new Human(newName, newGender, newBirthDate, newDeathDate);
                    System.out.print("Введите имена родителей через запятую (если есть): ");
                    String parentsInput = scanner.nextLine();
                    if (!parentsInput.isEmpty()) {
                        String[] parentNames = parentsInput.split(",");
                        for (String parentName : parentNames) {
                            Human parent = model.findBeing(parentName.trim());
                            if (parent != null) {
                                parent.addChild(newPerson);
                                newPerson.addParent(parent);
                            } else {
                                System.out.println("Человек с именем " + parentName + " не найден.");
                            }
                        }
                    }
                    System.out.print("Введите имена детей через запятую (если есть): ");
                    String childrenInput = scanner.nextLine();
                    if (!childrenInput.isEmpty()) {
                        String[] childrenNames = childrenInput.split(",");
                        for (String childName : childrenNames) {
                            Human child = model.findBeing(childName.trim());
                            if (child != null) {
                                newPerson.addChild(child);
                                child.addParent(newPerson);
                            } else {
                                System.out.println("Человек с именем " + childName + " не найден.");
                            }
                        }
                    }
                    model.addBeing(newPerson);
                    break;
                case 6:
                    System.out.print("Введите имя файла для сохранения: ");
                    String saveFileName = scanner.nextLine();
                    readerWriter.saveTreeToFile(model, saveFileName);
                    break;
                case 7:
                    System.out.print("Введите имя файла для загрузки: ");
                    String loadFileName = scanner.nextLine();
                    FamilyTreeModel loadedModel = readerWriter.loadTreeFromFile(loadFileName);
                    if (loadedModel != null) {
                        model = loadedModel; // Заменяем текущую модель загруженной моделью
                        presenter = new FamilyTreePresenter(model, view); // Обновляем презентер с новой моделью
                        System.out.println("Данные успешно загружены из файла.");
                    } else {
                        System.out.println("Ошибка при загрузке данных из файла.");
                    }
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
        } while (choice != 0);
    }
}
