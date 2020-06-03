import java.util.*;

public class Event {

    private String title;
    private String description;
    private String date;
    private Set<Person> audience;

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
        this.audience = new HashSet<>();
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
        this.audience = new HashSet<>();
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.audience = new HashSet<>();
    }

    public Event(Event event) {
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.date = event.getDate();
        this.audience = event.getAudience();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Set<Person> getAudience() {
        return audience;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAudienceCount(){
        return audience.size();
    }

    public void addPerson(Person person){
        audience.add(person);
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(description, event.description) &&
                Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date);
    }

}
