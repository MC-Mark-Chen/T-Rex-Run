package GameComponents;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	private final String FRAME_TITLE = "T-Rex Run";
    private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 600;
	private final LayoutManager PANEL_LAYOUT = null;
	private final Component LOCATION_RELATIVE_COMPONENT = null;
	private final boolean RESIZABILITY = false;

    public Frame()
    {
		init();
    }

	private void init()
	{
		setTitle(FRAME_TITLE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(PANEL_LAYOUT);
		setLocationRelativeTo(LOCATION_RELATIVE_COMPONENT);
		setResizable(RESIZABILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
