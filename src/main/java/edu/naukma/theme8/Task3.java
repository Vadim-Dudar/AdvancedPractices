package edu.naukma.theme8;

public class Task3 {
    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        Student s1 = new Student("Ivan", "ivan@mail.com", "1");
        Student s2 = new Student("Petro", "petro@mail.com", "2");
        Student s3 = new Student("Dima", "dima@mail.com", "3");
        Student s4 = new Student("Misha", "misha@mail.com", "4");

        registry.addStudent(s1);
        registry.addStudent(s2);
        registry.addStudent(s3);
        registry.addStudent(s4);
    }
}
