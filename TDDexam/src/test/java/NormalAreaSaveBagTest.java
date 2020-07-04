//tasking:
//用户找小樱存包，
//given普通用户找小樱存包，测量是S包，when小樱去Locker中存包，then存包成功，返回票据；
//given普通用户找小樱存包，测量是M包，when小樱去PrimaryLockerRobot存包，then存包成功且按照PrimaryLockerRobot顺序存到PrimaryLockerRobot中，返回票据；
//given普通用户找小樱存包，测量是L包，when小樱去SuperLockerRobot存包，then存包成功且将包存到空置率最大的存到SuperLocker中，返回票据；
//given普通用户找小樱存包，测量是S包，但是Locker满了，robot还有空位置，when小樱去Locker中存包，then提示无空间；
//given普通用户找小樱存包，测量是M包，但是PrimaryLockerRobot满了，Locker还有空位置，when小樱去PrimaryLockerRobot中存包，then提示无空间；
//given普通用户找小樱存包，测量是L包，但是SuperLockerRobot满了，Locker还有空位置，when小樱去SuperLockerRobot中存包，then提示无空间；

import Bag.Bag;
import Locker.Locker;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import Ticket.Ticket;
import exception.LockerNoSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class NormalAreaSaveBagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void given_bag_is_measured_as_small_bag_when_user_save_to_Slocker_then_save_successfully() throws LockerNoSpaceException {
        Bag bag = new Bag();
        Locker locker = new Locker("S",3);
        Ticket ticket=locker.SaveBag(bag);
        assertNotNull(ticket);

    }

    @Test
    public void given_bag_is_measured_as_middle_bag_when_user_save_to_PrimaryLockerRobot_then_save_successfully() throws LockerNoSpaceException {
        Locker locker1 = new Locker("M", 4);
        Locker locker2 = new Locker("M", 4);
        Bag bag = new Bag();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket=primaryLockerRobot.SaveBag(bag);
        assertNotNull(ticket);
    }

    @Test
    public void given_bag_is_measured_as_large_bag_when_user_save_to_SuperLockerRobot_then_save_successfully() throws LockerNoSpaceException {
        Locker locker1 = new Locker("L", 2);
        Locker locker2 = new Locker("L", 2);
        Bag bag = new Bag();
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket=superLockerRobot.SaveBag(bag);
        assertNotNull(ticket);
    }

    @Test
    public void given_bag_is_measured_as_small_bag_and_locker_is_full_and_superLockerRobot_is_empty_when_user_save_to_locker_then_save_fail() throws LockerNoSpaceException {
        Locker locker1 = new Locker("L", 2);
        Locker locker2 = new Locker("L", 2);
        Locker locker0 = new Locker("S", 1);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        locker0.SaveBag(bag1);
        locker0.SaveBag(bag2);
        thrown.expect(LockerNoSpaceException.class);
        thrown.expectMessage("fail to save the bag, no space");
    }


}
