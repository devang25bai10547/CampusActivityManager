package campus.service;

import campus.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private final List<Event> events;

    public EventService() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public Event findEventById(int eventId) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                return event;
            }
        }

        return null;
    }

    public boolean removeEvent(int eventId) {
        Event event = findEventById(eventId);

        if (event != null) {
            events.remove(event);
            return true;
        }

        return false;
    }

    public boolean updateEvent(int eventId, String eventName,
                               campus.enums.EventCategory category,
                               String date, int maximumParticipants) {

        Event event = findEventById(eventId);

        if (event != null) {
            event.setEventName(eventName);
            event.setCategory(category);
            event.setDate(date);
            event.setMaximumParticipants(maximumParticipants);
            return true;
        }

        return false;
    }
}