package campus.model;

import campus.enums.EventCategory;

public class Event {

    private int eventId;
    private String eventName;
    private EventCategory category;
    private String date;
    private int maximumParticipants;

    public Event(int eventId, String eventName, EventCategory category,
                 String date, int maximumParticipants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.category = category;
        this.date = date;
        this.maximumParticipants = maximumParticipants;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public EventCategory getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public int getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMaximumParticipants(int maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId
                + ", Name: " + eventName
                + ", Category: " + category
                + ", Date: " + date
                + ", Maximum Participants: " + maximumParticipants;
    }
}
