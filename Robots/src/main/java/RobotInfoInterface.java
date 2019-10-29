public interface RobotInfoInterface  {
    //Interface for the RobotInfo class

    public void setInfo(String rname,int posX,int posY,float Health);
    public String getRname();
    public void setRname(String rname);
    public int getpX();
    public void setpX(int pX);
    public int getpY();
    public void setpY(int pY);
    public float getHealth();
    public void setHealth(float health);
    public int counter();
}
