package campus.service;

import campus.model.Participation;

import java.util.ArrayList;
import java.util.List;

public class ParticipationService {

    private final List<Participation> participations;

    public ParticipationService() {
        participations = new ArrayList<>();
    }

    public void addParticipation(Participation participation) {
        participations.add(participation);
    }

    public List<Participation> getAllParticipations() {
        return new ArrayList<>(participations);
    }

    public Participation findParticipationById(int participationId) {

        for (Participation participation : participations) {

            if (participation.getParticipationId() == participationId) {
                return participation;
            }
        }

        return null;
    }

    public Participation findByRegistrationId(int registrationId) {

        for (Participation participation : participations) {

            if (participation.getRegistrationId() == registrationId) {
                return participation;
            }
        }

        return null;
    }

    public boolean updateStatus(
            int participationId,
            campus.enums.ParticipationStatus status) {

        Participation participation =
                findParticipationById(participationId);

        if (participation != null) {
            participation.setStatus(status);
            return true;
        }

        return false;
    }
}