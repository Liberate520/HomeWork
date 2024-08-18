package com.oop.homeWorkOOP.model.lineAgeSave;

import com.oop.homeWorkOOP.model.lineAge.LineAgeItem;
import com.oop.homeWorkOOP.model.lineAge.LineageTree;

public interface LineAgeSaveable<T extends LineAgeItem<T>> {
    boolean saveLineAge(LineageTree<T> tree);

    LineageTree<T> loadLineAge();
}
