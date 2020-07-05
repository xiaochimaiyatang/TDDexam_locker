package PrimaryLockerRobot;

import Bag.Bag;
import Locker.Locker;
import Ticket.Ticket;
import exception.InvalidTicketException;
import exception.LockerNoSpaceException;

import java.util.List;
import java.util.stream.Stream;

public class PrimaryLockerRobot {
    private List<Locker> lockers;
    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers=lockers;
    }


    public Ticket SaveBag(Bag bag) throws LockerNoSpaceException {

        Ticket ticket = lockers.stream()
                .filter(locker -> locker.getAvailableRoom() != 0)
                .findFirst()
                .orElseThrow(() -> new LockerNoSpaceException())
                .SaveBag(bag);
        return ticket;
    }

    public Bag PickBag(Ticket ticket) throws InvalidTicketException {
        return lockers.stream()
                .map(locker -> {
                    try {
                        return locker.PickBag(ticket);
                    } catch (InvalidTicketException e) {
                        return null;
                    }
                })
                .filter(b -> b != null)
                .findFirst()
                .orElseThrow(() -> new InvalidTicketException());
}



}