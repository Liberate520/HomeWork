package com.oop.homeWorkOOP.fileWork;

import com.oop.homeWorkOOP.lineAge.LineageTree;

public interface LineAgeSaveable {
    boolean saveLineAge(LineageTree tree, String file);

    LineageTree loadLineAge(String file);
}
