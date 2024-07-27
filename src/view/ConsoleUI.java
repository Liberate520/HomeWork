package view;

import model.builder.FamilyType;
import model.builder.Gender;
import model.builder.Human;
import model.family_tree.FamilyTree;
import presenter.Presenter;
import view.menu.*;
import view.menu.Menu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleUI implements View {
    private final Presenter presenter;
    private final Scanner scanner;
    private final MenuHuman menuHuman;
    private final MenuCreateFirstHuman menuCreateFirstHuman;
    private final MenuFirstHuman menuFirstHuman;

    public ConsoleUI() {
        scanner = ScannerSingleton.getInstance();
        presenter = new Presenter();
        menuCreateFirstHuman = new MenuCreateFirstHuman(this);
        menuFirstHuman = new MenuFirstHuman(this);
        menuHuman = new MenuHuman(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        while (true) {
            if (presenter.getFamilyTreeSize() == 0) {
                showMenuCreateFirstHuman();
            } else if (presenter.getFamilyTreeSize() == 1) {
                showMenuFirstHuman();
            } else {
                showMenu();
            }
        }
    }

    public void createHuman() throws IOException {
        String name = setName();
        LocalDate birthDate = setBirthDate();
        Gender gender = setGender();
        LocalDate deathDate = setDeathDate();

        Human human = presenter.createHuman(name, gender, birthDate, deathDate);
        presenter.addHumanToFamilyTree(human);
        showMessage("Создан новый человек: " + name + "\n");
    }

    private void showMenuCreateFirstHuman() throws IOException, ClassNotFoundException {
        showMenu(menuCreateFirstHuman);
    }

    private void showMenuFirstHuman() throws IOException, ClassNotFoundException {
        showMenu(menuFirstHuman);
    }

    private void showMenu() throws IOException, ClassNotFoundException {
        showMenu(menuHuman);
    }

    private void showMenu(Menu menu) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println(menu.showMenu());
            String choiceStr = scanner.nextLine();

            if (presenter.validateNumericChoice(choiceStr, 1, menu.size())) {
                int choice = Integer.parseInt(choiceStr);
                menu.execute(choice);
                return;
            } else {
                showMessage(presenter.getNumericChoiceErrorMessage());
            }
        }
    }

    public void setFamilyRelations() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Выберите человека для установления родственной связи (или 0 для выхода):");
            List<Human> people = presenter.getAllHumans();

            displayListHuman(people);
            int humanIndex = getChoice(people.size());
            if (humanIndex == -1) {
                return;
            }

            Human person = people.get(humanIndex);
            List<Human> potentialSpouses = presenter.getPotentialSpouses(person);
            List<Human> potentialChildren = presenter.getPotentialChildren(person);
            EnumSet<FamilyType> missingFamily = EnumSet.noneOf(FamilyType.class);

            System.out.println("Выберите действие для " + person.getName() + ":");

            if (person.getMother() == null && hasPotentialMother(person)) {
                missingFamily.add(FamilyType.MOTHER);
            }
            if (person.getFather() == null && hasPotentialFather(person)) {
                missingFamily.add(FamilyType.FATHER);
            }
            if (!potentialSpouses.isEmpty()) {
                missingFamily.add(FamilyType.SPOUSE);
            }
            if (!potentialChildren.isEmpty()) {
                missingFamily.add(FamilyType.CHILDREN);
            }

            if(!missingFamily.isEmpty()){
                MenuSelectedHuman menuSelectedHuman = new MenuSelectedHuman(this, person, missingFamily, potentialSpouses);
                System.out.println(menuSelectedHuman.showMenu());
                String actionChoice = scanner.nextLine();

                if (presenter.validateNumericChoice(actionChoice, 1, menuSelectedHuman.size())) {
                    int intActionChoice = Integer.parseInt(actionChoice);
                    menuSelectedHuman.execute(intActionChoice);
                    return;
                } else {
                    showMessage(presenter.getNumericChoiceErrorMessage());
                }
            } else {
                showMessage("Все кандидаты являются родственниками");
                return;
            }
        }
    }

    private boolean hasPotentialMother(Human person){
        List<Human> potentialMother = presenter.getPotentialParentsByGender(Gender.FEMALE, person);
        return !potentialMother.isEmpty();
    }

    private boolean hasPotentialFather(Human person){
        List<Human> potentialFather = presenter.getPotentialParentsByGender(Gender.MALE, person);
        return !potentialFather.isEmpty();
    }

    public void setMotherForPerson(Human person) {
        while (true){
            List<Human> potentialMother = presenter.getPotentialParentsByGender(Gender.FEMALE, person);
            showMessage("Выберите маму для " + person.getName() + " (или 0 для выхода):");

            displayListHuman(potentialMother);
            int parentIndex = getChoice(potentialMother.size());
            if (parentIndex == -1) {
                return;
            }

            Human parent = potentialMother.get(parentIndex);
            presenter.addParent(person, parent);
            showMessage("Добавлена мама: " + parent.getName() + " для " + person.getName());
            return;
        }
    }

    public void setFatherForPerson(Human person) {
        while (true){
            List<Human> potentialFather = presenter.getPotentialParentsByGender(Gender.MALE, person);
            showMessage("Выберите папу для " + person.getName() + " (или 0 для выхода):");

            displayListHuman(potentialFather);
            int parentIndex = getChoice(potentialFather.size());
            if (parentIndex == -1) {
                return;
            }

            Human parent = potentialFather.get(parentIndex);
            presenter.addParent(person, parent);
            showMessage("Добавлен отец: " + parent.getName() + " для " + person.getName());
            return;
        }
    }

    public void setChildrenForPerson(Human human) {
        while (true) {
            System.out.println("Выберите ребёнка для " + human.getName() + " (или 0 для выхода):");
            List<Human> potentialChildren = presenter.getPotentialChildren(human);

            displayListHuman(potentialChildren);
            int childIndex = getChoice(potentialChildren.size());
            if (childIndex == -1) {
                return;
            }

            Human child = potentialChildren.get(childIndex);
            presenter.addChild(human, child);
            showMessage("Добавлен ребёнок: " + child.getName() + " к родителю: " + human.getName());
            return;
        }
    }

    private int getChoice(int maxOption) {
        while (true) {
            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                return -1;
            }

            if (presenter.validateNumericChoice(choice, 1, maxOption)) {
                return Integer.parseInt(choice) - 1;
            } else {
                showMessage(presenter.getNumericChoiceErrorMessage());
                return -1;
            }
        }
    }

    private void displayListHuman(List<Human> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " - " + list.get(i).getName());
        }
        System.out.println("0 - Выход");
    }

    private List<Human> getAllHumanNotCurrent(Human person) {
        List<Human> allPeople = presenter.getAllHumans();
        return allPeople.stream()
                .filter(p -> !p.equals(person))
                .collect(Collectors.toList());
    }

    private Set<Gender> getTypeOfGenders(List<Human> humans) {
        return humans.stream()
                .map(Human::getGender)
                .collect(Collectors.toSet());
    }

    public void setSpouseForPerson(Human person, List<Human> potentialSpouses) {
        while (true) {
            System.out.println("Выберите супруга(у) для " + person.getName() + " (или 0 для выхода):");
            displayListHuman(potentialSpouses);
            int spouseIndex = getChoice(potentialSpouses.size());
            if (spouseIndex == -1) {
                return;
            }

            Human spouse = potentialSpouses.get(spouseIndex);
            presenter.setWedding(person, spouse);
            showMessage(person.getName() + " и " + spouse.getName() + " теперь женаты.");
            return;
        }
    }

    public void showAllPeople() {
        List<Human> people = presenter.getAllHumans();
        for (Human person : people) {
            System.out.println(person.getInfo());
        }
        System.out.println("\n");
    }

    public String setName() {
        boolean valid = false;
        String name = "";
        while (!valid) {
            System.out.print("Введите Имя: ");
            name = scanner.nextLine();
            if (presenter.validateName(name)) {
                valid = true;
            } else {
                showMessage(presenter.getNameErrorMessage());
            }
        }
        return name;
    }

    public LocalDate setBirthDate() {
        boolean valid = false;
        LocalDate birthDate = null;
        while (!valid) {
            System.out.print("Введите Дату Рождения (YYYY-MM-DD): ");
            String birthDateStr = scanner.nextLine();
            if (presenter.validateBirthDate(birthDateStr)) {
                birthDate = presenter.getValidatedBirthDate();
                valid = true;
            } else {
                showMessage(presenter.getBirthDateErrorMessage());
            }
        }
        return birthDate;
    }

    public Gender setGender() {
        boolean valid = false;
        Gender gender = null;
        while (!valid) {
            System.out.println("Выберите пол:");
            System.out.println("1 - Мужчина");
            System.out.println("2 - Женщина");

            String genderChoice = scanner.nextLine();
            if (presenter.validateNumericChoice(genderChoice, 1, 2)) {
                int genderOption = Integer.parseInt(genderChoice);
                if (presenter.validateGender(genderOption)) {
                    gender = presenter.getValidatedGender(genderOption);
                    valid = true;
                } else {
                    showMessage("Неверный выбор пола. Попробуйте снова.");
                }
            } else {
                showMessage(presenter.getNumericChoiceErrorMessage());
            }
        }
        return gender;
    }

    public LocalDate setDeathDate() {
        boolean valid = false;
        LocalDate deathDate = null;
        while (!valid) {
            System.out.println("Хотите указать дату смерти?");
            System.out.println("1 - Да");
            System.out.println("2 - Нет");

            String choice = scanner.nextLine();
            if (presenter.validateNumericChoice(choice, 1, 2)) {
                int option = Integer.parseInt(choice);
                if (option == 1) {
                    boolean deathDateValid = false;
                    while (!deathDateValid) {
                        System.out.print("Введите Дату Смерти (YYYY-MM-DD): ");
                        String deathDateStr = scanner.nextLine();
                        if (presenter.validateDeathDate(deathDateStr)) {
                            deathDate = presenter.getValidatedDeathDate();
                            deathDateValid = true;
                        } else {
                            showMessage(presenter.getDeathDateErrorMessage());
                        }
                    }
                    valid = true;
                } else if (option == 2) {
                    valid = true;
                }
            } else {
                showMessage(presenter.getNumericChoiceErrorMessage());
            }
        }
        return deathDate;
    }

    public void saveFamilyTree() {
        boolean savedSuccessfully = presenter.saveFamilyTree();
        if (savedSuccessfully) {
            showMessage("Данные успешно сохранены.\n");
        } else {
            showMessage("Ошибка при сохранении данных.\n");
        }
    }

    public void displayFamilyTree() throws IOException, ClassNotFoundException {
        try {
            FamilyTree<Human> familyTree = presenter.readFamilyTree();
            showMessage("Чтение FamilyTree: " + familyTree);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Presenter getPresenter(){
        return presenter;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
