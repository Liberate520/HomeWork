package GenerationTree.View.ConsoleUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import GenerationTree.Model.Person.Structs.Gender;
import GenerationTree.Presenter.Presenter;
import GenerationTree.View.View;
import GenerationTree.View.ConsoleUI.MenuRender.ConsoleManager;

public class ConsoleUI implements View {
    private Presenter presenter;
    private ConsoleManager cmdManager;

    private ConsoleMenu menu;
    private boolean appIsRun;

    public ConsoleUI() {
        cmdManager = new ConsoleManager();
        presenter = new Presenter(this);
        appIsRun = true;
        menu = new ConsoleMenu();
    }

    @Override
    public void startup() {
        while (appIsRun) {
            clsField();
            startupMenu();
            if (appIsRun)
                treeMenu(presenter.getTreeName());
        }
    }

    @Override
    public boolean fileExist(String name) {
        if (menu.yesNoDialog("Файл семьи " + name + " уже существует. Загрузить его?")) {
            return presenter.loadTree(name);
        } else {
            return false;
        }
    }

    @Override
    public void print(String text) {
        cmdManager.PrintText(text);
        cmdManager.inputText("      Для продолжения нажмите Enter...");
        clsField();
    }

    private void clsField() {
        String header = "ПРОГРАММА: Генеалогическое древо семьи. Версия 0.000.00 pre-Alpha"
                + " ".repeat(32);
        cmdManager.consoleClear();
        cmdManager.PrintText(header);
        cmdManager.PrintText("=".repeat(header.length()));
    }

    private void startupMenu() {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put("ВЫБЕРИТЕ ДЕЙСТВИЕ",
                Arrays.asList("СОЗДАТЬ ДРЕВО", "ВЫБРАТЬ ДРЕВО", "УДАЛИТЬ ДРЕВО"));
        menuData.put("-----", Arrays.asList("ВЫХОД"));
        menu.selectedMenu(menuData, this::newTree, this::menuLoadTree, this::menuDeleteTree, this::appClose);
    }

    private boolean newTree() {
        var enteringProcess = true;
        while (enteringProcess) {
            clsField();
            String surname = cmdManager.inputText("Введите фамилию семьи: ");
            if (surname.isEmpty()) {
                continue;
            }
            clsField();
            enteringProcess = false;
            var result = this.presenter.addNewTree(surname);
            if (result)
                menu.closeMenu();
            return result;
        }
        return false;
    }

    private boolean menuLoadTree() {
        List<String> allTrees = presenter.getAllTrees();
        if (allTrees.size() == 0) {
            if (menu.yesNoDialog("Отсутствуют файлы сохранения. Создать новое древо?")) {
                return newTree();
            }
            return false;
        }
        var name = menuSavedTree(allTrees);
        if (!name.isEmpty()) {
            var result = this.presenter.loadTree(name);
            if (result)
                menu.closeMenu();
            return result;
        }
        return false;
    }

    private void menuDeleteTree() {
        List<String> allTrees = presenter.getAllTrees();
        if (allTrees.size() == 0) {
            print("Нет файлов сохранения.");
            return;
        }
        var name = menuSavedTree(allTrees);
        if (!name.isEmpty())
            if (menu.yesNoDialog("Удалить " + name + "?") && this.presenter.deleteSavedTree(name)) {
                print("Древо успешно удалено.");
            } else {
                print("Ошбика при удалении файла сохранения.");
            }
    }

    private String menuSavedTree(List<String> trees) {
        Collections.sort(trees);
        int nameIndex = menu.contentMenu(trees, "СОХРАНЕННЫЕ ДРЕВА");
        return nameIndex < 0 ? "" : trees.get(nameIndex);
    }

    @Override
    public int selectTreeMemberId(Map<Integer, String> members) {
        if (menu.yesNoDialog("Добавить родителя?")) {
            return menuTreeMembers(members);
        }
        return -1;
    }

    public int menuTreeMembers(Map<Integer, String> members) {
        var menuItems = members.values().toArray(new String[members.values().size()]);
        int itemId = menu.contentMenu(Arrays.asList(menuItems), "ЧЛЕНЫ СЕМЬИ");
        if (itemId < 0)
            return itemId;
        var selectedItem = menuItems[itemId];
        for (Integer key : members.keySet()) {
            if (members.get(key).equals(selectedItem)) {
                return key;
            }
        }
        throw new RuntimeException("Selected item not found.");
    }

    private void treeMenu(String treeName) {
        Map<String, List<String>> menuData = new LinkedHashMap<>();
        menuData.put("ДЕЙСТВИЯ С ДРЕВОМ: " + treeName, Arrays.asList("ДОБАВИТЬ ЧЛЕНА СЕМЬИ", "ПОКАЗАТЬ ЧЛЕНОВ СЕМЬИ",
                "УДАЛИТЬ ЧЛЕНА СЕМЬИ", "СОХРАНИТЬ ДРЕВО"));
        menuData.put("-----", Arrays.asList("ВЫХОД В ГЛАВНОЕ МЕНЮ"));
        menu.selectedMenu(menuData, this::menuAddMember, this::menuShowMembers,
                this::menuDeleteMember, this::saveThisTree, this::closeTreeMenu);
    }

    private boolean menuAddMember() {
        var enteringProcess = true;
        while (enteringProcess) {
            clsField();
            String name = cmdManager.inputText("Введите имя: ");
            Gender gender = menu.genderDialog();
            LocalDate birthDate = inputDate("Введите дату рождения (в формате ДД.ММ.ГГГГ): ");
            if (name.isEmpty()) {
                continue;
            }
            clsField();
            enteringProcess = false;
            presenter.addParrent(presenter.addNewFamilyMember(name, gender, birthDate));
        }
        return false;
    }

    private LocalDate inputDate(String message) {
        while (true) {
            String input = cmdManager.inputText(message);
            try {
                return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e) {
                print("Неверный формат даты. Попробуйте еще раз.");
            }
        }
    }

    private void menuShowMembers() {
        Map<Integer, String> allMembers = presenter.getMembers();
        if (allMembers.size() == 0) {
            if (menu.yesNoDialog("Нет членов семьи. Добавить первого?")) {
                menuAddMember();
            }
            return;
        }

        presenter.loadMemberById(menuTreeMembers(allMembers));
    }

    private void menuDeleteMember() {
        var memners = presenter.getMembers();
        if (memners.size() > 0) {
            int id = menuTreeMembers(memners);
            if (menu.yesNoDialog("Удалить выбранного члена семьи?"))
                presenter.delЕreeItem(id);
        } else {
            print("Нет членов семьи.");
        }
    }

    private boolean saveThisTree() {
        return presenter.saveTree();
    }

    private void closeTreeMenu() {
        if (!presenter.getSavedState()) {
            int taskIndex = menu.yesNoCancelDialog("Имеются несохраненные изменения. Сохранить?");
            switch (taskIndex) {
                case 1:
                    presenter.saveTree();
                case 2:
                    menu.closeMenu();
                    break;
                default:
                    break;
            }
        } else {
            menu.closeMenu();
        }

    }

    private void appClose() {
        if (menu.yesNoDialog("Завершить работу приложения?")) {
            appIsRun = false;
            menu.closeMenu();
            cmdManager.consoleClear();
            cmdManager.PrintText("Приложение завершило работу.");
        }
    }
}
