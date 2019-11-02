public class RobotControlImpl implements RobotControl {
    RobotInfo RobotVal1;
    EnterRobotInfo objer;


    RobotControlImpl()
    {
        RobotVal1 = new RobotInfoImpl();

    }


public RobotInfo getRobotInfo()
{



        return RobotVal1;

}

public RobotInfo[] getAllRobots()
{
 return objer.Allrobots;

}

public boolean moveNorth(int maxX)
{
    return false;

}
/**
public boolean moveSouth()
{



}

public boolean moveEast()
{



}

public boolean moveWest()
{



}

public boolean fire(int posX, int posY)
{



} **/
}
