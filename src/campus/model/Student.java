package campus.model;

public class Student {

    private int studentId;
    private String name;
    private String department;
    private int semester;

    public Student(int studentId, String name, String department, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Name: " + name
                + ", Department: " + department
                + ", Semester: " + semester;
    }
}