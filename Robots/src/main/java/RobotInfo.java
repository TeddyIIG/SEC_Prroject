public class RobotInfo {

    public void setInfo(String rname,int posX,int posY,float Health) {
        Rname = rname;
        pX = posX;
        pY = posY;
        health = Health;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String rname) {
        Rname = rname;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int counter()
    {
        count = count + 1;
        return count;

    }
String Rname;
int pX;
int pY;
float health;
public static int count =0;




}
