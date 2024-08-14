import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyTree<E extends TreeNode<E>> implements FamilyTreeModel<E>, Serializable, Iterable<E> {
    private long EIdCounter;
    private Map<Long, E> humans; // Хранение объектов E по их уникальному ID
    private Writer writer;

    public FamilyTree(Writer writer) {
        this.humans = new HashMap<>();// Инициализация пустого HashMap для хранения людей
        this.EIdCounter = 1;
        this.writer = writer;// Установка зависимости для сохранения данных
    }
    // Метод добавления человека в семью
    public boolean addHuman(E human) {
        if (human == null || humans.containsKey(human.getId())){
            return false;
        }
        human.setId(EIdCounter++);
        humans.put(human.getId(), human);

        addToParents(human);
        addToChildren(human);
        return true;
    }

    // Метод поиска родителей и добавления детей к родителям
    private void addToParents(E human){
        for(E parent : human.getParents()){
            if (parent != null) {
                parent.addChild(human);
            }
        }
    }

    // Метод поиска детей и добавления родителей к детям
    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            if (child.getFather() == null && human.getGender() == Gender.Male) {
                child.setFather(human);
            }
            if (child.getMother() == null && human.getGender() == Gender.Female) {
                child.setMother(human);
            }
        }
    }

    // Метод поиска человека по ID
    public E getEById(long id) {
        return humans.get(id);
    }

    // Метод поиска людей по имени
    public List<E> getEByName(String name) {
        return humans.values().stream()
                .filter(E -> E.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Метод поиска людей по фамилии
    public List<E> getEBySurname(String surname) {
        return humans.values().stream()
                .filter(E -> E.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());
    }

    // Метод поиска братьев и сестер
    public List<E> getSiblings(long id) {
        E human = getEById(id);
        if (human == null) return Collections.emptyList();

        Set<E> siblings = new HashSet<>();
        for (E parent : human.getParents()) {
            if (parent != null) {
                siblings.addAll(parent.getChildren());
            }
        }
        siblings.remove(human); // Удаляем самого человека из списка его братьев и сестер
        return new ArrayList<>(siblings);
    }

    // Метод поиска всех детей человека по ID
    public List<E> getAllChildren(long id) {
        E E = getEById(id);
        return E != null ? E.getChildren() : Collections.emptyList();
    }

    // Метод создания супружеской связи
    public boolean setMarriage(long humanId1, long humanId2) {
        E human1 = getEById(humanId1);
        E human2 = getEById(humanId2);

        if (human1 != null && human2 != null && human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }


    public boolean setMarriage(E human1, E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }



    // Метод развода
    public boolean setDivorce(long humanId1, long humanId2) {
        E human1 = getEById(humanId1);
        E human2 = getEById(humanId2);

        if (human1 != null && human2 != null && human1.getSpouse() == human2) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    // Метод удаления человека по ID
    public boolean removeHuman(long id) {
        E human = humans.remove(id);
        if (human != null) {
            for (E parent : human.getParents()) {
                if (parent != null) parent.getChildren().remove(human);
            }
            for (E child : human.getChildren()) {
                if (child.getFather() == human) child.setFather(null);
                if (child.getMother() == human) child.setMother(null);
            }
            return true;
        }
        return false;
    }

    @Override
    public void saveTree() {
        writer.save(this); // Вызов метода сохранения через объект writer
    }

    // Получение всех людей в дереве
    public List<E> getAllHumans() {
        return new ArrayList<>(humans.values());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(new ArrayList<>(humans.values()));
    }

    // Переопределение toString для вывода информации о дереве
    @Override
    public String toString() {
        return humans.values().stream()
                .map(E::toString)
                .collect(Collectors.joining("\n"));
    }


}
