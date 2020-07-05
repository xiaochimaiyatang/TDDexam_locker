//givenVIP用户找manager存小包，when manager去S型Locker存包，then存包成功，返回票据；
//givenVIP用户找manager存中包，when manager委任PrimaryLockerRobot存包，then存包成功，返回票据；
//givenVIP用户找manager存中包，when manager自己将包存到M型号的Locker中，then存包成功，返回票据；
//givenVIP用户找manager存大包，when manager委任SuperLockerRobot存包，then存包成功，返回票据；
//givenVIP用户找manager存中包，when manager自己将包存到L型号的Locker中，then存包成功，返回票据；
//givenVIP用户找manager存小包，S的locker满了，其他Locker未满，when manager存包，then存包失败，提示无空间；
import Bag.Bag;
import Locker.Locker;
import Manager.Manager;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import Ticket.Ticket;
import exception.ConfigManagerException;
import exception.LockerNoSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class VipManagerSaveBagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_save_bag_to_Locker_successfullywhen_manager_save_bag_given_vip_save_S_bag() throws LockerNoSpaceException, ConfigManagerException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag = new Bag();
        Ticket ticket=manager.SaveBag(bag);
        assertNotNull(ticket);
    }

    @Test
    public void should_save_bag_to_MLocker_successfullywhen_manager_save_bag_through_primaryLockerRobot_given_vip_save_M_bag() throws LockerNoSpaceException, ConfigManagerException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag = new Bag();
        Ticket ticket=primaryLockerRobot.SaveBag(bag);
        assertNotNull(ticket);
    }


    @Test
    public void should_save_bag_to_LLocker_successfullywhen_manager_save_bag_through_superLockerRobot_given_vip_save_M_bag() throws LockerNoSpaceException, ConfigManagerException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag = new Bag();
        Ticket ticket=superLockerRobot.SaveBag(bag);
        assertNotNull(ticket);
    }


    @Test
    public void should_save_bag_to_Locker_fail_when_manager_save_bag_given_Locker_is_no_sapce() throws LockerNoSpaceException, ConfigManagerException {
        Locker locker = new Locker("S", 1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));

        Bag bag = new Bag();
        locker.SaveBag(bag);

        thrown.expect(LockerNoSpaceException.class);
        thrown.expectMessage("fail to save the bag, no space");

        locker.SaveBag(bag);
    }

}
