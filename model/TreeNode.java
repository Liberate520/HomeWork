package model;

import java.io.Serializable;

public interface TreeNode<T> extends Serializable {
    void addChild(T child);
}
