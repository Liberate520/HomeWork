/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class HumanBuilder
 * @version v1.0
 */

package family_true.model.builder;

import family_true.model.api.BuildId;

public class EntityBuilder {

    private long id;

    public void build(BuildId entity) {
        if (entity.getId() == -1) {
            entity.setId(id++);
        }
    }
}
