import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int timeFlight1 = t1.getTimeFrom() - t1.getTimeTo();
        int timeFlight2 = t2.getTimeFrom() - t2.getTimeTo();
        if (timeFlight1 > 0 & timeFlight2 > 0) {
            if (timeFlight1 < timeFlight2) {
                return -1;
            } else if (timeFlight1 > timeFlight2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (timeFlight1 > timeFlight2) {
                return -1;
            } else if (timeFlight1 < timeFlight2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
