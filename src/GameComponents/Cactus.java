package GameComponents;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cactus extends JPanel implements Runnable
{
    private final String IMAGE_PATH = "/Users/mark/Library/CloudStorage/OneDrive-个人/AP CSA/Coding Assignments/FinalProject1Resources/Cactus.jpg";
    private final int ORIGIN_COORDINATE = 0;
    private final int CACTUS_WIDTH = 34;
    private final int CACTUS_HEIGHT = 70;
    private final int CACTUS_Y_COORDINATE = 233;
    private final LayoutManager PANEL_LAYOUT = null;

    private ImageIcon image;
    private JLabel label;

    private int cactusXCoordinate;
    int distanceToGo;
    int moveSpeed;
    int sleepTime;

    public Cactus(int xCoordinate)
    {
        image = new ImageIcon(IMAGE_PATH);
        label = new JLabel(image);

        cactusXCoordinate = xCoordinate;
        distanceToGo = cactusXCoordinate - 100;
        moveSpeed = 1;
        sleepTime = 10;

        init();
    }

    private void init()
    {
        label.setBounds(ORIGIN_COORDINATE, ORIGIN_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);

        setLayout(PANEL_LAYOUT);
        setBounds(cactusXCoordinate, CACTUS_Y_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);
        add(label);
    }

    @Override
    public void run() {

        for(int i = 0; i < distanceToGo; i++)
        {
            cactusXCoordinate -= moveSpeed;
            setBounds(cactusXCoordinate, CACTUS_Y_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);
            try
            {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException e){}
        }
    }
}
