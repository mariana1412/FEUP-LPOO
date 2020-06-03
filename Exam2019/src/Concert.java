import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String country;
    private String city;
    private String date;
    private List<Act> acts;
    private int numberSoldTickets;

    public Concert(String city, String country, String date) {
        this.country = country;
        this.city = city;
        this.date = date;
        this.acts = new ArrayList<>();
        this.numberSoldTickets = 0;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public int getNumberSoldTickets() {
        return numberSoldTickets;
    }

    public void addAct(Act act){
        acts.add(act);
    }

    public boolean isValid(Ticket ticket) {
        if(this == ticket.getConcert()) return true;
        return false;
    }

    public void addTicket(){
        this.numberSoldTickets++;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Concert)) return false;
        Concert c = (Concert) obj;
        return (c.getCity() == city) && (c.getCountry() == country) && (c.getDate() == date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date);
    }

    public boolean participates(Artist artist) {
        for(Act act: acts){
            if(act instanceof Artist){
                if(artist.equals(act))
                    return true;
            }
            else {
                if(((Band)act).containsArtist(artist))
                    return true;
            }
        }
        return false;
    }
}
