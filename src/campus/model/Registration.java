package campus.model;

public class Registration {

    private int registrationId;
    private int studentId;
    private int eventId;

    public Registration(int registrationId, int studentId, int eventId) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.eventId = eventId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getEventId() {
        return eventId;
    }

    @Override
    public String toString() {
        return "Registration ID: " + registrationId
                + ", Student ID: " + studentId
                + ", Event ID: " + eventId;
    }
}