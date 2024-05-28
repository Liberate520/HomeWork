package lv.homeWork.model.interfaces;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<E> extends Serializable {
    LocalDate getDateOfDeath();
    LocalDate getDateOfBirth();
    E getMarried();
    int getGeneration();
    String getName();
    void setGeneration();
    String getInfo();









}
