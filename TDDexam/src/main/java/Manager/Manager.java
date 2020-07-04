package Manager;

import Locker.Locker;
import PrimaryLockerRobot.PrimaryLockerRobot;
import SuperLockerRobot.SuperLockerRobot;
import exception.ConfigManagerException;

import java.util.List;

public class Manager {
    private List<Locker> lockers;
    private List<PrimaryLockerRobot> primaryLockerRobots;
    private List<SuperLockerRobot> superLockerRobots;

    public Manager(List<Locker> lockers, List<PrimaryLockerRobot> primaryLockerRobots, List<SuperLockerRobot> superLockerRobots) throws ConfigManagerException {
        if (lockers.size()==1 && primaryLockerRobots.size()==1 && superLockerRobots.size()==1){
        this.lockers = lockers;
        this.primaryLockerRobots = primaryLockerRobots;
        this.superLockerRobots = superLockerRobots;
        }else{
            throw new ConfigManagerException();
        }



    }



}
