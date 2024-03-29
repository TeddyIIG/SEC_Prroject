import java.awt.*;
import javax.swing.*;

/**
 * A Swing GUI element that displays a grid on which you can draw images, text and lines.
 */
public class SwingArena extends JPanel {
    // Represents the image to draw. You can modify this to introduce multiple images.
    private static final String IMAGE_FILE = "1554047213.png";
    ImageIcon robot1;


    //Initial values of the grid size and the placement of the two robots
    private int gridWidth = 20;
    private int gridHeight = 20;
    private double robotX = 0;
    private double robotY = 0;
    EnterRobotInfo obj1;


    private double gridSquareSize; // Auto-calculated


    /**
     * Creates a new arena object, loading the robot image.
     */
    public SwingArena() {
        // Here's how you get an Image object from an image file (which you provide in the
        // 'resources/' directory.
        try {
            robot1 = new ImageIcon(getClass().getClassLoader().getResource(IMAGE_FILE));


        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(new JFrame(), "No Image found in specified directory", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }

         obj1 = new EnterRobotInfo();


    }


    /**
     * Moves a robot image to a new grid position. This method is a *demonstration* of how you
     * can do such things, and you may want or need to modify it substantially.
     */




    /**
     * This method is called in order to redraw the screen, either because the user is manipulating
     * the window, OR because you've called 'repaint()'.
     * <p>
     * You will need to modify the last part of this method; specifically the sequence of calls to
     * the other 'draw...()' methods. You shouldn't need to modify anything else about it.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gfx = (Graphics2D) g;
        gfx.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // First, calculate how big each grid cell should be, in pixels. (We do need to do this
        // every time we repaint the arena, because the size can change.)
        gridSquareSize = Math.min(
                (double) getWidth() / (double) gridWidth,
                (double) getHeight() / (double) gridHeight);

        int arenaPixelWidth = (int) ((double) gridWidth * gridSquareSize);
        int arenaPixelHeight = (int) ((double) gridHeight * gridSquareSize);


        // Draw the arena grid lines. This may help for debugging purposes, and just generally
        // to see what's going on.
        gfx.setColor(Color.GRAY);
        gfx.drawRect(0, 0, arenaPixelWidth - 1, arenaPixelHeight - 1); // Outer edge

        for (int gridX = 1; gridX < gridWidth; gridX++) // Internal vertical grid lines
        {
            int x = (int) ((double) gridX * gridSquareSize);
            gfx.drawLine(x, 0, x, arenaPixelHeight);
        }

        for (int gridY = 1; gridY < gridHeight; gridY++) // Internal horizontal grid lines
        {
            int y = (int) ((double) gridY * gridSquareSize);
            gfx.drawLine(0, y, arenaPixelWidth, y);
        }



            for(RobotInfo robots : obj1.Allrobots  ) {

                robotX = robots.getpX();
                robotY = robots.getpY();
                drawImage(gfx, robot1, robotX, robotY);
                drawLabel(gfx, robots.getRname() + " " + robots.getHealth(), robotX, robotY);

            }


        /**
         if (firestat == true) {
         drawLine(gfx, robotX, robotY, erobotX, erobotY);
         } **/
    }


/**
 drawImage(gfx, robot1, 4, robotY);
 drawLabel(gfx, robotname + " " + health,4, robotY);
 drawLine(gfx, 4, robotY, erobotX, erobotY); **/









    /**
     * Draw an image in a specific grid location. *Only* call this from within paintComponent().
     *
     * Note that the grid location can be fractional, so that (for instance), you can draw an image
     * at location (3.5,4), and it will appear on the boundary between grid cells (3,4) and (4,4).
     *
     * You shouldn't need to modify this method.
     */
    private void drawImage(Graphics2D gfx, ImageIcon icon, double gridX, double gridY)
    {
        // Get the pixel coordinates representing the centre of where the image is to be drawn.
        double x = (gridX + 0.5) * gridSquareSize;
        double y = (gridY + 0.5) * gridSquareSize;

        // We also need to know how "big" to make the image. The image file has a natural width
        // and height, but that's not necessarily the size we want to draw it on the screen. We
        // do, however, want to preserve its aspect ratio.
        double fullSizePixelWidth = (double) robot1.getIconWidth();
        double fullSizePixelHeight = (double) robot1.getIconHeight();

        double displayedPixelWidth, displayedPixelHeight;
        if(fullSizePixelWidth > fullSizePixelHeight)
        {
            // Here, the image is wider than it is high, so we'll display it such that it's as
            // wide as a full grid cell, and the height will be set to preserve the aspect
            // ratio.
            displayedPixelWidth = gridSquareSize;
            displayedPixelHeight = gridSquareSize * fullSizePixelHeight / fullSizePixelWidth;
        }
        else
        {
            // Otherwise, it's the other way around -- full height, and width is set to
            // preserve the aspect ratio.
            displayedPixelHeight = gridSquareSize;
            displayedPixelWidth = gridSquareSize * fullSizePixelWidth / fullSizePixelHeight;
        }

        // Actually put the image on the screen.
        gfx.drawImage(icon.getImage(),
                (int) (x - displayedPixelWidth / 2.0),  // Top-left pixel coordinates.
                (int) (y - displayedPixelHeight / 2.0),
                (int) displayedPixelWidth,              // Size of displayed image.
                (int) displayedPixelHeight,
                null);
    }


    /**
     * Displays a string of text underneath a specific grid location. *Only* call this from within
     * paintComponent().
     *
     * You shouldn't need to modify this method.
     */
    private void drawLabel(Graphics2D gfx, String label, double gridX, double gridY)
    {
        gfx.setColor(Color.BLUE);
        FontMetrics fm = gfx.getFontMetrics();
        gfx.drawString(label,
                (int) ((gridX + 0.5) * gridSquareSize - (double) fm.stringWidth(label) / 2.0),
                (int) ((gridY + 1.0) * gridSquareSize) + fm.getHeight());
    }

    /**
     * Draws a (slightly clipped) line between two grid coordinates.
     *
     * You shouldn't need to modify this method.
     */
    private void drawLine(Graphics2D gfx, double gridX1, double gridY1,
                          double gridX2, double gridY2)
    {
        gfx.setColor(Color.RED);

        // Recalculate the starting coordinate to be one unit closer to the destination, so that it
        // doesn't overlap with any image appearing in the starting grid cell.
        final double radius = 0.5;
        double angle = Math.atan2(gridY2 - gridY1, gridX2 - gridX1);
        double clippedGridX1 = gridX1 + Math.cos(angle) * radius;
        double clippedGridY1 = gridY1 + Math.sin(angle) * radius;

        gfx.drawLine((int) ((clippedGridX1 + 0.5) * gridSquareSize),
                (int) ((clippedGridY1 + 0.5) * gridSquareSize),
                (int) ((gridX2 + 0.5) * gridSquareSize),
                (int) ((gridY2 + 0.5) * gridSquareSize));
    }
}
