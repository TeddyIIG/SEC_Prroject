public class Robotics {
    public static void main(String[] args)
    {
        RobotControl obj = new RobotControlImpl();
       System.out.println(obj.getRobotInfo().getRname());
    }
}
