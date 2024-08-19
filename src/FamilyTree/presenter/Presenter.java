package FamilyTree.presenter;

import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.familyTree.Gender;
import FamilyTree.model.human.Human;
import FamilyTree.model.service.Service;
import FamilyTree.model.utility.FileHandler;
import FamilyTree.view.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Presenter implements PresenterInterface, Serializable {
    private View view;
    private Service service;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;
    private Scanner scanner;

    public Presenter(View view) {
        this.view = view;
        this.fileHandler = new FileHandler();
        this.familyTree = new FamilyTree<>();
        this.service = new Service(familyTree);
        this.scanner = new Scanner(System.in);
    }

    public void initializeFamilyTree() {
        System.out.println("Загружаем семейное дерево...");
        FamilyTree<Human> loadedFamilyTree = fileHandler.load();
        if (loadedFamilyTree != null) {
            this.familyTree = loadedFamilyTree;
            this.service = new Service(loadedFamilyTree);
            System.out.println("Семейное дерево загружено успешно.");
        } else {
            System.out.println("Файл с семейным древом не найден. Начинаем с пустого древа.");
            this.familyTree = new FamilyTree<>();
            this.service = new Service(familyTree);
        }
    }

    public void saveAndExit() {
        System.out.println("Сохраняем семейное дерево...");
        fileHandler.save(familyTree);
        System.out.println("Семейное дерево сохранено. Завершение программы.");
    }

    public void addInitialFamilyMembers() {
        // Добавим членов семьи в семейное дерево
        // Создаем старших членов семьи
        addHuman("Иван", LocalDate.of(1952, 6, 1), getGenderMale(), "Инженер", "Русский", "Херсон", null, null);
        Human grandFather = getLastAddedHuman();
        addHuman("Надежда", LocalDate.of(1952, 2, 17), getGenderFemale(), "Учитель", "Украинка", "Херсон", null, null);
        Human grandMother = getLastAddedHuman();

        addHuman("Виктор", LocalDate.of(1961, 7, 19), getGenderMale(), "Инженер", "Русский", "Херсон", null, null);
        Human grandFather1 = getLastAddedHuman();
        addHuman("Людмила", LocalDate.of(1960, 4, 26), getGenderFemale(), "Учитель", "Украинка", "Херсон", null, null);
        Human grandMother1 = getLastAddedHuman();

        // Создаем родителей
        addHuman("Иван", LocalDate.of(1981, 5, 1), getGenderMale(), "Инженер", "Русский", "Херсон", grandFather, grandMother);
        Human father = getLastAddedHuman();
        addHuman("Наталья", LocalDate.of(1983, 6, 12), getGenderFemale(), "Доктор", "Украинка", "Херсон", grandFather1, grandMother1);
        Human mother = getLastAddedHuman();

        // Устанавливаем супругов
        grandFather.setSpouse(grandMother);
        grandMother.setSpouse(grandFather);

        grandFather1.setSpouse(grandMother1);
        grandMother1.setSpouse(grandFather1);

        father.setSpouse(mother);
        mother.setSpouse(father);

        addHuman("Анастасия", LocalDate.of(2009, 4, 26), getGenderFemale(), "Ученица", "Русская", "Херсон", father, mother);
        Human child1 = getLastAddedHuman();

        addHuman("Иван", LocalDate.of(2024, 5, 1), getGenderMale(), null, "Русский", "Сургут", father, mother);
        Human child2 = getLastAddedHuman();

        addHuman("Виктор", LocalDate.of(2024, 5, 1), getGenderMale(), null, "Русский", "Сургут", father, mother);
        Human child3 = getLastAddedHuman();
    }

    public void deleteHuman() {
        System.out.println("Введите имя или часть имени члена семьи, которого вы хотите удалить:");
        String namePart = scanner.nextLine().trim().toLowerCase();

        // Найдем всех людей, чьи имена содержат введенную часть имени
        List<Human> matchingMembers = findMembersByNamePartIgnoreCase(namePart);

        if (matchingMembers.isEmpty()) {
            System.out.println("Члены семьи с таким именем не найдены.");
            return;
        }

        // Выводим список совпадений
        System.out.println("Найдено следующие члены семьи:");
        for (int i = 0; i < matchingMembers.size(); i++) {
            Human member = matchingMembers.get(i);
            System.out.println((i + 1) + ". " + member.getName() + " (ID: " + member.getId() + ")");
        }

        System.out.println("Введите номер члена семьи, которого вы хотите удалить:");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        if (choice < 1 || choice > matchingMembers.size()) {
            System.out.println("Неверный выбор. Попробуйте снова.");
            return;
        }

        Human humanToDelete = matchingMembers.get(choice - 1);

        // Удаляем выбранного члена семьи
        boolean deletionSuccess = service.deleteHuman(humanToDelete);

        if (deletionSuccess) {
            System.out.println("Член семьи " + humanToDelete.getName() + " успешно удален.");
        } else {
            System.out.println("Не удалось удалить члена семьи " + humanToDelete.getName() + ".");
        }
    }

    private List<Human> findMembersByNamePartIgnoreCase(String namePart) {
        List<Human> matchingMembers = new ArrayList<>();
        for (Human member : familyTree.getMembers()) {
            if (member.getName().toLowerCase().contains(namePart)) {
                matchingMembers.add(member);
            }
        }
        return matchingMembers;
    }

    @Override
    public void saveFamilyTree() {
        if (familyTree == null || service == null) {
            throw new IllegalStateException("Семейное древо или служба не инициализированы");
        }
        System.out.println("Сохраняем семейное дерево в файл...");
        service.saveFamilyTree();
        System.out.println("Семейное дерево успешно сохранено!");
//        this.familyTree = familyTree;
    }

    @Override
    public void loadFamilyTree() {
        if (familyTree == null || service == null) {
            throw new IllegalStateException("Семейное древо или служба не инициализированы");
        }
        System.out.println("Загружаем семейное дерево из файла...");
        FamilyTree<Human> loadedFamilyTree = service.loadFamilyTree();
        if (loadedFamilyTree != null && !loadedFamilyTree.getMembers().isEmpty()) {
            System.out.println("Семейное дерево успешно загружено!");
            this.familyTree = loadedFamilyTree;
            this.service = new Service(loadedFamilyTree);
        } else {
            System.out.println("Файл не найден или пуст. Создано новое семейное дерево.");
            this.familyTree = new FamilyTree<>();
            this.service = new Service(familyTree);
            saveFamilyTree(); // Сохраняем пустое дерево, чтобы файл был создан
        }
//        updateServiceFamilyTree(loadedFamilyTree);
//        return loadedFamilyTree;
    }

//    public void updateServiceFamilyTree(FamilyTree<Human> familyTree) {
//        service.familyTree = familyTree;
//    }

    public boolean isFamilyTreeEmpty() {
        return familyTree.getMembers().isEmpty();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
        this.service = new Service(familyTree);
    }

    public List<Human> getExistingFathers() {
        List<Human> existingFathers = new ArrayList<>();
        for (Human member : familyTree.getMembers()) {
            if (member.getGender() != null) {
                if (member.getGender() != null && member.getGender() == Gender.Male && member.getAge() > 12) {
                    existingFathers.add(member);
                }
            }
        }
        return existingFathers;
    }

    public List<Human> getExistingMothers() {
        List<Human> existingMothers = new ArrayList<>();
        for (Human member : familyTree.getMembers()) {
            if (member.getGender() != null) {
                if (member.getGender() != null && member.getGender() == Gender.Female && member.getAge() > 12) {
                    existingMothers.add(member);
                }
            }
        }
        return existingMothers;
    }

    public Human chooseFather() {
        // Выбираем отца
        System.out.println("Выберите отца из списка:");
        System.out.println("1. Выбрать из существующих записей дерева");
        System.out.println("2. Создайте отца в семейном дереве, если еще не сохранили");
        int choice = Integer.parseInt(scanner.nextLine());
        Human father = null;
        if (choice == 1) {
            // Получим список существующих отцов из дерева
            List<Human> existingFathers = getExistingFathers();
            System.out.println("Выберите отца из списка:");
            for (int i = 0; i < existingFathers.size(); i++) {
                System.out.println((i + 1) + ". " + existingFathers.get(i));
            }
            if (!existingFathers.isEmpty()) {
                int fatherIndex = Integer.parseInt(scanner.nextLine()) - 1;
                father = existingFathers.get(fatherIndex);
            } else {
                System.out.println("Не найдено подходящих записей");
                chooseFather();
            }
        } else {
            System.out.println("Добавьте сначала отца!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            view.start();
        }
        return father;
    }

    public Human chooseMother() {
        // Выбираем мать
        System.out.println("Выберите мать:");
        System.out.println("1. Выбрать из существующих записей дерева");
        System.out.println("2. Создайте мать в семейном дереве, если еще не сохранили");
        int choice = Integer.parseInt(scanner.nextLine());
        choice = Integer.parseInt(scanner.nextLine());
        Human mother = null;
        if (choice == 1) {
            // Получим список существующих матерей из дерева
            List<Human> existingMothers = getExistingMothers();
            System.out.println("Выберите мать из списка:");
            for (int i = 0; i < existingMothers.size(); i++) {
                System.out.println((i + 1) + ". " + existingMothers.get(i));
            }
            if (!existingMothers.isEmpty()) {
                int motherIndex = Integer.parseInt(scanner.nextLine()) - 1;
                mother = existingMothers.get(motherIndex);
            } else {
                System.out.println("Не найдено подходящих записей");
                chooseMother();
            }
        } else {
            System.out.println("Добавьте сначала мать!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            view.start();
        }
        return mother;
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        if (familyTree == null || service == null) {
            throw new IllegalStateException("Семейное древо или служба не инициализированы");
        }
//        System.out.println("Pres_aH_familyTree: " + familyTree);
//        System.out.println("Pres_aH_name: " + name);
//        System.out.println("Pres_aH_birthDate: " + birthDate);
//        System.out.println("Pres_aH_gender: " + gender);
        service.addHuman(name, birthDate, gender);
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        if (familyTree == null || service == null) {
            throw new IllegalStateException("Семейное древо или служба не инициализированы");
        }
        service.addHuman(name, birthDate, gender, father, mother);
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender, String occupation,
                         String nationality, String placeOfBirth, Human father, Human mother) {
        if (familyTree == null || service == null) {
            throw new IllegalStateException("Семейное древо или служба не инициализированы");
        }
        service.addHuman(name, birthDate, gender, occupation, nationality, placeOfBirth, father, mother);
    }

    public Human getLastAddedHuman() {
        return service.getLastAddedHuman();
    }

    public void printFamilyTreeInfo() {
        StringBuilder answer = service.printFamilyTreeInfo();

//        System.out.println("Ответ, который будет отправлен в view.printAnswer:");
//        System.out.println(answer.toString());  // Печать строки на консоль

        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public Gender getGenderMale() {
        return service.getMaleGender();
    }

    public Gender getGenderFemale() {
        return service.getFemaleGender();
    }

    public Gender chooseGender() {
        System.out.println("Укажите пол:");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
        String choice = scanner.nextLine();
        try {
            int genderChoice = Integer.parseInt(choice);
            return service.chooseGender(genderChoice);
        } catch (NumberFormatException e) {
            System.out.println("Неверно введено значение. Попробуйте снова");
            return chooseGender();
        }
    }

//    public Gender chooseGender() {
//        Gender gender;
//        while (true) {
//            System.out.println("Укажите пол:");
//            System.out.println("1. Мужской");
//            System.out.println("2. Женский");
//            String choice = scanner.nextLine();
//            switch (choice) {
//                case "1":
//                    gender = Gender.Male;
//                    break;
//                case "2":
//                    gender = Gender.Female;
//                    break;
//                default:
//                    System.out.println("Неверно введено значение. Попробуйте снова");
//                    continue;
//            }
//            break;
//        }
//        return gender;
//    }

    public Human getMemberByName(String name) {
        return service.getMemberByName(name);
    }

    public void getFTChildrenOfMember(long id) {
        Human human = familyTree.getMemberById(id);
        familyTree.printChildren(human);
    }
}
