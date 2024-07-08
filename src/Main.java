import java.io.*;

public class Main {
        public static void main(String[] args) {
                FamilyTree readTree;
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/FamilyTree/Writer/tree.txt"))) {
                        readTree = (FamilyTree) ois.readObject();
                        System.out.println(readTree);
                } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                }


                Human wowa = new Human("Вова", Gender.MALE, 45);
                Human wika = new Human("Вика", Gender.FEMALE, 38);
                Human katja = new Human("Катя", Gender.FEMALE, 12);
                Human sasha = new Human("Саша", Gender.MALE, 8);

                // Создание экземпляра класса семейное дерево
                FamilyTree familyTree = new FamilyTree();

                // Добавление членов семьи
                familyTree.addMember(wowa);
                familyTree.addMember(wika);
                familyTree.addMember(katja);
                familyTree.addMember(sasha);

                // Установление супружеских связей
                familyTree.connectSpouses(wowa, wika);

                // Установление родственных связей
                familyTree.connectParents(katja, wowa, wika);
                familyTree.connectParents(sasha, wowa, wika);

                // Вывод состояния семейного древа
                System.out.println(familyTree);
        }
}
