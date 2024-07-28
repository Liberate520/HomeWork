package study_group.student;

public class Student implements  Comparable<Student>{
    private int id;
    private String name;
    private int age;


    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student anotherStudent) {
      return this.name.compareTo(anotherStudent.name);
    }


}
