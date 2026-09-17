package campus.model;

import campus.enums.ParticipationStatus;

public class Participation {

    private int participationId;
    private int registrationId;
    private ParticipationStatus status;

    public Participation(int participationId, int registrationId,
                          ParticipationStatus status) {
        this.participationId = participationId;
        this.registrationId = registrationId;
        this.status = status;
    }

    public int getParticipationId() {
        return participationId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public ParticipationStatus getStatus() {
        return status;
    }

    public void setStatus(ParticipationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Participation ID: " + participationId
                + ", Registration ID: " + registrationId
                + ", Status: " + status;
    }
}