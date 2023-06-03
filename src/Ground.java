import java.awt.Color;
import javax.swing.JLabel;

public class Ground
{
    private final int GROUND_X_COORDINATE = 0;
    private final int GROUND_Y_COORDINATE = 404;
    private final int GROUND_WIDTH = 1000;
    private final int GROUND_HEIGHT = 3;

    private JLabel label;
    
    public Ground()
    {
        label = new JLabel();

        init();
    }

    private void init()
    {
        label.setLayout(null);
        label.setBounds(GROUND_X_COORDINATE, GROUND_Y_COORDINATE, GROUND_WIDTH, GROUND_HEIGHT);
        label.setBackground(Color.DARK_GRAY);
        label.setOpaque(true);
    }

    public JLabel getJLabel()
    {
        return label;
    }
}