package homeWork.Model.Tree;

public interface TreeItem<T> extends Comparable<T> {
    int getAge();
    String getName();
}
