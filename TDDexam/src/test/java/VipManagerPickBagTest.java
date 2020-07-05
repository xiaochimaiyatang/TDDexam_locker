//givenVIP用户之前存小包，找manager取包，when manager去S型Locker取包，then存包成功；
//givenVIP用户之前存中包，找manager取包，when manager去M型Locker取包，then存包成功；
//givenVIP用户之前存中包，找manager取包，when manager委任PrimaryLockerRobot取包，then存包成功；
//givenVIP用户之前存大包，找manager取包，when manager去L型Locker取包，then存包成功；
//givenVIP用户之前存大包，找manager取包，when manager去委任SuperLockerRobot取包，then存包成功；
//givenVIP用户拿假票来找manager取包，when manager去取包，then提示票无效；
//givenVIP用户之前找小樱存的包但是拿票来找manager取包，when manager去取包，then提示票无效；


import Bag.Bag;
import Bag.VipBag;
import Locker.Locker;
import Manager.Manager;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import Ticket.Ticket;
import exception.ConfigManagerException;
import exception.InvalidTicketException;
import exception.LockerNoSpaceException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VipManagerPickBagTest {
    @Test
    public void should_get_bag_when_manager_pick_bag_when_saved_S_bag() throws ConfigManagerException, LockerNoSpaceException, InvalidTicketException {
        Locker locker = new Locker("S", 1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag1 = new Bag();
        Ticket ticket=locker.SaveBag(bag1);
        Bag bag = locker.PickBag(ticket);
        assertEquals(bag,bag1);

    }


    @Test
    public void should_pick_Mbag_successfullywhen_manager_save_bag_through_primaryLockerRobot_given_vip_save_M_bag() throws LockerNoSpaceException, ConfigManagerException, InvalidTicketException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag = new Bag();
        Ticket ticket=primaryLockerRobot.SaveBag(bag);
        Bag bag1 = primaryLockerRobot.PickBag(ticket);
        assertEquals(bag,bag1);
    }

    @Test
    public void should_pick_Lbag_successfullywhen_manager_save_bag_through_superLockerRobot_given_vip_save_bag() throws LockerNoSpaceException, ConfigManagerException, InvalidTicketException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag = new Bag();
        Ticket ticket=superLockerRobot.SaveBag(bag);
        Bag bag1 = superLockerRobot.PickBag(ticket);
        assertEquals(bag,bag1);

    }
}
