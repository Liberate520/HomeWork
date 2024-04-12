import java.util.ArrayList;
import java.util.List;

/***
 * Класс семейного дерева
 */
public class TreeFamily {
    private List<Human> humanList;
    private String name;

    /***
     * Метод добавления пустого списка дерева
     * @param name фамилия для семейного дерева
     */
    public TreeFamily(String name) {
        this.name = name;
        humanList = new ArrayList<>();
    }

    /***
     * Метод добавления человека в семейное дерево
     * @param human ввести класс Human
     */
    public void add(Human human){
        humanList.add(human);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево " + name);
        stringBuilder.append("\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
