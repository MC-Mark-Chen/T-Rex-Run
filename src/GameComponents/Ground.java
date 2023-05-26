package GameComponents;
import java.awt.Color;
import javax.swing.JLabel;

public class Ground extends JLabel
{
    private final int GROUND_X_COORDINATE = 0;
    private final int GROUND_Y_COORDINATE = 304;
    private final int GROUND_WIDTH = 1000;
    private final int GROUND_HEIGHT = 3;
    
    public Ground()
    {
        init();
    }

    private void init()
    {
        setLayout(null);
        setBounds(GROUND_X_COORDINATE, GROUND_Y_COORDINATE, GROUND_WIDTH, GROUND_HEIGHT);
        setBackground(Color.DARK_GRAY);
        setOpaque(true);
    }
}
