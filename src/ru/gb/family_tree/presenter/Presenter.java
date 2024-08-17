package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private final FamilyTreeService<Human> service;

    public Presenter() {
        service = new FamilyTreeService<>();
    }

    public String getTreeInfo() {
        return service.getTreeInfo();
    }

    public String sortById() {
        return service.sortById();
    }

    public String sortByName() {
        return service.sortByName();
    }

    public String sortByAge() {
        return service.sortByAge();
    }

    public String sortByBirthDay() {
        return service.sortByBirthDay();
    }

    public String getChildrenInfo(int selectId) {
        return service.getChildrenInfo(selectId);
    }

    public String addHuman(String strName, String strGender, String strBirthDay) {
        Gender gender;
        if (strGender.charAt(0) == 'М') {
            gender = Gender.MALE;
        } else if (strGender.charAt(0) == 'Ж') {
            gender = Gender.FEMALE;
        } else {
            return "Данные пола введены не верно. Введите М или Ж";
        }
        LocalDate birthDay = LocalDate.parse(strBirthDay);
        Human human = new Human(strName, gender, birthDay);
        return service.addItem(human) + "\n" + "Человек добавлен в дерево.";
    }

    public String setHumanDeathDay(int id, String strDeathDay) {
        LocalDate deathDay = LocalDate.parse(strDeathDay);
        return service.setHumanDeathDay(id, deathDay) + "\n" + "Добавлена дата смерти.";
    }

    public String setHumanFather(int idChildren, int idFather) {
        return service.setHumanFather(idChildren, idFather) + "\n" + "Отец добавлен.";
    }

    public String setHumanMother(int idChildren, int idMother) {
        return service.setHumanMother(idChildren, idMother) + "\n" + "Мать добавлена.";
    }

    public String wedding(int idHusband, int idWife) {
        return service.wedding(idHusband, idWife) + "\n" + "Брак заключен.";
    }

    public String divorce(int idHusband, int idWife) {
        return service.divorce(idHusband, idWife) + "\n" + "Брак разторгнут.";
    }

    public String remove(int id) {
        return service.remove(id) + "\n" + "Человек удален и дерева.";
    }

    public String createFamilyTree() {
        //service.createFamilyTree();
        List<Human> humans = new ArrayList<>();
        humans.add(new Human());
        //Human hum1 = new Human();
        //humans.getLast().setId(1);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Михaил Федopoвич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1596-07-12"));
        humans.getLast().setDeathDate(LocalDate.parse("1645-07-13"));
        humans.getLast().setGender(Gender.MALE);
        service.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum2 = new Human();
        //humans.getLast().setId(2);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Алекcей Михaйлoвич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1629-03-09"));
        humans.getLast().setDeathDate(LocalDate.parse("1676-01-29"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.getFirst());
        service.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum2 = new Human();
        //humans.getLast().setId(3);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Татьяна Михайловна Рoмaнoва");
        humans.getLast().setBirthDay(LocalDate.parse("1636-01-15"));
        humans.getLast().setDeathDate(LocalDate.parse("1706-09-04"));
        humans.getLast().setGender(Gender.FEMALE);
        humans.getLast().setFather(humans.getFirst());
        service.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum3 = new Human();
        //humans.getLast().setId(4);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Федop III Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1661-05-30"));
        humans.getLast().setDeathDate(LocalDate.parse("1682-04-27"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        service.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum4 = new Human();
        //humans.getLast().setId(5);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Ивaн V Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1666-08-27"));
        humans.getLast().setDeathDate(LocalDate.parse("1696-01-29"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        service.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum5 = new Human();
        //humans.getLast().setId(6);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Петp I Алекcеевич Рoмaнoв");
        humans.getLast().setBirthDay(LocalDate.parse("1672-05-30"));
        humans.getLast().setDeathDate(LocalDate.parse("1725-01-28"));
        humans.getLast().setGender(Gender.MALE);
        humans.getLast().setFather(humans.get(1));
        service.addItem(humans.getLast());

        humans.add(new Human());
        //Human hum6 = new Human();
        //humans.getLast().setId(7);
        //humans.getLast().setId(++Id);
        humans.getLast().setName("Елизaветa Петpoвнa Рoмaнoвa");
        humans.getLast().setBirthDay(LocalDate.parse("1709-12-18"));
        humans.getLast().setDeathDate(LocalDate.parse("1761-12-25"));
        humans.getLast().setGender(Gender.FEMALE);
        humans.getLast().setFather(humans.get(4));
        service.addItem(humans.getLast());

        humans.add(new Human.HumanBuilder("Евдокия Лукъяновна Стрешнева",
                Gender.FEMALE, LocalDate.parse("1626-02-15"), null, null)
                .setHumanDeathDate(LocalDate.parse("1645-07-23"))
                .build());
        service.addItem(humans.getLast());

        humans.add(new Human.HumanBuilder("Василий Михайлович Рoмaнoв",
                Gender.MALE, LocalDate.parse("1639-03-24"), humans.getFirst(), humans.get(7))
                .setHumanDeathDate(LocalDate.parse("1639-04-04"))
                .build());
        service.addItem(humans.getLast());
        return service.getTreeInfo() + "\n" + "Семейное древо создано.";
    }

    public String saveTree() {
        service.saveTree();
        return service.getTreeInfo() + "\n" + "Семейное древо сохранено в файл.";
    }

    public String restoreTree() {
        service.restoreTree();
        return service.getTreeInfo() + "\n" + "Семейное древо востановленно из файла.";
    }
}
