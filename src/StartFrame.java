import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StartFrame
{
    private JLabel label;
	private JButton button;

    public StartFrame()
    {
        label = new JLabel("Welcome to the TRex-Run game");
		button = new JButton("Start");

        init();
    }

    private void init()
    {
        label.setLayout(null);
		label.setBounds(130,70, 740, 100);
		label.setFont(new Font("Calibri", Font.BOLD, 30));

		button.setLayout(null);
		button.setBounds(130,170, 100, 70);
		button.setFont(new Font("Calibri", Font.BOLD, 30));
    }

    public JLabel getLabel()
    {
        return label;
    }

    public JButton geButton()
    {
        return button;
    }
}