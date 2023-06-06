import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cactus extends TRex
{
    private final static String IMAGE_PATH = "src/Cactus.png";
    private final static ImageIcon IMAGE = new ImageIcon(IMAGE_PATH);
    private final int CACTUS_WIDTH = 34;            //cactus image width
    private final int CACTUS_HEIGHT = 70;           //cactus image height
    private final int CACTUS_Y_COORDINATE = 333;            //starting x coordinate
    private final int CACTUS_X_COORDINATE = 916;            //starting y coordinate

    private static boolean isRunning = true;

    private JLabel label;           //label containing cactus image
    private int distanceToGo;       //distance between left edge and current position
    private int moveDistance;       //moving distance of each movement
    private int sleepTime;          //sleepTime bettween travelling to the next pixel point
    private Area areaLeft;          //area of left rectangle covering the cactus
    private Area areaCenter;        //area of center rectangle covering the cactus
    private Area areaRight;         //area of right rectangle covering the cactus
    //用了三个长方形，因为仙人掌的形状从左到右逐渐变高，用这些长方形来判断恐龙是否与仙人掌接触
    private Rectangle rectangleLeft;            //the left rectangle covering the cactus (17 * 52)
    private Rectangle rectangleCenter;          //the center rectangle covering the cactus (6 * 61)
    private Rectangle rectangleRight;           //the right rectangle covering the cactus (11 * 70)

    public Cactus()
    {
        label = new JLabel(IMAGE);
        distanceToGo = CACTUS_X_COORDINATE + 50;
        moveDistance = 1;
        sleepTime = 2;
        rectangleLeft = new Rectangle();
        rectangleCenter = new Rectangle();
        rectangleRight = new Rectangle();

        init();
    }
     
    private void init()
    {
        label.setLayout(null);
        label.setBounds(CACTUS_X_COORDINATE, CACTUS_Y_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);
        rectangleLeft.setBounds(CACTUS_X_COORDINATE, CACTUS_Y_COORDINATE + 18, 17, 52);
        rectangleCenter.setBounds(CACTUS_X_COORDINATE + 17, CACTUS_Y_COORDINATE + 9, 6, 61);
        rectangleRight.setBounds(CACTUS_X_COORDINATE + 23, CACTUS_Y_COORDINATE, 11, CACTUS_HEIGHT);
    }

    public JLabel getLabel()
    {
        return label;
    }

    public boolean getRunningStatus()
    {
        return isRunning;
    }
 
    @Override
    public void run() 
    {
        for(int i = 0; i < distanceToGo; i++)
        {
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e)
            {
                System.out.println(Thread.currentThread().getName() + " interrupted \t(At time " + System.currentTimeMillis() + ")");          //object will catch InterruptedExveption if it is asked to sleep while being interrupted
                return;
            }

            label.setLocation(label.getX() - moveDistance, CACTUS_Y_COORDINATE);
            
            rectangleLeft.setLocation(label.getX() - moveDistance, CACTUS_Y_COORDINATE + 18);
            rectangleCenter.setLocation(label.getX() + 17 - moveDistance, CACTUS_Y_COORDINATE + 9);
            rectangleRight.setLocation(label.getX() + 23 - moveDistance, CACTUS_Y_COORDINATE);

            areaLeft = new Area(rectangleLeft.getBounds());
            areaCenter = new Area(rectangleCenter.getBounds());
            areaRight = new Area(rectangleRight.getBounds());

            //to check whether the trex has collide with the cactus
            if(super.getLeftArea().intersects(areaLeft.getBounds2D()) 
                || super.getLeftArea().intersects(areaCenter.getBounds2D()) 
                    || super.getLeftArea().intersects(areaRight.getBounds2D()) 
                        || super.getRightArea().intersects(areaLeft.getBounds2D()) 
                            || super.getRightArea().intersects(areaCenter.getBounds2D()) 
                                || super.getRightArea().intersects(areaRight.getBounds2D()))
            {
                Thread.currentThread().interrupt();         //interrupt current cactus' thread
                Game.setGamingStatus();         //pause the central method begin() in class Game
                Game.setEndTime(System.currentTimeMillis());
                Frame.terminate();          //terminate the rest of the cactuses in the frame
                TRex.terminate();           //terminate the trex
            }
        }
        
        System.out.println(Thread.currentThread().getName() + " is dead \t(At time " + System.currentTimeMillis() + ")");
    }
}