//given超市管理员配置robot和Manager，when配置正确，即1个Locker，1个PrimaryLockerRobot，1个SuperLockerRobot，then配置成
//given超市管理员配置robot和Manager，when配置正确，即1个Locker，2个PrimaryLockerRobot，then配置错误；

import Locker.Locker;
import Manager.Manager;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class ConfigManagerTest {

    @Test
    public void should_config_manager_successfully() {
        Locker locker = new Locker("S", 3);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker("M", 4)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(new Locker("M", 5)));
        Manager manager = new Manager(Arrays.asList(locker, primaryLockerRobot, superLockerRobot));

        assertEquals(manager.isRight(),true);
    }

}

