import edu.naukma.theme8.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentRegistryTest {
    @Test
    public void removeEmail() {
        StudentRegistry registry = new StudentRegistry();

        Student student = new Student("Ivan Ivanov", "ivan@mail.com", "stu123");
        registry.addStudent(student);

        registry.removeById("stu123");
        assertFalse(registry.containsEmail("ivan@mail.com"));
    }

    @Test
    public void allowSameMail() {
        StudentRegistry registry = new StudentRegistry();

        Student student = new Student("Ivan Ivanov", "ivan@mail.com", "stu123");
        registry.addStudent(student);

        registry.removeById("stu123");

        Student student2 = new Student("Ivan Petrov", "ivan@mail.com", "stu123");
        registry.addStudent(student2);

        assertNotNull(registry.findById("stu123"));
    }

    @Test
    public void nullFromFind() {
        StudentRegistry registry = new StudentRegistry();

        assertNull(registry.findById("notExistingId"));
    }
}
