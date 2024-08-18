package my_fam_tree.presenter;

import my_fam_tree.model.FamilyTree;
import my_fam_tree.model.Human;
import my_fam_tree.treeService.Plant;
import my_fam_tree.treeService.FileHandler;
import my_fam_tree.view.FamTreeView;

import java.time.LocalDate;



public class FamTreePres {
    private FamilyTree<Human> model;
    private FamTreeView view;
    private Plant plant;
    private FileHandler fileHand;
    public FamTreePres(FamilyTree<Human> model, FamTreeView view) {
        this.model = model;
        this.view = view;
        this.plant = new Plant(model);
        this.fileHand = new FileHandler();
    }

    public void run() {
        while (true) {
            view.menu();
            int choice = view.menuChoice();

            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    findHuman();
                    break;
                case 3:
                    showRelatives();
                    break;
                case 4:
                    model.sortName();
                    view.screenMess("Отсортировано по имени");
                    break;
                case 5:
                    model.sortBirthDate();
                    view.screenMess("Отсортировано по дате рождения");
                    break;
                case 6:
                    saveFile();
                    break;
                case 7:
                    loadFile();
                    break;
                case 0:
                    return;
                default:
                    view.screenMess("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    private void addHuman() {
        String name = view.getInput("Введите имя: ");
        String genderInput = view.getInput("Введите пол (М/Ж): ");
        String gender = genderInput.trim().equalsIgnoreCase("М") ? "Мужской" : "Женский";
        String birthDateInput = view.getInput("Введите дату рождения (ГГГГ-ММ-ДД): ");
        LocalDate birthDate = LocalDate.parse(birthDateInput);

        Human human = new Human(name, gender, birthDate);
        model.addRelative(human);
        view.screenMess("Человек добавлен в семейное дерево.");
    }

    private void findHuman() {
        String name = view.getInput("Введите имя для поиска: ");
        Human human = model.findHuman(name);
        if (human != null) {
            view.screenMess("Найдено:");
            view.screenHuman(human);
        } else {
            view.screenMess("Человек не найден.");
        }
    }

    private void showRelatives() {
        view.screenMess("Все члены семьи:");
        view.screenHumanList(model.getRelatives());
    }

    private void saveFile() {
        String fileName = view.getInput("Введите имя файла для сохранения: ");
        try {
            fileHand.saveToFile(fileName, model);
            view.screenMess("Семейное дерево сохранено в файл.");
        } catch (Exception e) {
            view.screenMess("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private void loadFile() {
        String fileName = view.getInput("Введите имя файла для загрузки: ");
        try {
            model = (FamilyTree<Human>) fileHand.loadFromFile(fileName);
            plant = new Plant(model);
            view.screenMess("Семейное дерево загружено из файла.");
        } catch (Exception e) {
            view.screenMess("Ошибка при загрузке: " + e.getMessage());
        }
    }
}


