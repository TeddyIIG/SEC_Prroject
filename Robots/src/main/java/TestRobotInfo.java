public class TestRobotInfo {
    public static void main(String[] args) {

        RobotInfo rb1 = new RobotInfo();
        rb1.setInfo("Robot1",2,3,100);
        RobotInfo rb2 = new RobotInfo();
        rb2.setInfo("Robot2",4,3,100);



        String play = rb1.getRname();
        System.out.println("val is "+play);


    }
}
