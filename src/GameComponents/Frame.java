package GameComponents;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	private final String FRAME_TITLE = "T-Rex Run";
    private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 600;

    public Frame()
    {
		init();
    }

	private void init()
	{
		setTitle(FRAME_TITLE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
