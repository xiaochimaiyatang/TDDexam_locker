package Locker;

import Bag.Bag;
import Ticket.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    public Locker(int size) {
    }

    private Map<Ticket, Bag> ticketBagMap=new HashMap<Ticket, Bag>();
    public Ticket SaveBag() {
        return new Ticket();
    }
}
