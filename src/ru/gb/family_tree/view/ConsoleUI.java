package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.presenter.Presenter;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        clearConsole();
        userHourHi();
        delayAnyMs(1500);
        clearConsole();
        caseMain();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    //---------Главный кейс-----------
    private void caseMain() {
       while (work){
           menuMain();
           String choice;
           choice = scanner.nextLine();
           switch (choice) {
               case "1": // Работа с элементами
                   clearConsole();
                   case_Main_1_RedactElem();
                   break;
               case "2": // Работа с  деревом
                   clearConsole();
                   case_Main_2_TreeWork();
                   break;
               case "3": // Загрузить дерево
                   clearConsole();
                   loadTree();
                   break;
               case "4": // Сохранить дерево
                   clearConsole();
                   saveTree();
                   break;
               case "5": // Посмотреть текущее древо
                   clearConsole();
                   showCurrentTree();
                   caseMain();
                   break;
               case "6": // Завершить работу
                   clearConsole();
                   userHourBye();
                   delayAnyMs(1500);
                   clearConsole();
                   exit();
                   break;
               default: // Ошибка ввода, повтор кейса
                   clearConsole();
                   wrongInput();
                   caseMain();
           }
       }
    }

    private void menuMain() {
        System.out.println("Выберите раздел:");
        System.out.println("1. Работа с элементами");
        System.out.println("2. Работа с  деревом");
        System.out.println("3. Загрузить дерево");
        System.out.println("4. Сохранить дерево");
        System.out.println("5. Посмотреть текущее древо");
        System.out.println("6. Завершить работу");
    }

    //--------Вложенные кейсы----------------
    private void case_Main_1_RedactElem() {
        menu_Main_1_RedactElem();
        String choice;
        choice = scanner.nextLine();
        switch (choice) {
            case "1": // Создать элемент
                clearConsole();
                createNewElement();
                case_Main_1_RedactElem();
                break;
            case "2": // Найти элемент
                clearConsole();
                findElement();
                case_Main_1_RedactElem();
                break;
            case "3": // Удалить элемент
                clearConsole();
                deleteElement();
                case_Main_1_RedactElem();
            case "4": // Дополнить элемент
                clearConsole();
                addNewInfoAboutElement();
                case_Main_1_RedactElem();
            case "5": // Посмотреть текущее древо
                clearConsole();
                showCurrentTree();
                case_Main_1_RedactElem();
            case "6": // Назад
                clearConsole();
                caseMain();
                break;
            default:
                clearConsole();
                wrongInput();
                case_Main_1_RedactElem();
        }
    }

    private void menu_Main_1_RedactElem() {
        System.out.println("Выберите команду:");
        System.out.println("1. Создать элемент");
        System.out.println("2. Найти элемент");
        System.out.println("3. Удалить элемент");
        System.out.println("4. Дополнить элемент");
        System.out.println("5. Посмотреть текущее древо");
        System.out.println("6. Назад");
    }

    private void case_Main_2_TreeWork() {
        if (presenter.treeIsEmpty()){
            clearConsole();
            System.out.println("Текущее древо пустое!\n");
            caseMain();
            return;
        }
        menu_Main_2_TreeWork();
        String choice;
        choice = scanner.nextLine();
        switch (choice) {
            case "1": // ...имени
                clearConsole();
                sortByName();
                case_Main_2_TreeWork();
                break;
            case "2": // ...id
                clearConsole();
                sortById();
                case_Main_2_TreeWork();

                break;
            case "3": // ...полу
                clearConsole();
                sortByGender();
                case_Main_2_TreeWork();

            case "4": // ...дате рождения
                clearConsole();
                sortByDob();
                case_Main_2_TreeWork();
            case "5": // ...дате смерти
                clearConsole();
                sortByDod();
                case_Main_2_TreeWork();
            case "6": // Посмотреть текущее дерево
                clearConsole();
                showCurrentTree();
                case_Main_2_TreeWork();
            case "7": // Назад
                clearConsole();
                caseMain();
                break;
            default:
                clearConsole();
                System.out.println("Некорректный выбор, попробуйте ещё раз!");
                case_Main_2_TreeWork();
        }
    }

    private void menu_Main_2_TreeWork() {
        System.out.println("Выберите команду:");
        System.out.println("\nСортировать по...");
        System.out.println("1. ...имени");
        System.out.println("2. ...id");
        System.out.println("3. ...полу");
        System.out.println("4. ...дате рождения");
        System.out.println("5. ...дате смерти");
        System.out.println("6. Посмотреть текущее дерево");
        System.out.println("7. Назад");
    }


    //-----------Методы редактирования элементов--------------------
    public void createNewElement() {
        clearConsole();
        String firstName = askFirstName();
        clearConsole();
        String lastName = askLastName();
        clearConsole();
        LocalDate dob = askDob();
        clearConsole();
        LocalDate dod = askDod();
        clearConsole();
        Gender gender = Gender.valueOf(askGender());
        clearConsole();

        Human father = null, mother = null;
        ArrayList<String> childs = null;
        if (askParents().equals("Да")) {
            father = askFather();
            mother = askMother();
        }
        clearConsole();
        if (askChilds().equals("Да")) {
            childs = childsForHum();
        }

        Human anyHuman = presenter.createHuman(firstName, lastName, dob, dod, gender, father, mother);
        presenter.addElementInTree(anyHuman);
        if (childs != null && !childs.isEmpty()) {
            for (String ch : childs) {
                anyHuman.addChilds(presenter.findHuman(ch));
            }
        }
        clearConsole();
        System.out.println("Элемент " + anyHuman.getId() + " Успешно создан!");
    } // Программа создания метода
    public String askFirstName() {
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        if (firstName == null) {
            System.out.println("Введено пустое значение, попробуйте ещё раз:");
            askFirstName();
        }
        return firstName;
    } // Спрашиваем имя
    public String askLastName() {
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        if (lastName == null) {
            System.out.println("Введено пустое значение, попробуйте ещё раз:");
            askFirstName();
        }
        return lastName;
    } // Спрашиваем фамилию
    public LocalDate askDob() {
        System.out.println("Введите дату рождения (формат дд-мм-гггг):");
        String dobInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate dob = LocalDate.parse(dobInput, formatter);
            return dob;
        } catch (Exception e) {
            System.out.println("Неверный формат даты. Попробуйте еще раз.");
            return askDob();
        }
    } // Спрашиваем дату рождения
    public LocalDate askDod() {
        System.out.println("Введите дату смерти (формат дд-мм-гггг):");
        String dobInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate dod = LocalDate.parse(dobInput, formatter);
            return dod;
        } catch (Exception e) {
            System.out.println("Неверный формат даты. Попробуйте еще раз.");
            return askDob();
        }
    } // Спрашиваем дату смерти
    public String askGender() {
        System.out.println("Введите ваш пол (Male/Female):");
        String genderIn = scanner.nextLine();
        if (!genderIn.equals("Male") && !genderIn.equals("Female")) {
            System.out.println("Неверный ввод. Пожалуйста, введите 'Male' для мужского или 'Female' для женского.");
            return askGender();
        }
        return genderIn;
    } // Спрашиваем пол
    public String askParents() {
        System.out.println("Известен ли сейчас родители? (Да/Нет)\nБудет произведён поиск среди шаблонов. Родителей также можно будет добавить позднее:");
        String answerYorN = scanner.nextLine();
        if (!answerYorN.equals("Да") && !answerYorN.equals("Нет")) {
            System.out.println("Неверный ввод. Пожалуйста, введите 'Да', если родители известены или 'Нет', если это не так.");
            return askParents();
        } else {
            return answerYorN;
        }
    } // Спрашиваем известны ли родители
    public Human askFather() {
        if (!presenter.treeIsEmpty()){
            System.out.println(presenter.getTree());
        }
        System.out.println("Введите имя отца:");
        String fatherName = scanner.nextLine();
        Human father = presenter.findHuman(fatherName);
        if (father != null) {
            System.out.println("Отец найден среди шаблонов и добавлен в качестве родителя для текущего шаблона.");
            return father;
        } else {
            System.out.println("Отец не найден.");
            return null;
        }
    } // Спрашиваем и проверяем папу по имени, если есть то добавляем
    public Human askMother() {
        if (!presenter.treeIsEmpty()){
            System.out.println(presenter.getTree());
        }
        System.out.println("Введите имя матери:");
        String motherName = scanner.nextLine();
        Human mother = presenter.findHuman(motherName);
        String a;
        if (mother != null) {
            System.out.println("Мама найдена среди шаблонов и добавлена в качестве родителя для текущего шаблона.");
            return mother;
        } else {
            System.out.println("Мама не найдена.");
            return null;
        }
    } // Спрашиваем и проверяем маму по имени, если есть то добавляем
    public String askChilds() {
        System.out.println("Известы ли сейчас дети? (Да/Нет)\nБудет произведён поиск среди шаблонов. Детей также можно будет добавить позднее:");
        String answerYorN = scanner.nextLine();
        if (!answerYorN.equals("Да") && !answerYorN.equals("Нет")) {
            System.out.println("Неверный ввод. Пожалуйста, введите 'Да', если родители известены или 'Нет', если это не так.");
            return askChilds();
        } else {
            return answerYorN;
        }
    } // Спрашиваем известны ли дети
    public ArrayList<String> childsForHum() {
        if (!presenter.treeIsEmpty()){
            System.out.println(presenter.getTree());
        }
        ArrayList<String> children = new ArrayList<>();
        System.out.println("Введите имена детей (введите 'стоп' для завершения):");
        String childName;
        while (!(childName = scanner.nextLine().trim()).equalsIgnoreCase("стоп")) {
            if (presenter.findHuman(childName) != null) {
                children.add(childName);
            }
        }
        if (children.isEmpty()) {
            System.out.println("Детей не найдено среди шаблонов");
            return children;
        }
        return children;
    } // Спрашиваем и проверяем детей по имени, если есть то верем их
    public String findElement() {
        System.out.println("Введите имя элемента для поиска (или стоп для отмены): ");
        String nameOfElement = scanner.nextLine();
        if ("стоп".equals(nameOfElement)) {
            clearConsole();
            case_Main_1_RedactElem();
            return null;
        }
        if (presenter.findHuman(nameOfElement) != null) {
            clearConsole();
            System.out.println("Элемент найден: ");
            System.out.println(presenter.findHuman(nameOfElement));
            findElement();
        } else {
            System.out.println("Такой элемент не найден!");
            findElement();
        }
        return null;
    } // Метод поиска человека и отображения найденного
    public String deleteElement() {
        System.out.println("Введите имя элемента (или стоп для отмены): ");
        String nameOfElement = scanner.nextLine();
        if ("стоп".equals(nameOfElement)) {
            case_Main_1_RedactElem();
            return null;
        }
        if (presenter.findHuman(nameOfElement) != null) {
            clearConsole();
            System.out.println("Элемент найден и удалён! ");
            presenter.deleteElementFromTree(presenter.findHuman(nameOfElement));
            deleteElement();
        } else {
            System.out.println("Такой элемент не найден!");
            deleteElement();
        }
        return null;
    } // Метод поиска человека и удаления найденного
    public String addNewInfoAboutElement() {
        System.out.println("Введите имя элемента, к которому нужно добавить данные (или стоп для отмены): ");
        String nameOfElement = scanner.nextLine();
        if ("стоп".equals(nameOfElement)) {
            case_Main_1_RedactElem();
            return null;
        }
        if (presenter.findHuman(nameOfElement) != null) {
            clearConsole();
            System.out.println("Элемент найден: ");
            if (presenter.findHuman(nameOfElement).withoutParents()) {
                Human father = null;
                Human mother = null;
                if (askParents().equals("Да")) {
                    father = askFather();
                    mother = askMother();
                    presenter.findHuman(nameOfElement).addParent(father);
                    presenter.findHuman(nameOfElement).addParent(mother);
                    System.out.println("Родители успешно добавлены!");
                }
            }
            ArrayList<String> childs = null;

            if (askChilds() == "Да") {
                childs = childsForHum();
            }

            if (childs.get(0) != null) {
                for (String ch : childs) {
                    presenter.findHuman(nameOfElement).addChilds(presenter.findHuman(ch));
                }
                System.out.println("Дети успешно добавлены!");
            }

            addNewInfoAboutElement();
        } else {
            System.out.println("Такой элемент не найден!");
            addNewInfoAboutElement();
        }
        return null;
    } // Проверяем, есть ли родители, если нет, то можно найти и добавить их,

    // потом ищем детей и добавляем


    //------------------Сортировки----------------------------------------------------------------
    public void sortByName() {
        presenter.sortByFirstName();
        System.out.println("Дерево отсортировано по имени!");
    }
    public void sortById() {
        presenter.sortById();
        System.out.println("Дерево отсортировано по id!");
    }
    public void sortByDod() {
        presenter.sortByDod();
        System.out.println("Дерево отсортировано по дате рождения!");
    }
    public void sortByDob() {
        presenter.sortByDob();
        System.out.println("Дерево отсортировано по дате смерти!");
    }
    public void sortByGender() {
        presenter.sortByGender();
        System.out.println("Дерево отсортировано по полу!");
    }


    //-----------Сохранение и загрузка дерева-----------------------------------------
    public void saveTree() {
        if (presenter.treeIsEmpty()){
            clearConsole();
            System.out.println("Текущее древо пустое!\n");
            caseMain();
            return;
        }
        System.out.println("Введите путь для сохранения дерева (включая имя файла и расширение '.txt', или 'стоп' для отмены): ");
        String filePath = scanner.nextLine();
        if ("стоп".equals(filePath)) {
            clearConsole();
            caseMain();
            return;
        }
        if (!filePath.endsWith(".txt")) {
            System.out.println("Пожалуйста, убедитесь, что путь к файлу включает имя файла и расширение '.txt'.");
            saveTree();
            return;
        }
        File file = new File(filePath);
        // проверка, что файл существует и это не каталог, и он может быть перезаписан
        if (file.exists() && !file.isDirectory()) {
            // можно добавить запрос на подтверждение перезаписи файла
        }

        try {
            presenter.saveTree(presenter.getTree(), filePath);
            System.out.println("Дерево успешно сохранено по пути: " + filePath);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при сохранении дерева! Попробуйте еще раз.");
            saveTree();
        }
    }
    public void loadTree() {
        while (true) {
            System.out.println("Введите путь к директории для загрузки файла (или 'стоп' для отмены): ");
            String directoryPath = scanner.nextLine();

            if ("стоп".equals(directoryPath)) {
                return;
            }

            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                System.out.println("Указанный путь ошибочный или не существует. Попробуйте еще раз.");
                continue;
            }

            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files == null || files.length == 0) {
                System.out.println("Файлов древ (с расширением '.txt') в директории не обнаружено. Попробуйте еще раз.");
                continue;
            } else if (files.length == 1) {
                System.out.println("Найден 1 файл: " + files[0].getName());
                System.out.println("Хотите загрузить этот файл? (введите 'Да' или 'Нет')");
                String response = scanner.nextLine();
                if ("Да".equalsIgnoreCase(response)) {
                    presenter.updateTree(presenter.loadTree(files[0].getPath()));
                    System.out.println("Файл успешно загружен.");
                    return;
                } else if ("стоп".equalsIgnoreCase(response)) {
                    return;
                }
            } else {
                System.out.println("Выберите файл для загрузки:");
                for (int i = 0; i < files.length; i++) {
                    System.out.println((i + 1) + ": " + files[i].getName());
                }
                System.out.println("Введите номер файла или 'стоп' для отмены:");
                String fileChoice = scanner.nextLine();
                if ("стоп".equalsIgnoreCase(fileChoice)) {
                    return;
                }
                try {
                    int index = Integer.parseInt(fileChoice) - 1;
                    if (index >= 0 && index < files.length) {
                        presenter.updateTree(presenter.loadTree(files[index].getPath()));
                        System.out.println("Файл успешно загружен.");
                        return;
                    } else {
                        wrongInput();
                    }
                } catch (NumberFormatException e) {
                    wrongInput();
                }
            }
        }
    }


    //--------Специальные методы-----------------------------------------------------
    private void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    } // Очистка консоли
    private void userHourHi() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброе утро!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Добрый день!");
        } else if (hour >= 18 && hour <= 23) {
            System.out.println("Добрый вечер!");
        } else {
            System.out.println("Добрая ночь!");
        }

    }  //Приветствие
    private void userHourBye() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброго утра!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Доброго дня!");
        } else if (hour >= 18 && hour <= 23) {
            System.out.println("Доброго вечера!");
        } else {
            System.out.println("Доброй ночи!");
        }
    } //Прощание
    private void showCurrentTree() {
        System.out.println("Обзор текущего дерева: ");
        System.out.println(presenter.getTree());
        if (presenter.getTree().treeIsEmpty()){
            System.out.println("Текущее древо пустое!\n");
        }

    }// Посмотреть дерево
    private void exit() {
        work = false;
//        System.exit(0);
    } // Выход через 3 секунды
    private void wrongInput() { // "Некорректный выбор, попробуйте ещё раз!"
        System.out.println("Некорректный выбор, попробуйте ещё раз!");
    }
    private void delayAnyMs(int ms){
        try {
            Thread.sleep(ms); // Задержка на 3 сек
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление
            e.printStackTrace();
        }
    } // Задержка на мс
    //--------------------------------------------------------------------------------------------------
}

