import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Ekaterinburg", "Astana", 11000, 23, 5);
    Ticket ticket2 = new Ticket("Moscow", "Vladikavkaz", 5500, 20, 24);
    Ticket ticket3 = new Ticket("Moscow", "Kaliningrad", 4800, 9, 12);
    Ticket ticket4 = new Ticket("Moscow", "Minsk", 5000, 10, 11);
    Ticket ticket5 = new Ticket("Moscow", "Kaliningrad", 4200, 15, 18);
    Ticket ticket6 = new Ticket("Moscow", "Kaliningrad", 5300, 17, 20);
    Ticket ticket7 = new Ticket("Moscow", "Vladikavkaz", 5500, 18, 20);
    Ticket ticket8 = new Ticket("Moscow", "Vladikavkaz", 4900, 18, 21);

    @Test
    public void shouldTicketCompareToPrice() {
        Assertions.assertEquals(-1, ticket2.compareTo(ticket1));
        Assertions.assertEquals(1, ticket6.compareTo(ticket3));
        Assertions.assertEquals(0, ticket2.compareTo(ticket7));
    }

    @Test
    public void shouldSearchByPrice() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket5, ticket3, ticket6};
        Ticket[] actual = manager.search("Moscow", "Kaliningrad");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByPriceIfToNoMatch() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Moscow", "Voronezh");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketsCompareToFlightTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Assertions.assertEquals(-1, timeComparator.compare(ticket4, ticket2));
        Assertions.assertEquals(1, timeComparator.compare(ticket5, ticket7));
        Assertions.assertEquals(0, timeComparator.compare(ticket3, ticket6));
    }

    @Test
    public void shouldSearchAndSortByTime() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7, ticket8, ticket2};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Vladikavkaz", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortWithNullComparator() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket8, ticket2, ticket7};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Vladikavkaz", null);
        Assertions.assertArrayEquals(expected, actual);
    }


}
