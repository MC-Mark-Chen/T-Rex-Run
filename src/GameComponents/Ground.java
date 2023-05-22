package GameComponents;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class Ground extends JPanel
{
    private final int GROUND_X_COORDINATE = 0;
    private final int GROUND_Y_COORDINATE = 304;
    private final int GROUND_WIDTH = 1000;
    private final int GROUND_HEIGHT = 3;
    private final LayoutManager PANEL_LAYOUT = null;
    
    public Ground()
    {
        init();
    }

    private void init()
    {
        setLayout(PANEL_LAYOUT);
        setBounds(GROUND_X_COORDINATE, GROUND_Y_COORDINATE, GROUND_WIDTH, GROUND_HEIGHT);
        setBackground(Color.DARK_GRAY);
    }
}
