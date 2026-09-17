package campus;

import campus.enums.EventCategory;
import campus.enums.ParticipationStatus;
import campus.model.Event;
import campus.model.Participation;
import campus.model.Registration;
import campus.model.Student;
import campus.service.EventService;
import campus.service.ParticipationService;
import campus.service.RegistrationService;
import campus.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService = new StudentService();
    private static final EventService eventService = new EventService();
    private static final RegistrationService registrationService =
            new RegistrationService();
    private static final ParticipationService participationService =
            new ParticipationService();

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
                    eventMenu();
                    break;
                case 3:
                    registrationMenu();
                    break;
                case 4:
                    participationMenu();
                    break;
                case 5:
                    System.out.println("\nReports will be available soon.");
                    break;
                case 6:
                    running = false;
                    System.out.println(
                            "\nThank you for using the Campus Activity & Event Management System.");
                    break;
                default:
                    System.out.println(
                            "\nInvalid choice. Please enter a number from 1 to 6.");
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

        Student student =
                new Student(studentId, name, department, semester);

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

    private static void eventMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n----- EVENT MANAGEMENT -----");
            System.out.println("1. Create Event");
            System.out.println("2. View Events");
            System.out.println("3. Search Event");
            System.out.println("4. Update Event");
            System.out.println("5. Cancel Event");
            System.out.println("6. Back to Main Menu");

            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewEvents();
                    break;
                case 3:
                    searchEvent();
                    break;
                case 4:
                    updateEvent();
                    break;
                case 5:
                    removeEvent();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void addEvent() {

        System.out.println("\n----- CREATE EVENT -----");

        int eventId = readInteger("Enter event ID: ");

        if (eventService.findEventById(eventId) != null) {
            System.out.println("An event with this ID already exists.");
            return;
        }

        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        EventCategory category = readEventCategory();

        System.out.print("Enter event date: ");
        String date = scanner.nextLine();

        int maximumParticipants =
                readInteger("Enter maximum participants: ");

        Event event = new Event(
                eventId,
                eventName,
                category,
                date,
                maximumParticipants
        );

        eventService.addEvent(event);

        System.out.println("Event created successfully.");
    }

    private static EventCategory readEventCategory() {

        while (true) {
            System.out.println("\nSelect event category:");
            System.out.println("1. Technical");
            System.out.println("2. Cultural");
            System.out.println("3. Sports");
            System.out.println("4. Workshop");
            System.out.println("5. Other");

            int choice = readInteger("Enter category: ");

            switch (choice) {
                case 1:
                    return EventCategory.TECHNICAL;
                case 2:
                    return EventCategory.CULTURAL;
                case 3:
                    return EventCategory.SPORTS;
                case 4:
                    return EventCategory.WORKSHOP;
                case 5:
                    return EventCategory.OTHER;
                default:
                    System.out.println("Invalid category. Please try again.");
            }
        }
    }

    private static void viewEvents() {

        System.out.println("\n----- EVENT LIST -----");

        List<Event> events = eventService.getAllEvents();

        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }

        for (Event event : events) {
            System.out.println(event);
        }
    }

    private static void searchEvent() {

        System.out.println("\n----- SEARCH EVENT -----");

        int eventId = readInteger("Enter event ID: ");

        Event event = eventService.findEventById(eventId);

        if (event == null) {
            System.out.println("Event not found.");
        } else {
            System.out.println("Event found:");
            System.out.println(event);
        }
    }

    private static void updateEvent() {

        System.out.println("\n----- UPDATE EVENT -----");

        int eventId = readInteger("Enter event ID: ");

        Event event = eventService.findEventById(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter new event name: ");
        String eventName = scanner.nextLine();

        EventCategory category = readEventCategory();

        System.out.print("Enter new event date: ");
        String date = scanner.nextLine();

        int maximumParticipants =
                readInteger("Enter new maximum participants: ");

        boolean updated = eventService.updateEvent(
                eventId,
                eventName,
                category,
                date,
                maximumParticipants
        );

        if (updated) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Unable to update event.");
        }
    }

    private static void removeEvent() {

        System.out.println("\n----- CANCEL EVENT -----");

        int eventId = readInteger("Enter event ID: ");

        boolean removed = eventService.removeEvent(eventId);

        if (removed) {
            System.out.println("Event cancelled successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private static void registrationMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n----- REGISTRATION MANAGEMENT -----");
            System.out.println("1. Register Student");
            System.out.println("2. View Registrations");
            System.out.println("3. Search Registration");
            System.out.println("4. Cancel Registration");
            System.out.println("5. Back to Main Menu");

            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    viewRegistrations();
                    break;
                case 3:
                    searchRegistration();
                    break;
                case 4:
                    cancelRegistration();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void registerStudent() {

        System.out.println("\n----- REGISTER STUDENT -----");

        int registrationId =
                readInteger("Enter registration ID: ");

        if (registrationService.findRegistrationById(registrationId)
                != null) {
            System.out.println(
                    "A registration with this ID already exists.");
            return;
        }

        int studentId = readInteger("Enter student ID: ");

        Student student =
                studentService.findStudentById(studentId);

        if (student == null) {
            System.out.println(
                    "Student not found. Registration cancelled.");
            return;
        }

        int eventId = readInteger("Enter event ID: ");

        Event event =
                eventService.findEventById(eventId);

        if (event == null) {
            System.out.println(
                    "Event not found. Registration cancelled.");
            return;
        }

        if (registrationService.studentAlreadyRegistered(
                studentId, eventId)) {

            System.out.println(
                    "Student is already registered for this event.");
            return;
        }

        int currentRegistrations =
                registrationService.countRegistrationsForEvent(eventId);

        if (currentRegistrations >=
                event.getMaximumParticipants()) {

            System.out.println(
                    "Event registration limit has been reached.");
            return;
        }

        Registration registration =
                new Registration(
                        registrationId,
                        studentId,
                        eventId
                );

        registrationService.addRegistration(registration);

        System.out.println(
                "Student registered successfully.");
    }

    private static void viewRegistrations() {

        System.out.println("\n----- REGISTRATION LIST -----");

        List<Registration> registrations =
                registrationService.getAllRegistrations();

        if (registrations.isEmpty()) {
            System.out.println("No registrations found.");
            return;
        }

        for (Registration registration : registrations) {
            System.out.println(registration);
        }
    }

    private static void searchRegistration() {

        System.out.println("\n----- SEARCH REGISTRATION -----");

        int registrationId =
                readInteger("Enter registration ID: ");

        Registration registration =
                registrationService.findRegistrationById(
                        registrationId);

        if (registration == null) {
            System.out.println("Registration not found.");
        } else {
            System.out.println("Registration found:");
            System.out.println(registration);
        }
    }

    private static void cancelRegistration() {

        System.out.println("\n----- CANCEL REGISTRATION -----");

        int registrationId =
                readInteger("Enter registration ID: ");

        boolean removed =
                registrationService.removeRegistration(
                        registrationId);

        if (removed) {
            System.out.println(
                    "Registration cancelled successfully.");
        } else {
            System.out.println("Registration not found.");
        }
    }

    private static void participationMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n----- PARTICIPATION MANAGEMENT -----");
            System.out.println("1. Mark Participation");
            System.out.println("2. View Participation");
            System.out.println("3. Search Participation");
            System.out.println("4. Update Participation");
            System.out.println("5. Back to Main Menu");

            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    markParticipation();
                    break;
                case 2:
                    viewParticipation();
                    break;
                case 3:
                    searchParticipation();
                    break;
                case 4:
                    updateParticipation();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println(
                            "\nInvalid choice. Please try again.");
            }
        }
    }

    private static void markParticipation() {

        System.out.println("\n----- MARK PARTICIPATION -----");

        int participationId =
                readInteger("Enter participation ID: ");

        if (participationService.findParticipationById(
                participationId) != null) {

            System.out.println(
                    "A participation record with this ID already exists.");
            return;
        }

        int registrationId =
                readInteger("Enter registration ID: ");

        Registration registration =
                registrationService.findRegistrationById(
                        registrationId);

        if (registration == null) {
            System.out.println(
                    "Registration not found. Participation cannot be marked.");
            return;
        }

        ParticipationStatus status = readParticipationStatus();

        Participation participation =
                new Participation(
                        participationId,
                        registrationId,
                        status
                );

        participationService.addParticipation(participation);

        System.out.println(
                "Participation recorded successfully.");
    }

    private static ParticipationStatus readParticipationStatus() {

        while (true) {
            System.out.println("\nSelect participation status:");
            System.out.println("1. Registered");
            System.out.println("2. Attended");
            System.out.println("3. Absent");

            int choice = readInteger("Enter status: ");

            switch (choice) {
                case 1:
                    return ParticipationStatus.REGISTERED;
                case 2:
                    return ParticipationStatus.ATTENDED;
                case 3:
                    return ParticipationStatus.ABSENT;
                default:
                    System.out.println(
                            "Invalid status. Please try again.");
            }
        }
    }

    private static void viewParticipation() {

        System.out.println("\n----- PARTICIPATION LIST -----");

        List<Participation> participations =
                participationService.getAllParticipations();

        if (participations.isEmpty()) {
            System.out.println("No participation records found.");
            return;
        }

        for (Participation participation : participations) {
            System.out.println(participation);
        }
    }

    private static void searchParticipation() {

        System.out.println("\n----- SEARCH PARTICIPATION -----");

        int participationId =
                readInteger("Enter participation ID: ");

        Participation participation =
                participationService.findParticipationById(
                        participationId);

        if (participation == null) {
            System.out.println(
                    "Participation record not found.");
        } else {
            System.out.println("Participation found:");
            System.out.println(participation);
        }
    }

    private static void updateParticipation() {

        System.out.println("\n----- UPDATE PARTICIPATION -----");

        int participationId =
                readInteger("Enter participation ID: ");

        Participation participation =
                participationService.findParticipationById(
                        participationId);

        if (participation == null) {
            System.out.println(
                    "Participation record not found.");
            return;
        }

        ParticipationStatus status = readParticipationStatus();

        boolean updated =
                participationService.updateStatus(
                        participationId,
                        status
                );

        if (updated) {
            System.out.println(
                    "Participation updated successfully.");
        } else {
            System.out.println(
                    "Unable to update participation.");
        }
    }

    private static int readInteger(String message) {

        while (true) {
            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a number.");
            }
        }
    }
}