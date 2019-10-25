import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

public class ArenaClass {
    public void arenastart() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame window = new JFrame("Robot AI Test (Swing)");
                window.setResizable(false);
                SwingArena arena = new SwingArena();
                JToolBar toolbar = new JToolBar();
                JButton btn1 = new JButton("Play");
                JButton btn2 = new JButton("Exit");
                toolbar.add(btn1);
                toolbar.add(btn2);

                btn1.addActionListener((event) ->
                {
                    System.out.println("Button 1 pressed");
                });

                btn2.addActionListener((event) ->
                {
                   window.dispose();
                });

                JTextArea logger = new JTextArea();
                JScrollPane loggerArea = new JScrollPane(logger);
                loggerArea.setBorder(BorderFactory.createEtchedBorder());
                logger.append("Hello\n");
                logger.append("World\n");
                JSplitPane splitPane = new JSplitPane(
                        JSplitPane.HORIZONTAL_SPLIT, arena, logger);

                Container contentPane = window.getContentPane();
                contentPane.setLayout(new BorderLayout());
                contentPane.add(toolbar, BorderLayout.NORTH);
                contentPane.add(splitPane, BorderLayout.CENTER);


                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setPreferredSize(new Dimension(800, 800));
                window.pack();
                window.setVisible(true);

                splitPane.setDividerLocation(0.75);
            }
        });
    }
}
