
//given普通用户存S包然后拿S票找小樱取包，when小樱去Locker取包，then取到用户的S包；
//given普通用户存M包然后拿M票找小樱取包，when小樱去PrimaryLockerRobot取包，then取到用户的M包；
// given普通用户存L包然后拿L票找小樱取包，when小樱去SuperLockerRobot取包，then取到自己的L包；
// given普通用户拿S票找小樱取包，when小樱去PrimaryLockerRobot和SuperLockerRobot找取包，then取包失败，提示票无效；
// given普通用户拿假票找小樱取包，when取包，then取包失败，提示票无效；
// given普通用户拿重复票找小樱取包，when取包，then取包失败，提示票无效；
//givenVIP用户VIP票找小樱取包，when小樱取包，then取包失败，提示票无效；

import Bag.Bag;
import Locker.Locker;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import exception.InvalidTicketException;
import exception.LockerNoSpaceException;
import org.junit.Rule;
import org.junit.Test;
import Ticket.Ticket;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NormalAreaPickBagTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void should_pick_L_Bag_when_pick_bag_from_SuperLockerRobotgiven_save_bag_and_use_right_ticket () throws LockerNoSpaceException, InvalidTicketException {
        Locker locker1 = new Locker("M", 4);
        Locker locker2 = new Locker("M", 4);
        Bag bag = new Bag();
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket=superLockerRobot.SaveBag(bag);
        Bag mybag=superLockerRobot.PickBag(ticket);
        assertEquals(bag,mybag);
    }


    @Test
    public void should_pick_S_Bag_failed_when_pick_bag_from_PrimaryLockerRobot_given_save_bag_to_Locker_and_use_right_ticket () throws LockerNoSpaceException, InvalidTicketException {
        Bag bag = new Bag();
        Locker locker = new Locker("S",3);
        Locker locker1 = new Locker("M", 4);
        Locker locker2 = new Locker("M", 4);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket = locker.SaveBag(bag);
        Bag mybag=primaryLockerRobot.PickBag(ticket);
        assertEquals(bag,mybag);
        thrown.expect(InvalidTicketException.class);
        thrown.expectMessage("fail to save the bag, invaild ticket");
    }


    @Test
    public void should_pick_Bag_failed_when_pick_bag_from_locker_given_use_fake_ticket () throws LockerNoSpaceException, InvalidTicketException {
        Bag bag = new Bag();
        Locker locker = new Locker("S",3);
        locker.SaveBag(bag);
        Ticket ticket = new Ticket();

        thrown.expect(InvalidTicketException.class);
        thrown.expectMessage("fail to save the bag, invaild ticket");

        locker.PickBag(ticket);
    }


    @Test
    public void should_pick_Bag_failed_when_pick_bag_from_locker_given_ticket_is_used_once () throws LockerNoSpaceException, InvalidTicketException {
        Bag bag = new Bag();
        Locker locker = new Locker("S",3);
        Ticket ticket = locker.SaveBag(bag);
        locker.PickBag(ticket);

        thrown.expect(InvalidTicketException.class);
        thrown.expectMessage("fail to save the bag, invaild ticket");

        locker.PickBag(ticket);
    }
}

