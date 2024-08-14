import java.util.List;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    @Override
    public void displayHumans(List<? extends TreeNode<?>> humans) {
        for (TreeNode<?> human : humans) {
            System.out.println(human); // Вывод каждого человека в консоль
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message); // Вывод сообщения в консоль
    }
}