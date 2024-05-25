public class Main {
    public static void main(String[] args) {
        // Создаем объекты для представления членов семьи
        Human ioann = new Human("Иоанн Алексеевич Романов", Gender.MALE, "06.09.1666", "08.02.1696");
        Human aleksey = new Human("Алексей Михайлович Романов", Gender.MALE, "19.03.1629", "08.02.1676");
        Human maria = new Human("Мария Ильинична Милославская", Gender.FEMALE, "11.04.1624", "13.03.1669");
        Human praskovya = new Human("Прасковья Фёдоровна Салтыкова", Gender.FEMALE, "22.10.1664", "24.10.1723");

        // Устанавливаем родительские связи
        ioann.setMother(maria);
        ioann.setFather(aleksey);

        // Устанавливаем брачные отношения
        ioann.setSpouse(praskovya);

        // Создаем детей
        Human mariaIvanovna = new Human("Мария Ивановна Романова", Gender.FEMALE, "31.03.1689", "23.02.1692");
        Human feodosiya = new Human("Феодосия Ивановна Романова", Gender.FEMALE, "14.06.1690", "22.05.1691");
        Human ekaterina = new Human("Екатерина Иоанновна Романова", Gender.FEMALE, "8.11.1691", "25.06.1733");
        Human anna = new Human("Анна Иоанновна Романова", Gender.FEMALE, "07.02.1693", "28.10.1740");
        Human praskovyaIovanna = new Human("Прасковья Иоанновна Романова", Gender.FEMALE, "04 .10.1694", "19.10.1731");

        // Устанавливаем детей для Иоанна и Прасковьи
        ioann.addChild(mariaIvanovna);
        ioann.addChild(feodosiya);
        ioann.addChild(ekaterina);
        ioann.addChild(anna);
        ioann.addChild(praskovyaIovanna);

        // Выводим информацию о членах семьи
        System.out.println(ioann.toString());
    }
}
