package Dao;

import java.util.List;
import Model.AdoptionEvent;

public interface AdoptionEventDao {
    void createEvent(AdoptionEvent event);
    List<AdoptionEvent> listEvents();
}