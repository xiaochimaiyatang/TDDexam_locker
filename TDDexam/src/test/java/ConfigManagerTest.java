//given超市管理员配置robot和Manager，when配置正确，即1个Locker，1个PrimaryLockerRobot，1个SuperLockerRobot，then配置成
//given超市管理员配置robot和Manager，when配置正确，即1个Locker，2个PrimaryLockerRobot，then配置错误；

import Locker.Locker;
import Manager.Manager;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import exception.ConfigManagerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ConfigManagerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_config_manager_successfully_when_admin_config_given_one_locker_and_one_PrimaryLockerRobot_one_SuperLockerRobot() throws ConfigManagerException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));
        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot), Arrays.asList(superLockerRobot));
        assertNotNull(manager);
    }

    @Test
    public void should_config_manager_fail_when_admin_config_given_one_locker_and__PrimaryLockerRobot_one_SuperLockerRobot() throws ConfigManagerException {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        PrimaryLockerRobot primaryLockerRobot2 = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 5)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("L", 5)));

        thrown.expect(ConfigManagerException.class);
        thrown.expectMessage("fail config error");

        Manager manager = new Manager(Arrays.asList(locker), Arrays.asList(primaryLockerRobot1,primaryLockerRobot2), Arrays.asList(superLockerRobot));
    }

}

