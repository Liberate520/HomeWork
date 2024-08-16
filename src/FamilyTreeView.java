import java.util.List;

public interface FamilyTreeView {
    void displayHumans(List<? extends TreeNode<?>> humans); // Метод для отображения списка людей
    void showMessage(String message); // Метод для отображения сообщения
}