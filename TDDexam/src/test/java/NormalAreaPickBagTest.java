
//given普通用户存S包然后拿S票找小樱取包，when小樱去Locker取包，then取到用户的S包；
//given普通用户存M包然后拿M票找小樱取包，when小樱去PrimaryLockerRobot取包，then取到用户的M包；
// given普通用户存L包然后拿L票找小樱取包，when小樱去SuperLockerRobot取包，then取到自己的L包；
// givenVIP用户之前找小樱存S包然后再拿正确的票找小樱取包，when小樱去Locker取包，then取到用户的S包；
// given普通用户拿S票找小樱取包，when小樱去PrimaryLockerRobot和SuperLockerRobot找取包，then取包失败，提示票无效；
// given普通用户拿假票找小樱取包，when取包，then取包失败，提示票无效；
// given普通用户拿重复票找小樱取包，when取包，then取包失败，提示票无效；
//givenVIP用户VIP票找小樱取包，when小樱取包，then取包失败，提示票无效；

import Bag.Bag;
import Locker.Locker;
import PrimaryLockerRobot.PrimaryLockerRobot;
import exception.InvalidTicketException;
import exception.LockerNoSpaceException;
import org.junit.Test;
import Ticket.Ticket;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NormalAreaPickBagTest {
    @Test
    public void should_pick_S_Bag_when_pick_bag_given_save_bag_and_use_right_ticket () throws LockerNoSpaceException, InvalidTicketException {
        Bag bag = new Bag();
        Locker locker = new Locker("S",3);
        Ticket ticket = locker.SaveBag(bag);
        Bag mybag=locker.PickBag(ticket);
        assertEquals(bag,mybag);
    }

    @Test
    public void should_pick_M_Bag_when_pick_bag_from_PrimaryLockerRobotgiven_save_bag_and_use_right_ticket () throws LockerNoSpaceException, InvalidTicketException {
        Locker locker1 = new Locker("M", 4);
        Locker locker2 = new Locker("M", 4);
        Bag bag = new Bag();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket=primaryLockerRobot.SaveBag(bag);
        Bag mybag=primaryLockerRobot.PickBag(ticket);
        assertEquals(bag,mybag);
    }
}

