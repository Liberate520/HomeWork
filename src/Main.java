

import java.io.IOException;
import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
import FamilyTree.FamilyTree;
import Humans.FamilyFriend;
import Humans.Gender;
import Humans.Human;
import Writers.Writer;
import Writers.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        Writer fileHandler = new FileHandler();
       
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Павлов Александр Иванович", LocalDate.of(1955, 12, 1),
        LocalDate.of(2022, 1, 20), Gender.Male);

        Human human2 = new Human("Павлова Антонина Сергеевна", LocalDate.of(1957, 5, 15),
        null, Gender.Female);

        Human human3 = new Human("Павлов Иван Алесандрович", LocalDate.of(1980, 11, 14),
        null, Gender.Male, null, null);

        Human human4 = new Human("Федорова Елена Александровна", LocalDate.of(1978, 5, 25),
        null, Gender.Female, null, null);

        Human human5 = new Human("Павлов Василий Иванович", LocalDate.of(2012, 3, 2),
        null, Gender.Male, null, null, null, null);

        Human human6 = new Human("Федорова Оксана Андреевна", LocalDate.of(2015, 7, 18),
        null, Gender.Female, null, null, null, null);

        Human human7 = new FamilyFriend("Черенков Аркадий Борисович", null, null, Gender.Male,
        null, null, null, LocalDate.of(1975, 6, 19)); // друг семьи добавлен просто интереса ради, чтобы посмотреть как это работает.
        
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        // огромная куча добавлений, потому что я ещё плохо освоил тему.
        human1.addChild(human3);
        human1.addChild(human4);
        human2.addChild(human3);
        human2.addChild(human4);
        human3.addChild(human5);
        human3.addChild(human6);
        human4.addChild(human5);
        human4.addChild(human6);
        human3.addParent(human1);
        human4.addParent(human1);
        human3.addParent(human2);
        human4.addParent(human2);
        human5.addParent(human3);
        human6.addParent(human3);
        human5.addParent(human4);
        human6.addParent(human4);      
        
        //Простите, но я не понимаю, почему выводит дубли детей и внуков (возможно, из-за того, что я решил не использовать концепцию с ID, 
        // но тогда, если убрать первое добавление human3 в список детей, то он должен выводиться только 1 раз, но он всё равно выводится в списке 2 раза, я не нашёл ошибку,
        // Константин, подскажите пожалуйста, что не так?).
        System.out.println(familyTree);
        familyTree = fileHandler.read("familyTree.txt");



    }
}
