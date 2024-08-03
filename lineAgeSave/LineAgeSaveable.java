package com.oop.homeWorkOOP.lineAgeSave;

import com.oop.homeWorkOOP.lineAge.LineageTree;

public interface LineAgeSaveable {
    boolean saveLineAge(LineageTree tree);

    LineageTree loadLineAge();
}
