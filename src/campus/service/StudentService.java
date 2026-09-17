package campus.service;

import campus.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public boolean removeStudent(int studentId) {
        Student student = findStudentById(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    public boolean updateStudent(int studentId, String name,
                                 String department, int semester) {

        Student student = findStudentById(studentId);

        if (student != null) {
            student.setName(name);
            student.setDepartment(department);
            student.setSemester(semester);
            return true;
        }

        return false;
    }
}