package GameComponents;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TRex extends JLabel implements Runnable
{
    private final static String IMAGE_PATH = "src/GameComponents/TRex.png";
    private final static ImageIcon IMAGE = new ImageIcon(IMAGE_PATH);
    private final int TREX_WIDTH = 50;          //trex image width
    private final int TREX_HEIGHT = 53;         //trex image height
    private final int TREX_X_COORDINATE = 50;
    private final int TREX_Y_COORDINATE = 250;

    private int distanceToGo;           //distance between jumping peak point and current position
    private int moveDistance;           //moving distance of each movement
    private int sleepTime;          //sleepTime bettween travelling to the next pixel point

    public TRex()
    {
        super(IMAGE);

        distanceToGo = 85;
        moveDistance = 2;
        sleepTime = 3;

        init();
    }

    private void init()
    {
        setLayout(null);
        setBounds(TREX_X_COORDINATE, TREX_Y_COORDINATE, TREX_WIDTH, TREX_HEIGHT);
    }

    public boolean isTouching(ArrayList<Cactus> arrl)
    {
        for(int i = 0; i < arrl.size(); i++)
        {
            if((getX() >= arrl.get(i).getX() - 50) && (getX() <= arrl.get(i).getX() + 34))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() 
    {
        for(int i = 0; i < distanceToGo; i++)
        {
            setBounds(TREX_X_COORDINATE, getY() - moveDistance, TREX_WIDTH, TREX_HEIGHT);
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e){}
        }
        while(getY() < 250)
        {
            setBounds(TREX_X_COORDINATE, getY() + moveDistance, TREX_WIDTH, TREX_HEIGHT);
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e){}
        }
    }
}
