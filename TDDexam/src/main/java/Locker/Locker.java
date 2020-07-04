package Locker;

import Bag.Bag;
import Ticket.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int size;

    public Locker(String type, int size) {
        this.size=size;
    }

    private Map<Ticket, Bag> ticketBagMap=new HashMap<Ticket, Bag>();
    public Ticket SaveBag(Bag bag) {
        Ticket ticket = new Ticket();
        ticketBagMap.put(ticket,bag);
        return new Ticket();
    }


    public int getAvailableRoom() {
        return this.size-ticketBagMap.size();
    }
}