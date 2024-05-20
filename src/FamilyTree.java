import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyList;

    /**
     * Основной консруктор класса
     * @param familyList Arraylist<Human>
     */
    public FamilyTree(List<Human> familyList) {
        this.familyList = familyList;
    }

    /**
     * Добавляет Human в familyList
     * @param human
     */
    public void addHuman(Human human) {
        this.familyList.add(human);
    }

    /**
     * возвращает первого Human в котором в имени встретилась искома строка
     * без учета регистра
     * @param text String
     * @return Human
     */
    public Human findFirsIn(String text) {
        for (Human human: familyList) {
            if (human.getName().contains(text)){
                return human;
            }
        }
        return null;
    }

    /**
     * возвращает ArrayList<Human> в которых в имени встретилась искома строка
     * без учета регистра
     * @param text
     * @return ArrayList<Human>
     */
    public List<Human> findFirsAll(String text) {
        List<Human> result = new ArrayList<>();
        for (Human human: familyList) {
            if (human.getName().contains(text)){
                result.add(human);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Human human: familyList) {
        txt.append(human.getName()).append("\n");
        }
        return txt.toString();
    }
}
