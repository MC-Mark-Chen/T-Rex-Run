package GameComponents;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cactus extends JPanel
{
    private final String IMAGE_PATH = "/Users/mark/Library/Mobile Documents/com~apple~CloudDocs/进行中项目/Cactus.jpg";
    private final int ORIGIN_COORDINATE = 0;
    private final int CACTUS_WIDTH = 34;
    private final int CACTUS_HEIGHT = 70;
    private final int CACTUS_X_COORDINATE = 916;
    private final int CACTUS_Y_COORDINATE = 233;
    private final LayoutManager PANEL_LAYOUT = null;

    private ImageIcon image;
    private JLabel label;

    public Cactus()
    {
        image = new ImageIcon(IMAGE_PATH);
        label = new JLabel(image);

        init();
    }

    private void init()
    {
        label.setBounds(ORIGIN_COORDINATE, ORIGIN_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);

        setLayout(PANEL_LAYOUT);
        setBounds(CACTUS_X_COORDINATE, CACTUS_Y_COORDINATE, CACTUS_WIDTH, CACTUS_HEIGHT);
        add(label);
    }
}
