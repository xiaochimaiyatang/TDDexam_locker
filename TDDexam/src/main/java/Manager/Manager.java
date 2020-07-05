package Manager;

import Bag.VipBag;
import Locker.Locker;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import Ticket.Ticket;
import exception.ConfigManagerException;
import exception.LockerNoSpaceException;

import java.util.Arrays;
import java.util.List;

public class Manager {
    private List<Locker> lockers;
    private List<PrimaryLockerRobot> primaryLockerRobots;
    private List<SuperLockerRobot> superLockerRobots;



    public Manager(List<Locker> lockers, List<PrimaryLockerRobot> primaryLockerRobots, List<SuperLockerRobot> superLockerRobots) throws ConfigManagerException, LockerNoSpaceException {
        if (lockers.size() == 1 && primaryLockerRobots.size() == 1 && superLockerRobots.size() == 1) {
            this.lockers = lockers;
            this.primaryLockerRobots = primaryLockerRobots;
            this.superLockerRobots = superLockerRobots;
        } else {
            throw new ConfigManagerException();
        }


    }


    Locker locker = new Locker("S", 2);
    PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 3)));
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));

    public Ticket SaveBag(VipBag vipbag) throws LockerNoSpaceException {
        if (vipbag.getSize() == "M") {
            Ticket ticket = primaryLockerRobot
                    .SaveBag(vipbag);
            return ticket;
        }else if (vipbag.getSize() == "M"){
            Ticket ticket = superLockerRobot
                    .SaveBag(vipbag);
            return ticket;
        }else{
            Ticket ticket = locker
                    .SaveBag(vipbag);
            return ticket;
        }


    }

}