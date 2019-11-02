public class EnterRobotInfo {

    RobotInfo robot1;
    RobotInfo robot2;
    RobotInfo robot3;
    RobotInfo robot4;
    public RobotInfo[] Allrobots;
    public double robotX;
    public double robotY;
    private double erobotX;
    private double erobotY;
    private boolean firestat;
    String robotname;
    String health;


public EnterRobotInfo()
    {
         robot1 = new RobotInfoImpl();
         robot2 = new RobotInfoImpl();
         robot3 = new RobotInfoImpl();
         robot4 = new RobotInfoImpl();


        robot1.setInfo("Robot 1",0,5,100);
        robot2.setInfo("Robot 2",0,0,100);
        robot3.setInfo("Robot 3",8,8,100);
        robot4.setInfo("Robot 4",4,8,100);


        Allrobots = new RobotInfo[4];

        Allrobots[0] = robot1;
        Allrobots[1] = robot2;
        Allrobots[2] = robot3;
        Allrobots[3] = robot4;

    }

}
