package edu.naukma.theme8;

public class Student {
    public final String id;
    public final String name;
    public final String email;


    public Student(String name, String email, String id) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student student)) return false;
        return student.id == this.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
