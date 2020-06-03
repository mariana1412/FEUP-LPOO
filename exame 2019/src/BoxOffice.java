import java.util.ArrayList;
import java.util.List;

public class BoxOffice {


    public static List<Ticket> buy(Concert concert, int numberOfTickets) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();
        int lastTicketNumber = concert.getNumberSoldTickets();

        for(int i = 1; i <= numberOfTickets; i++){
            int number = lastTicketNumber + i;
            tickets.add(new Ticket(number, concert));
            concert.addTicket();
        }
        return tickets;
    }
}
