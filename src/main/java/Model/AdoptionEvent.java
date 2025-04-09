package Model;

import java.util.ArrayList;
import java.util.List;

public class AdoptionEvent {
    private String eventName;
    private List<IAdoptable> participants;

    public AdoptionEvent(String eventName) {
        this.eventName = eventName;
        this.participants = new ArrayList<>();
    }

    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
        System.out.println("Participant registered for " + eventName);
    }

    public void hostEvent() {
        System.out.println("Hosting Adoption Event: " + eventName);
        for (IAdoptable p : participants) {
            p.adopt();
        }
    }

    public String getEventName() {
        return eventName;
    }

    public List<IAdoptable> getParticipants() {
        return participants;
    }

	@Override
	public String toString() {
		return "AdoptionEvent [eventName=" + eventName + ", participants=" + participants + "]";
	}
}
