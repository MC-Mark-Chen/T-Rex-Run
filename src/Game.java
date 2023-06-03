import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.KeyStroke;
import java.util.Random;

public class Game implements ActionListener
{
	private static boolean isGaming = false;
	private static long startTime = 0;
	private static long endTime = 0;

	private Frame frame;
	private TRex tRex;
	private Ground ground;
	private JLabel groundObject;
	private Random random;
	private Thread tRexThread;
	private Action jumpAction;
	private Action restartAction;
	private JLabel tRexObject;
	private JFrame frameObject;
	private StartFrame startFrame;
	private JLabel startLabelObject;
	private JButton startButtonObject;

    Game()
	{
		random = new Random();
		frame = new Frame();
		tRex = new TRex();
		ground = new Ground();
		groundObject = ground.getJLabel();
		tRexThread = new Thread(tRex);
		jumpAction = new JumpAction();
		restartAction = new RestartAction();
		tRexObject = tRex.getLabel();
		frameObject = frame.getFrame();
		startFrame = new StartFrame();
		startLabelObject = startFrame.getLabel();
		startButtonObject = startFrame.geButton();
		frameObject.add(startLabelObject);
		frameObject.add(startButtonObject);
		frameObject.setVisible(true);
	}

	private void init()
	{
		frameObject.remove(startLabelObject);
		frameObject.remove(startButtonObject);
		frameObject.add(tRexObject);
		frameObject.add(groundObject);
		frameObject.setVisible(true);

		tRexObject.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "jumpAction");
		tRexObject.getInputMap().put(KeyStroke.getKeyStroke("UP"), "jumpAction");
		tRexObject.getActionMap().put("jumpAction", jumpAction); 
		tRexObject.getInputMap().put(KeyStroke.getKeyStroke("R"), "restartAction");
		tRexObject.getActionMap().put("restartAction", restartAction); 

		startButtonObject.addActionListener(this);
	}	

	public static void setGamingStatus()
	{
		isGaming = !isGaming;
	}

	public static void setEndTime(long time)
	{
		endTime = time;
	}

	public static String getTimeDuration()
	{
		DecimalFormat limitation = new DecimalFormat("#.###");
		return limitation.format((endTime - startTime) / 1000.0);
	}

	public void begin()
    {
		isGaming = true;
		startTime = System.currentTimeMillis();
		while(isGaming)
		{
			frame.start();
			System.out.println("runned");
			try
			{
				Thread.sleep(random.nextInt(1401) + 600);
			}
			catch (InterruptedException e) {}
		} 
	}

	private class JumpAction extends AbstractAction
	{
        @Override
        public void actionPerformed(ActionEvent e) 
		{
            tRexThread.start();
			tRexThread = new Thread(tRex);
        }
	}

	private class RestartAction extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
		}
	}

	public static void main(String[] args)
	{
		new Game();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == startButtonObject)
		{
			// frameObject.remove(startLabelObject);
			// frameObject.remove(startButtonObject);

			init();
		}
	}
}