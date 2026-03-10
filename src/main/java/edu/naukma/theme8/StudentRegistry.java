package edu.naukma.theme8;

import java.util.*;

public class StudentRegistry {
    List<Student> students = new ArrayList<>();
    Set<String> email = new HashSet<>();
    Map<String, Student> studentsById = new HashMap<>();

    public void addStudent(Student student) {
        students.add(student);
        email.add(student.email);
        studentsById.put(student.id, student);
    }

    public Student findById(String id) {
        return studentsById.get(id);
    }

    public boolean containsEmail(String email) {
        return this.email.contains(email);
    }

    public void removeById(String id) {
        Student student = studentsById.remove(id);

        if (student == null) return;

        students.removeIf(s -> s.equals(student));
        email.remove(student.email);
    }

}
