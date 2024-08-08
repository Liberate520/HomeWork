
package com.familytree.model.family_tree;

import com.familytree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode extends Serializable {
    long getId();
    String getName();
    LocalDate getBirthDate();
}