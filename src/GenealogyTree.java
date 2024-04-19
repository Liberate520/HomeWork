import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree implements Iterable<Person> {

    private Person root;
    private List<Person> people;

    public GenealogyTree(Person root) {
        this.root = root;
        this.people = new ArrayList<>();
    }

    @Override
    public Iterator<Person> iterator() {
        return new GenealogyTreeIterator(root);
    }

    private class GenealogyTreeIterator implements Iterator<Person> {

        private Person currentPerson;

        public GenealogyTreeIterator(Person root) {
            this.currentPerson = root;
        }

        @Override
        public boolean hasNext() {
            return currentPerson != null;
        }

        @Override
        public Person next() {
            Person nextPerson = currentPerson;
            currentPerson = findNextPerson(currentPerson);
            return nextPerson;
        }

        private Person findNextPerson(Person person) {
            // Реализуйте логику поиска следующего человека в дереве здесь
            if (!person.getChildren().isEmpty()) {
                return person.getChildren().get(0);
            } else {
                Person parent = person.getParent();
                while (parent != null && parent.getChildren().indexOf(person) == parent.getChildren().size() - 1) {
                    person = parent;
                    parent = parent.getParent();
                }
                if (parent != null) {
                    return parent.getChildren().get(parent.getChildren().indexOf(person) + 1);
                }
            }
            return null;
        }
    }

    public void sortByName() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    public void sortByDateOfBirth() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
            }
        });
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void removePerson(Person person) {
        people.remove(person);
    }
}
