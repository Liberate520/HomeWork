package vending_tree;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Human {
    private String name;
    private LocalDate dob; // Дата рождения
    private LocalDate dod; // Дата смерти (null для живых людей)
    private Gender gender;
    private Human father;
    private Human mother;
    private Human paternalGrandFather;
    private Human paternalGrandMother;
    private Human maternalGrandFather;
    private Human maternalGrandMother;
    private final List<Human> children;
    private final InteractionUser interactionUser;

    public Human(String name, boolean setParents, boolean setGrandParents, boolean setChildrens) {
        this.name = name;
        this.interactionUser = new InteractionUser();
        FamilyTree familyTree = new FamilyTree();
        this.children = new ArrayList<>();
        this.dod = null;

        if (setParents) {
            familyTree.setParents(this);
        }
        if (setGrandParents) {
            familyTree.setGrandParents(this);
        }
        if (setChildrens) {
            familyTree.setChildren(this);
        }
    }

    public Human() {
        this("Unknown", true, true, true);
    }

    /**
     * Получение имени пользователя
     * @return имя
     */
    public String getName() { return name; }

    /**
     * Получение гендера
     * @return гендер
     */
    public Gender getGender() { return gender; }
    public LocalDate getDob() { return dob; }
    public LocalDate getDod() { return dod; }

    public Human getFather() { return father; }
    public Human getMother() { return mother; }

    /**
     * Получение дедушки по папе
     * @return дедушка
     */
    public Human getPaternalGrandFather() { return paternalGrandFather; }

    /**
     * Получение бабушки по папе
     * @return бабушка
     */
    public Human getPaternalGrandMother() { return paternalGrandMother; }

    /**
     * Получение дедушки по маме
     * @return дедушка
     */
    public Human getMaternalGrandFather() { return maternalGrandFather; }

    /**
     * Получение бабушки по маме
     * @return бабушка
     */
    public Human getMaternalGrandMother() { return maternalGrandMother; }

    public void setFather(Human father) { this.father = father; }
    public void setMother(Human mother) { this.mother = mother; }
    public void setGrandFather(Human grandFather) { this.paternalGrandFather = grandFather; }
    public void setGrandMother(Human grandMother) { this.paternalGrandMother = grandMother; }
    public void setMaternalGrandFather(Human grandFather) { this.maternalGrandFather = grandFather; }
    public void setMaternalGrandMother(Human grandMother) { this.maternalGrandMother = grandMother; }
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Получение информации о детях
     * @return список имён с параметрами
     */
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.children.size(); i++) {
            Human child = this.children.get(i);
            res.append((i + 1)).append(". Ребенок: ").append(child.getName()).append(", Пол: ").append(getSimbolGender(child)).append("\n");
        }
        return res.toString();
    }

    /**
     * Получение символа гендера
     * @param man человек
     * @return символ в виде буквы
     */
    public String getSimbolGender(Human man) {
        Gender gender = man.getGender();
        return gender == Gender.Male ? "М" : "Ж";
    }

    /**
     * Получение возраста (живого человека или сколько лет на момент смерти)
     * @return
     */
    public int getAge() {
        if (dod == null) {
            return LocalDate.now().getYear() - dob.getYear();
        } else {
            return dod.getYear() - dob.getYear();
        }
    }

    /**
     * Установка имени пользователя
     */
    public void setName() {
        this.name = this.interactionUser.enterName();
    }

    /**
     * установка пола
     * @param gender пол
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Поиск и установка пола
     * @param name имя для поиска
     */
    public void setGenderUserSelect(String name) {
        try {
            WorkingWithAFile foundGender = new WorkingWithAFile();
            foundGender.loadUserData("src/vending_tree/nameUser.txt");
            this.gender = foundGender.getGender(name);

            if (this.gender != null) {
                //setGender(Gender gender);
                System.out.println("Пол для имени " + name + ": " + this.gender);
            } else {
                System.out.println("Пол для имени " + name + " не найден.");
                this.gender = this.interactionUser.selectGender();
                if(this.interactionUser.setNameBase() == 1) { // save data for base
                    foundGender.appendUserData("src/vending_tree/nameUser.txt", name, this.gender);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Некорректный формат данных в файле: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }

    /**
     * Добавление ребёнка
     * @param child ребёнок
     */
    public void addChild(Human child) {
        this.children.add(child);
    }

    /**
     * Установка даты рождения
     */
    public void setDob() {
        this.dob = this.interactionUser.getEnterBirthday();
    }

    /**
     * установка даты смерти
     */
    public void setDod() {
        this.dod = this.interactionUser.getEnterDayOfDeath();
    }

    /**
     * Форматирование даты
     * @param whosFormatted что форматируем (дату рождения или смерти)
     * @return форматированная дата
     */
    public String getLocalizedDate(String whosFormatted) {
        Locale russianLocale = new Locale("Ru", "RU");
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM", russianLocale);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                .withLocale(russianLocale);
        if (whosFormatted.equals("dob")) {
            return dob.format(formatter);
        }
        return dod.format(formatter);
    }

    /**
     * Получение разницы в датах
     * @param birthDate дата рождения
     * @return
     */
    public String getAgeDescription(LocalDate birthDate) {
        if (birthDate == null) {
            return "Дата рождения неизвестна";
        }

        LocalDate currentDate = LocalDate.now();
        int years = Period.between(birthDate, currentDate).getYears();

        return getYearDeclension(years);
    }

    /**
     * Получение склонённого года
     * @param years год
     * @return сколонённый год
     */
    private String getYearDeclension(int years) {
        if (years % 100 >= 11 && years % 100 <= 14) {
            return "лет";
        }

        switch (years % 10) {
            case 1:
                return "год";
            case 2:
            case 3:
            case 4:
                return "года";
            default:
                return "лет";
        }
    }

    /**
     * Закрытие Scanner
     */
    public void closeScanner() {
        this.interactionUser.closeScanner();
    }

    @Override
    public String toString() {
        String dateDeath = "";
        if (this.dod != null){
            dateDeath = "Дата смерти: " + this.getLocalizedDate("dod") + "\n";
        }

        String ageDescription = this.getAgeDescription(this.dob);

        return "Пользователю " + this.getName() + " " + this.getAge() + " " + ageDescription + ", пол: " + getSimbolGender(this) + "\n"
                + "Дата рождения: " + this.getLocalizedDate("dob") + "\n"
                + dateDeath
                + "Отец: " + this.getFather().getName() + "\n"
                + "Дедушка по папе: " + this.getPaternalGrandFather().getName() + "\n"
                + "Бабушка по папе: " + this.getPaternalGrandMother().getName() + "\n"
                + "Мама: " + this.getMother().getName() + "\n"
                + "Дедушка по маме: " + this.getMaternalGrandFather().getName() + "\n"
                + "Бабушка по маме: " + this.getMaternalGrandMother().getName() + "\n"
                + this.getChildrenInfo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dob, dod, gender, father, mother, paternalGrandFather,
                paternalGrandMother, maternalGrandFather, maternalGrandMother,
                children, interactionUser);
    }
}
