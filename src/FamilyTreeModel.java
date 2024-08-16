import java.util.List;

public interface FamilyTreeModel<T extends TreeNode<T>> {
    boolean addHuman(T human);
    List<T> getAllHumans();

    boolean setMarriage(T human1, T human2);

    void saveTree();
}