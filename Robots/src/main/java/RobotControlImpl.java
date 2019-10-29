public class RobotControlImpl implements RobotControl  {



public RobotInfo getRobotInfo()
{
      RobotInfo robot = new RobotInfo();
      return robot;

}

public RobotInfo[] getAllRobots()
{
RobotInfo[] allrobots = new RobotInfo[10];
for (int i=0; i < allrobots.length; i++)
{
    allrobots[i] = new RobotInfo();

}

return  allrobots;

}

public boolean moveNorth(int maxX)
{
RobotInfo robot = new RobotInfo();
int y = robot.getpY();
int x = maxX;

if (y < 0 || y >= maxX )
{
return false;

}

else
 {
    y= y-1;
    robot.setpX(y);
    return true;
 }

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
