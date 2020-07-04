package Locker;

import Bag.Bag;
import Ticket.Ticket;
import exception.LockerNoSpaceException;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int size;

    public Locker(String type, int size) {
        this.size = size;
    }

    private Map<Ticket, Bag> ticketBagMap = new HashMap<Ticket, Bag>();

    public Ticket SaveBag(Bag bag) throws LockerNoSpaceException {
        if (getAvailableRoom() <= 0) {
            throw new LockerNoSpaceException();
        }
        Ticket ticket = new Ticket();
        ticketBagMap.put(ticket, bag);
        return ticket;
    }


    public int getAvailableRoom() {
        return this.size - ticketBagMap.size();
    }

    public Bag PickBag(Ticket ticket) {
        Bag bag = ticketBagMap.get(ticket);
//        ticketBagMap.remove(ticket);
        return bag;

    }
}
