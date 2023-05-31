package GameComponents;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class Cactus extends TRex
{
    private final int CACTUS_WIDTH = 34;            //cactus image width
    private final int CACTUS_HEIGHT = 70;           //cactus image height
    private final int CACTUS_Y_COORDINATE = 233;
    private final int CACTUS_X_COORDINATE = 916;

    private int distanceToGo;       //distance between left edge and current position
    private int moveDistance;       //moving distance of each movement
    private int sleepTime;          //sleepTime bettween travelling to the next pixel point
    private Area area;

    public Cactus(ImageIcon image)
    {
        super(image);
        distanceToGo = CACTUS_X_COORDINATE + 50;
        moveDistance = 1;
        sleepTime = 2;

        init();
    }

    private void init()
    {
        setLayout(null);
        this.setBounds(CACTUS_X_COORDINATE, CACTUS_Y_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);
    }
 
    @Override
    public void run() 
    {   
        for(int i = 0; i < distanceToGo; i++)
        {
            this.setLocation(getX() - moveDistance, CACTUS_Y_COORDINATE);
            area = new Area(this.getBounds());
            System.out.println("Cactus's bounds2D: " + this.area.getBounds2D());
            if(super.getArea().intersects(area.getBounds2D())){
                Thread.currentThread().interrupt();
            }
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
