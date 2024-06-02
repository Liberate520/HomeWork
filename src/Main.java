public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Person daniyar = new Person("Daniyar", 50);
        Person alina = new Person("Alina", 48);
        Person safia = new Person("Safia", 20);
        Person amin = new Person("Amin", 18);

        // Установка родственных связей
        safia.setFather(daniyar);
        safia.setMother(alina);
        amin.setFather(daniyar);
        amin.setMother(alina);

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(daniyar);
        familyTree.addPerson(alina);
        familyTree.addPerson(safia);
        familyTree.addPerson(amin);

        // Проведение исследования: получение всех детей Данияра
        System.out.println("Children of Daniyar: " + familyTree.getChildren("Daniyar"));

        // Вывод всего генеалогического древа
        familyTree.printFamilyTree();
    }
}
