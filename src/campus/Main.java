package campus;

import campus.model.Student;
import campus.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            displayMainMenu();

            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    System.out.println("\nEvent Management will be available soon.");
                    break;
                case 3:
                    System.out.println("\nRegistration will be available soon.");
                    break;
                case 4:
                    System.out.println("\nParticipation Management will be available soon.");
                    break;
                case 5:
                    System.out.println("\nReports will be available soon.");
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using the Campus Activity & Event Management System.");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please enter a number from 1 to 6.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n========================================");
        System.out.println(" CAMPUS ACTIVITY & EVENT MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Student Management");
        System.out.println("2. Event Management");
        System.out.println("3. Registration");
        System.out.println("4. Participation");
        System.out.println("5. Reports");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    private static void studentMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n----- STUDENT MANAGEMENT -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Back to Main Menu");

            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {

        System.out.println("\n----- ADD STUDENT -----");

        int studentId = readInteger("Enter student ID: ");

        if (studentService.findStudentById(studentId) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        int semester = readInteger("Enter semester: ");

        Student student = new Student(studentId, name, department, semester);

        studentService.addStudent(student);

        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {

        System.out.println("\n----- STUDENT LIST -----");

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {

        System.out.println("\n----- SEARCH STUDENT -----");

        int studentId = readInteger("Enter student ID: ");

        Student student = studentService.findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }

    private static void updateStudent() {

        System.out.println("\n----- UPDATE STUDENT -----");

        int studentId = readInteger("Enter student ID: ");

        Student student = studentService.findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new department: ");
        String department = scanner.nextLine();

        int semester = readInteger("Enter new semester: ");

        boolean updated = studentService.updateStudent(
                studentId,
                name,
                department,
                semester
        );

        if (updated) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Unable to update student.");
        }
    }

    private static void removeStudent() {

        System.out.println("\n----- REMOVE STUDENT -----");

        int studentId = readInteger("Enter student ID: ");

        boolean removed = studentService.removeStudent(studentId);

        if (removed) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static int readInteger(String message) {

        while (true) {
            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}