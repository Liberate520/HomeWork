/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class HumanBuilder
 * @version v1.0
 */

package family_true.builder;

import family_true.api.BuildId;

public class EntityBuilder {

    private long id;

    public void build(BuildId entity) {
        if (entity.getId() == -1) {
            entity.setId(id++);
        }
    }
}
