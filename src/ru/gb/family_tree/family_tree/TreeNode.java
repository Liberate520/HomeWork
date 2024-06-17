package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public interface TreeNode<T> extends Comparable<T>, Serializable {
void addChild(T child);
void addParent(T parent);
T getFather();
T getMather();
int getAge();
String getMarriedPartnerInfo();
String getMatherInfo();
String getFatherInfo();
String getChildrenInfo();
int getPeriod();
void setMarriedPartner(T marriedPartner);
T getMarriedPartner();
long getId();
void setId(long id);
String getName();
String getLastName();
Gender getGender();
LocalDate getDateOfBirth();
List<T> getParents();
List<T> getChildren();

    void getChild(T human);
}