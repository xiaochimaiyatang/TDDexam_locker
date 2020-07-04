package SuperLockerRobot;

import Bag.Bag;
import Locker.Locker;
import Ticket.Ticket;

import java.util.List;

public class SuperLockerRobot {
    private List<Locker> lockers;
    public SuperLockerRobot(List<Locker> lockers) {
        this.lockers=lockers;
    }

    public Ticket SaveBag(Bag bag)  {
        Ticket ticket = lockers.stream()
                .filter(locker -> locker.getAvailableRoom() != 0)
                .findFirst().get().SaveBag(bag);
        return ticket;
    }
}
