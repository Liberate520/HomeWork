package lv.homeWork.model.objects;

import lv.homeWork.model.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public interface TreeNode<E> extends Serializable {
    LocalDate getDateOfDeath();

    Gender getGender();

    LocalDate getDateOfBirth();
    E getMarried();

    long getPassportID();

    long getPersonID();

    int getGeneration();
    String getName();
    void setGeneration(int generation);
    String getInfo();









}
