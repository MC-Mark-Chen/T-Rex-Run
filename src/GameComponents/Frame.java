package GameComponents;
import javax.swing.JFrame;

public class Frame extends JFrame
{
    private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 600;

    public Frame()
    {
		setTitle("T-Rex Run");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
    }
}
