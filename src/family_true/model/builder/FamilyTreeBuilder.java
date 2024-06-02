/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class TreeBuilder
 * @version v1.0
 */

package family_true.model.builder;

import family_true.model.api.BuildId;
import family_true.model.family_tree.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeBuilder<T extends BuildId> {

    private long treeId;
    private EntityBuilder entityBuilder;

    public FamilyTreeBuilder() {
        this.entityBuilder = new EntityBuilder();
    }

    public FamilyTreeBuilder(EntityBuilder humanBuilder) {
        this.entityBuilder = humanBuilder;
    }

    public FamilyTree build() {
        return new FamilyTree(treeId++);
    }

    public FamilyTree build(T entity) {
        List<T> entities = new ArrayList<>();
        entityBuilder.build(entity);
        entities.add(entity);
        return new FamilyTree(treeId++, entities);
    }

    public FamilyTree build(List<T> entities) {
        return new FamilyTree(treeId++, entities);
    }

    public EntityBuilder getEntityBuilder() {
        return entityBuilder;
    }
}
