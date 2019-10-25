public class RobotControlImpl {



public RobotInfo getRobotInfo()
{

    RobotInfo robot1 = new RobotInfo();
    return robot1;



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
/**
public boolean moveNorth()
{



}

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
