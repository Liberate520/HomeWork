package lv.homeWork.model;

import lv.homeWork.model.objects.Human;

public class GenerationCalculator {

    public static void setGeneration(Human human) {
        if (human.getObjectRelations().getParents().isEmpty()) {
            human.setGeneration(0);
        } else {
            int maxParentGeneration = 0;
            for (Human parent : human.getObjectRelations().getParents()) {
                if (parent.getGeneration() > maxParentGeneration) {
                    maxParentGeneration = parent.getGeneration();
                }
            }
            human.setGeneration(maxParentGeneration + 1);
        }
        for (Human child : human.getObjectRelations().getChildrens()) {
            setGeneration(child);
        }
    }
}
