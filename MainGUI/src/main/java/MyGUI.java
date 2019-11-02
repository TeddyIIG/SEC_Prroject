import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

public class MyGUI {
    EnterRobotInfo aRobots;
    {

        aRobots = new EnterRobotInfo();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI();
            }
        });
    }

    public static void MainGUI()
    {

        JFrame MenuFrame=new JFrame();                              //creating a JFrame for the menu

        JButton play=new JButton("PLAY");                       // Creating a JButton to play
        play.setBounds(130,100,100, 40);        //Setting the location of the button on the panel (X,Y,Width,Height)
        JButton exit = new JButton("EXIT");
        exit.setBounds(130,160,100,40);
        MenuFrame.add(play);                                        //adding the button into JFrame
        MenuFrame.add(exit);


        MenuFrame.setSize(400,500);                     //400 width and 500 height
        MenuFrame.setLayout(null);                                    //No layout managers used for compatibility issues
        MenuFrame.setVisible(true);                                   //Setting the frame as visible
        MenuFrame.setDefaultCloseOperation(MenuFrame.EXIT_ON_CLOSE);

        exit.addActionListener(new ActionListener() {               //Action event for button click to exit the application.
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.dispose();
            }
        });

        play.addActionListener(new ActionListener() {                       //Action event for button click to open the arena
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.dispose();

                ArenaClass test = new ArenaClass();
                test.arenastart();

            }
        });

    }



}
