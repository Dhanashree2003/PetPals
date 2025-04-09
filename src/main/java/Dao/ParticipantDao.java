package Dao;


import Model.Participant;
import java.util.List;

public interface ParticipantDao {
    void addParticipant(Participant participant, int eventID);
    List<Participant> listParticipantsByEvent(int eventID);
}
