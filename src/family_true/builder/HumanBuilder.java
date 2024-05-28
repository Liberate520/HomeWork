/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class HumanBuilder
 * @version v1.0
 */

package family_true.builder;

import family_true.human.Human;

public class HumanBuilder {

    private long id;

    public Human build(Human human) {
        if (human.getId() == -1) {
            human.setId(id++);
        }
        return human;
    }
}
