package Components;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TRex extends JPanel
{
    private ImageIcon image;
    private JLabel label;

    public TRex()
    {
        image = new ImageIcon("/Users/mark/Library/Mobile Documents/com~apple~CloudDocs/进行中项目/TRex.jpg");
        label = new JLabel(image);

        init();
    }

    private void init()
    {
        label.setBounds(0, 0, 50, 53);

        setLayout(null);
        setBounds(50, 250, 50, 53);
        add(label);
    }
}
