import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person ivan = new Person("Иван", "01.01.1970", Gender.MALE);
        Person maria = new Person("Мария", "02.02.1972", Gender.FEMALE);
        Person pavel = new Person("Павел", "03.03.2000", Gender.MALE);
        Person nadya = new Person("Надя", "03.07.2002", Gender.FEMALE);

        familyTree.addPerson(ivan);
        familyTree.addPerson(maria);
        familyTree.addPerson(pavel);
        familyTree.addPerson(nadya);

        ivan.addChild(pavel);
        maria.addChild(pavel);
        ivan.addChild(nadya);
        
        Writer fileHandler = new FileHandlerImpl();

        // Сохранение дерева в файл
        try {
            ((FileHandler) fileHandler).writeToFile("FamilyTree.ser", familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загрузка дерева из файла
        try {
            FamilyTree loadedFamilyTree = (FamilyTree) ((FileHandler) fileHandler).readFromFile("FamilyTree.ser");
            System.out.println("Загруженное дерево:");
            System.out.println(loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
