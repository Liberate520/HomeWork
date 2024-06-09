package FamilyTree.view;

public class HelpListCommand {

    public String help(){
        StringBuilder sb = new StringBuilder();
        sb.append("Комманды для работы с семейным древом: ");
        sb.append("\n- /help - вывести список всех комманд.");
        sb.append("\n- /createFamilyTree [Имя] - создать семейное древо.");
        sb.append("\n- /addElement - добавить элемент в древо");
        sb.append("\n- /viewFamilyTree - посмотреть таблицу");
        sb.append("\n- /setWedding - сыграть свадьбу!");
        sb.append("\n- /save - сохранить текущее древо!");
        sb.append("\n- /load - загрузить древо по имени!");
        sb.append("\n- /sortedByAge - отсортировать по возрасту элементов!");
        sb.append("\n- /sortedByName - отсортировать по именам элементов!");
        sb.append("\n- /stop - остановить выполнение программы.");
        return sb.toString();
    }
}
