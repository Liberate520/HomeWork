package study_group.service;

import study_group.student.Student;
import study_group.builder.StudentBuilder;
import study_group.study_group.StudyGroup;

public class Service {
    private StudentBuilder studentBuilder;
    private StudyGroup<Student> studyGroup;
    public Service(){
        studyGroup = new StudyGroup();
        studentBuilder = new StudentBuilder();
    }

    public void addStudent(String name, int age){
       Student student = studentBuilder.build(name, age);
       studyGroup.addStudent(student);
    }
    public void sortByName(){
        studyGroup.sortByName();
    }

    public void sortByAge(){
        studyGroup.sortByAge();
    }

    public String getStudentsListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cписок студентов:\n");
        for (Student student: studyGroup){
            sb.append(student);
            sb.append("\n");
        }
        return sb.toString();
    }
}
