package study_group.study_group;

import study_group.student.Student;
import study_group.student.comparators.StudentComparatorByAge;
import study_group.student.comparators.StudentComparatorByName;

import java.util.*;

public class StudyGroup<E extends ItemStudyGroup> implements Iterable<E>{
    private List<E> students;

    public StudyGroup(){
        students = new ArrayList<>();
    }
    public void addStudent(E student){
        students.add(student);
    }

    public void sortByName(){
        students.sort(new StudentComparatorByName<>());
    }

    public void sortByAge(){
        students.sort(new StudentComparatorByAge<>());

        /* //Анонимная функция
        students.sort(new Comparator<Student>() {
                          @Override
                          public int compare(Student o1, Student o2) {
                              return o1.getAge() - o2.getAge();
                          }
                      }
        */

        /*

        //Описание компоратора через лямбду
        students.sort((o1,o2)-> (o1.getAge() - o2.getAge()));

        //Полное сокращение
        students.sort((Comparator.comparingInt(Student::getAge)));
        */


    }


    @Override
    public Iterator<E> iterator() {
        return new StudentIterator<>(students);
    }

}
