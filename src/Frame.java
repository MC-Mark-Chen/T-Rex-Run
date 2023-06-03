import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame
{
	private final String FRAME_TITLE = "T-Rex Run";
    private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 600;

	private static JFrame frame = new JFrame();
	private static JLabel resultLabel1 = new JLabel("");
	private static JLabel resultLabel2 = new JLabel("");
	private static ArrayList<Thread> cactusThreadList = new ArrayList<Thread>();

	private Cactus cactus;
	private Thread cactusThread;
	private int id;
	private JLabel cactusObject;

    public Frame()
    {
		id = 0;

		init();
    }

	private void init()
	{
		frame.setTitle(FRAME_TITLE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultLabel1.setLayout(null);
		resultLabel1.setBounds(130,70, 740, 100);
		resultLabel1.setFont(new Font("Calibri", Font.BOLD, 30));
		resultLabel2.setLayout(null);
		resultLabel2.setBounds(130,180, 740, 100);
		resultLabel2.setFont(new Font("Calibri", Font.BOLD, 30));
		frame.add(resultLabel1);
		frame.add(resultLabel2);
	}

	public void start()
	{
		cactus = new Cactus();
		cactusObject = cactus.getLabel();
		frame.add(cactusObject);
		cactusThread = new Thread(cactus, "Cactus Thread " + id);
		cactusThreadList.add(cactusThread);
		cactusThread.start();
		id++;
	}

	private static void displayResult()
	{
		resultLabel1.setText("Your have survived for " + Game.getTimeDuration() + " seconds!");
		resultLabel2.setText("Click \"R\" to restart.");
	}

	public static void terminate()
	{
		displayResult();
		for(int i = cactusThreadList.size() - 1; i >= 0; i--)
		{
			cactusThreadList.get(i).interrupt();
			System.out.println(cactusThreadList.get(i).getName() + " interrupting... (At time " 
					+ System.currentTimeMillis() + ")");
		}
	}

	public JFrame getFrame()
	{
		return frame;
	}
}