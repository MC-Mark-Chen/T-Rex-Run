package GameComponents;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cactus extends JPanel
{
    private ImageIcon image;
    private JLabel label;

    public Cactus()
    {
        image = new ImageIcon("/Users/mark/Library/Mobile Documents/com~apple~CloudDocs/进行中项目/Cactus.jpg");
        label = new JLabel(image);

        init();
    }

    private void init()
    {
        label.setBounds(0, 0, 34, 70);

        setLayout(null);
        setBounds(916, 233, 34, 70);
        add(label);
    }
}
