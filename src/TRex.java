import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TRex implements Runnable
{
    private final static String IMAGE_PATH = "src/TRex.png";
    private final static ImageIcon IMAGE = new ImageIcon(IMAGE_PATH);
    private final int TREX_WIDTH = 50;          //trex image width
    private final int TREX_HEIGHT = 53;         //trex image height
    private final int TREX_X_COORDINATE = 50;
    private final int TREX_Y_COORDINATE = 350;

    private static Rectangle rectangleLeft = new Rectangle();         //the left rectangle covering the trex (35 * 53)
    private static Rectangle rectangleRight = new Rectangle();            //the right rectangle covering the trex (15 * 28)
    private static Area areaLeft = new Area(rectangleLeft.getBounds());           //area of left rectangle covering the trex
    private static Area areaRight = new Area(rectangleRight.getBounds());          //area of right rectangle covering the trex
    private static boolean isRunning = true;

    private JLabel label;           //label containing trex image
    private int sleepTime;          //sleepTime bettween travelling to the next pixel point
    private double startTime;         //the time when the run() method begins
    private double timeInterval;          //the unit time for the TRex to move a unit distance
    private double newYCoordinate;          //new y coordinate after each unit time

    public TRex()
    {
        label = new JLabel(IMAGE);
        sleepTime = 1;
        startTime = 0;
        newYCoordinate = 0;

        init();
    }
    
    private void init()
    {
        label.setLayout(null);
        label.setBounds(TREX_X_COORDINATE, TREX_Y_COORDINATE, TREX_WIDTH, TREX_HEIGHT);
        rectangleLeft.setBounds(TREX_X_COORDINATE, TREX_Y_COORDINATE, 35, 53);
        rectangleRight.setBounds(TREX_X_COORDINATE + 35, TREX_Y_COORDINATE, 15, 28);
        areaLeft = new Area(rectangleLeft.getBounds());
        areaRight = new Area(rectangleRight.getBounds());
    }

    public Area getLeftArea(){
        return areaLeft;
    }

    public Area getRightArea()
    {
        return areaRight;
    }

    public JLabel getLabel()
    {
        return label;
    }

    public static void terminate()
    {
        Thread.currentThread().interrupt();
        System.out.println("TRex Thread interrupting... \t(At time " + System.currentTimeMillis() + ")");
        isRunning = false;
    }

    @Override
    public void run() 
    {
        if(isRunning)
        {
            startTime = System.nanoTime() * Math.pow(10, -9);
            while(label.getY() > 250)
            {
                try
                {
                    Thread.sleep(sleepTime);
                }
                catch(InterruptedException e){
                    System.out.println("TRex Thread interrupted");
                    return;
                }

                timeInterval = System.nanoTime() * Math.pow(10, -9) - startTime;
                newYCoordinate = TREX_Y_COORDINATE - Math.abs(100 * Math.sin(5.5 * timeInterval)) + 0.5;

                label.setLocation(TREX_X_COORDINATE, (int)newYCoordinate);

                rectangleLeft.setLocation(TREX_X_COORDINATE, (int)newYCoordinate);
                rectangleRight.setLocation(TREX_X_COORDINATE + 35, (int)newYCoordinate);
                areaLeft = new Area(rectangleLeft.getBounds());
                areaRight = new Area(rectangleRight.getBounds());
            }
            while(label.getY() < 350)
            {
                try
                {
                    Thread.sleep(sleepTime);
                }
                catch(InterruptedException e){
                    System.out.println("TRex Thread interrupted");
                    return;
                }
                timeInterval = System.nanoTime() * Math.pow(10, -9) - startTime;
                newYCoordinate = TREX_Y_COORDINATE - Math.abs(100 * Math.sin(5.5 * timeInterval)) + 0.5;

                label.setLocation(TREX_X_COORDINATE, (int)newYCoordinate);

                rectangleLeft.setLocation(TREX_X_COORDINATE, (int)newYCoordinate);
                rectangleRight.setLocation(TREX_X_COORDINATE + 35, (int)newYCoordinate);
                areaLeft = new Area(rectangleLeft.getBounds());
                areaRight = new Area(rectangleRight.getBounds());
            }
        }
    }
}