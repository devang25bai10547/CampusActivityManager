package campus.service;

import campus.model.Registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private final List<Registration> registrations;

    public RegistrationService() {
        registrations = new ArrayList<>();
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public List<Registration> getAllRegistrations() {
        return new ArrayList<>(registrations);
    }

    public Registration findRegistrationById(int registrationId) {
        for (Registration registration : registrations) {
            if (registration.getRegistrationId() == registrationId) {
                return registration;
            }
        }

        return null;
    }

    public boolean studentAlreadyRegistered(int studentId, int eventId) {
        for (Registration registration : registrations) {
            if (registration.getStudentId() == studentId
                    && registration.getEventId() == eventId) {
                return true;
            }
        }

        return false;
    }

    public boolean removeRegistration(int registrationId) {

        Registration registration =
                findRegistrationById(registrationId);

        if (registration != null) {
            registrations.remove(registration);
            return true;
        }

        return false;
    }

    public int countRegistrationsForEvent(int eventId) {

        int count = 0;

        for (Registration registration : registrations) {
            if (registration.getEventId() == eventId) {
                count++;
            }
        }

        return count;
    }
}