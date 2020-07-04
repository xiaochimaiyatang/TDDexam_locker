//tasking:
//用户找小樱存包，
//given普通用户找小樱存包，测量是S包，when小樱去Locker中存包，then存包成功，返回票据；
//given普通用户找小樱存包，测量是M包，when小樱去PrimaryLockerRobot存包，then存包成功且按照PrimaryLockerRobot顺序存到PrimaryLockerRobot中，返回票据；
//given普通用户找小樱存包，测量是L包，when小樱去SuperLockerRobot存包，then存包成功且将包存到空置率最大的存到SuperLocker中，返回票据；
//givenVIP用户找小樱存包，走普通用户存包流程，测量是S包，when小樱去Locker中存包，then存包到Locker中，返回票据；
//given普通用户找小樱存包，测量是S包，但是Locker满了，robot还有空位置，when小樱去Locker中存包，then提示无空间；

import Bag.Bag;
import Locker.Locker;
import Ticket.Ticket;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class NormalAreaSaveBagTest {

    @Test
    public void given_bag_is_measured_as_small_bag_when_user_save_to_Mlocker_then_save_successfully() {
        Bag bag = new Bag();
        Locker locker = new Locker(3);
        Ticket ticket=locker.SaveBag();
        assertNotNull(ticket);

    }
}
