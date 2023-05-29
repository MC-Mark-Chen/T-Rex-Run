package GameComponents;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cactus extends JLabel implements Runnable
{
    private final static String IMAGE_PATH = "src/GameComponents/Cactus.png";
    private final static ImageIcon IMAGE = new ImageIcon(IMAGE_PATH);
    private final int CACTUS_WIDTH = 34;            //cactus image width
    private final int CACTUS_HEIGHT = 70;           //cactus image height
    private final int CACTUS_Y_COORDINATE = 233;
    private final int CACTUS_X_COORDINATE = 916;

    private int distanceToGo;       //distance between left edge and current position
    private int moveDistance;       //moving distance of each movement
    private int sleepTime;          //sleepTime bettween travelling to the next pixel point

    public Cactus()
    {
        super(IMAGE);
        distanceToGo = CACTUS_X_COORDINATE + 50;
        moveDistance = 1;
        sleepTime = 2;

        init();
    }

    private void init()
    {
        setLayout(null);
        setBounds(CACTUS_X_COORDINATE, CACTUS_Y_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);
    }
 
    @Override
    public void run() 
    {   
        for(int i = 0; i < distanceToGo; i++)
        {
            setLocation(getX() - moveDistance, CACTUS_Y_COORDINATE);
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e)
            {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                return;
            }
        }
        System.out.println(Thread.currentThread().getName() + " is dead");
    }
}
