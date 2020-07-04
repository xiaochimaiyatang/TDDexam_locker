//tasking:
//用户找小樱存包，
//given普通用户找小樱存包，测量是S包，when小樱去Locker中存包，then存包成功，返回票据；
//given普通用户找小樱存包，测量是M包，when小樱去PrimaryLockerRobot存包，then存包成功且按照PrimaryLockerRobot顺序存到PrimaryLockerRobot中，返回票据；
//given普通用户找小樱存包，测量是L包，when小樱去SuperLockerRobot存包，then存包成功且将包存到空置率最大的存到SuperLocker中，返回票据；
//givenVIP用户找小樱存包，走普通用户存包流程，测量是S包，when小樱去Locker中存包，then存包到Locker中，返回票据；
//given普通用户找小樱存包，测量是S包，但是Locker满了，robot还有空位置，when小樱去Locker中存包，then提示无空间；

import Bag.Bag;
import Locker.Locker;
import PrimaryLockerRobot.PrimaryLockerRobot;
import Ticket.Ticket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class NormalAreaSaveBagTest {

    @Test
    public void given_bag_is_measured_as_small_bag_when_user_save_to_Slocker_then_save_successfully() {
        Bag bag = new Bag();
        Locker locker = new Locker("small",3);
        Ticket ticket=locker.SaveBag(bag);
        assertNotNull(ticket);

    }

    @Test
    public void given_bag_is_measured_as_middle_bag_when_user_save_to_PrimaryLockerRobot_then_save_successfully() {
        Locker locker1 = new Locker("M", 4);
        Locker locker2 = new Locker("M", 4);
        Bag bag = new Bag();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket=primaryLockerRobot.SaveBag(bag);
        assertNotNull(ticket);
    }
}
