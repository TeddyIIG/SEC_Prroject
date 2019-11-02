public interface RobotInfo {
    //Interface for the RobotInfo class
    public  static int count =0;
    public void setInfo(String rname,int posX,int posY,float Health);
    public String getRname();
    public void setRname(String rname);
    public int getpX();
    public void setpX(int pX);
    public int getpY();
    public void setpY(int pY);
    public float getHealth();
    public void setHealth(float health);

}
