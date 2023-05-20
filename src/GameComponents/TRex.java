package GameComponents;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TRex extends JPanel
{
    private final String IMAGE_PATH = "/Users/mark/Library/Mobile Documents/com~apple~CloudDocs/进行中项目/TRex.jpg";
    private final int ORIGIN_COORDINATE = 0;
    private final int TREX_WIDTH = 50;
    private final int TREX_HEIGHT = 53;
    private final int TREX_X_COORDINATE = 50;
    private final int TREX_Y_COORDINATE = 250;
    private final LayoutManager PANEL_LAYOUT = null;

    private ImageIcon image;
    private JLabel label;

    public TRex()
    {
        image = new ImageIcon(IMAGE_PATH);
        label = new JLabel(image);

        init();
    }

    private void init()
    {
        label.setBounds(ORIGIN_COORDINATE, ORIGIN_COORDINATE, TREX_WIDTH, TREX_HEIGHT);

        setLayout(PANEL_LAYOUT);
        setBounds(TREX_X_COORDINATE, TREX_Y_COORDINATE, TREX_WIDTH, TREX_HEIGHT);
        add(label);
    }
}
