import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем людей на примере моей семьи
        Human dyatchinYS = new Human("Дятчин Ярослав Сергеевич", Gender.Male, "2013-10-09");
        Human dyatchinaAS = new Human("Дятчина Алиса Сергеевна", Gender.Female, "2008-03-05");
        Human dyatchinSA = new Human("Дятчин Сергей Александрович", Gender.Male,"1983-01-16");
        Human dyatchinaNV = new Human("Дятчина Наталья Владимировна", Gender.Female,"1984-11-11");
        Human dyatchinAA = new Human("Дятчин Александр Алесандрович", Gender.Male,"1961-10-19", "2012-05-22");
        Human dyatchinaTV = new Human("Дятчина Татьяна Васильевна", Gender.Female,"1959-09-27", "1991-07-16");
        Human shadrinVK = new Human("Шадрин Владимир Кузмич", Gender.Male,"1954-04-30");
        Human shadrinaOI = new Human("Шадрина Ольга Ивановна", Gender.Female,"1954-04-29");
        // Создаем семейное дерево и добаляем членов семьи
        FamilyTree dyatchini = new FamilyTree(new ArrayList<>());
        dyatchini.addHuman(dyatchinYS);
        dyatchini.addHuman(dyatchinaAS);
        dyatchini.addHuman(dyatchinaNV);
        dyatchini.addHuman(dyatchinAA);
        dyatchini.addHuman(dyatchinaTV);
        dyatchini.addHuman(shadrinVK);
        dyatchini.addHuman(shadrinaOI);
        // устанавливаем связи  родителей (дети добавляются автоматически приватным методом)
        dyatchinYS.setParents(dyatchinaNV, dyatchinSA);
        dyatchinaAS.setParents(dyatchinaNV, dyatchinSA);
        dyatchinSA.setParents(dyatchinaTV, dyatchinAA);
        dyatchinaNV.setParents(shadrinaOI, shadrinVK);
        // находим и печатаем Алису
        System.out.println(dyatchini.findFirsIn("Алиса"));
        // находим и печатаем всех с фамилией шадрин
        System.out.println(dyatchini.findFirsAll("Шадрин"));
        // Узнаем возраст Ярослава
        System.out.println(dyatchini.findFirsIn("Ярослав").getAge());
        // Узнаем родителей Натальи
        System.out.println(dyatchini.findFirsIn("Наталья").getParents());
        // Узнаем детей Ольги
        System.out.println(dyatchini.findFirsIn("Ольга").getChildren());
        // узнаем бабушек и дедушек Ярослава
        System.out.println(dyatchini.findFirsIn("Ярослав").getGrandparents());
        // Узнаем внуков Александра
        System.out.println(dyatchini.findFirsIn("Александр").getGrandsons());
    }
}
