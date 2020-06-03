import java.util.ArrayList;
import java.util.List;

public class Party extends Event{

    private List<Event>events;

    public Party(String title, String date, String description) {
        super(title, date, description);
        this.events = new ArrayList<>();
    }

    public boolean addEvent(Event event){
        return events.add(event);
    }

    @Override
    public int getAudienceCount() {
        int audienceCount = super.getAudienceCount();

        for(Event event : events){
            audienceCount += event.getAudienceCount();
        }

        return audienceCount;
    }
}
