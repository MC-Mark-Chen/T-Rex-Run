package GameComponents;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	private final static String IMAGE_PATH_CACTUS = "src/GameComponents/Cactus.png";
    private final static ImageIcon IMAGE_CACTUS = new ImageIcon(IMAGE_PATH_CACTUS);
	private final String FRAME_TITLE = "T-Rex Run";
    private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 600;

	private Cactus cactusObject;
	private Thread cactusThread;
	private ArrayList<Cactus> cactusObjectList;
	private ArrayList<Thread> cactusThreadList;
	private int id;

    public Frame()
    {
		id = 0;
		cactusObjectList = new ArrayList<Cactus>();
		cactusThreadList = new ArrayList<Thread>();

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

	public void display()
	{
		cactusObject = new Cactus(IMAGE_CACTUS);
		add(cactusObject);
		cactusObjectList.add(cactusObject);
		cactusThread = new Thread(cactusObject, "Cactus Thread " + id);
		cactusThreadList.add(cactusThread);
		cactusThread.start();
		id++;
	}

	public void terminate()
	{
		for(int i = cactusThreadList.size() - 1; i >= 0; i--)
		{
			cactusThreadList.get(i).interrupt();
			System.out.println(cactusThreadList.get(i).getName() + " interrupting... (" + cactusThreadList.size() + " in total)");
		}
	}

	public ArrayList<Cactus> getCactusObjectList()
	{
		return cactusObjectList;
	}
}
