package GameComponents;
import java.awt.Color;
import javax.swing.JPanel;

public class Ground extends JPanel
{
    public Ground()
    {
        init();
    }

    private void init()
    {
        setLayout(null);
        setBounds(0, 304, 1000, 3);
        setBackground(Color.DARK_GRAY);
    }
}
