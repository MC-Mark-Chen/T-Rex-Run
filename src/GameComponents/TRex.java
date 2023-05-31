package GameComponents;
import java.awt.geom.Area;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TRex extends JLabel implements Runnable
{
    private final int TREX_WIDTH = 50;          //trex image width
    private final int TREX_HEIGHT = 53;         //trex image height
    private final int TREX_X_COORDINATE = 50;
    private final int TREX_Y_COORDINATE = 250;

    private int sleepTime;          //sleepTime bettween travelling to the next pixel point
    private double startTime;         //the time when the run() method begins
    private double timeInterval;          //the unit time for the TRex to move a unit distance
    private double newYCoordinate;          //new y coordinate after each unit time

    public TRex(ImageIcon image)
    {
        super(image);
        sleepTime = 1;
        startTime = 0;
        newYCoordinate = 0;

        init();
    }
    
    private void init()
    {
        setLayout(null);
        this.setBounds(TREX_X_COORDINATE, TREX_Y_COORDINATE, TREX_WIDTH, TREX_HEIGHT);
    }

    public Area getArea(){
        System.out.println("TRex's bounds: " + this.getBounds());
        System.out.println("TRex's location: " + this.getLocation());
        return new Area(this.getBounds());
    }

    // public boolean isColliding(ArrayList<Cactus> arrl)
    // {
    //     for(int i = arrl.size() - 1; i >= 0; i--)
    //     {
    //         areaTRex = new Area(getBounds());
    //         areaCactus = new Area(arrl.get(i).getBounds());
    //         System.out.println(areaTRex.getBounds());
    //         System.out.println(areaCactus.getBounds());
    //         if(areaTRex.intersects(areaCactus.getBounds2D()))
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    @Override
    public void run() 
    {
        startTime = System.nanoTime() * Math.pow(10, -9);
        while(getY() > 165)
        {
            timeInterval = System.nanoTime() * Math.pow(10, -9) - startTime;
            newYCoordinate = TREX_Y_COORDINATE - Math.abs(85 * Math.sin(6 * timeInterval)) + 0.5;
            this.setLocation(TREX_X_COORDINATE, (int)newYCoordinate);
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e){}
        }
        while(getY() < 250)
        {
            timeInterval = System.nanoTime() * Math.pow(10, -9) - startTime;
            newYCoordinate = TREX_Y_COORDINATE - Math.abs(85 * Math.sin(6 * timeInterval)) + 0.5;
            this.setLocation(TREX_X_COORDINATE, (int)newYCoordinate);
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e){}
        }
    }
}
