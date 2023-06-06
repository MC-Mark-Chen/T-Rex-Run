import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.KeyStroke;
import java.util.Random;

public class Game
{
	private static boolean isGaming = false;
	private static long startTime = 0;
	private static long endTime = 0;

	private Frame frame;
	private JFrame frameObject;
	
	private TRex tRex;
	private JLabel tRexObject;
	private Thread tRexThread;

	private Ground ground;
	private JLabel groundObject;

	private Random random;

	private Action jumpAction;
	private Action restartAction;

    Game()
	{
		frame = new Frame();
		frameObject = frame.getFrame();

		tRex = new TRex();
		tRexObject = tRex.getLabel();
		tRexThread = new Thread(tRex);

		ground = new Ground();
		groundObject = ground.getJLabel();

		random = new Random();

		jumpAction = new JumpAction();
		restartAction = new RestartAction();
	}

	public void begin()
    {
		frameObject.getContentPane().repaint();
		frameObject.getContentPane().add(tRexObject);
		frameObject.getContentPane().add(groundObject);
		frameObject.setVisible(true);

		// Request focus on tRexObject, ensure that it receives the keystrokes and can respond to the corresponding actions correctly
		tRexObject.requestFocusInWindow();

		//assigning specific keys to motions: space & up arrow for jumping, R for restarting
		tRexObject.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "jumpAction");
		tRexObject.getInputMap().put(KeyStroke.getKeyStroke("UP"), "jumpAction");
		tRexObject.getActionMap().put("jumpAction", jumpAction); 
		tRexObject.getInputMap().put(KeyStroke.getKeyStroke("R"), "restartAction");
		tRexObject.getActionMap().put("restartAction", restartAction); 
		
		new Thread(()->
		{
			isGaming = true;
			startTime = System.currentTimeMillis();
		
			while(isGaming)
			{
				frame.start();

				try
				{
					Thread.sleep(random.nextInt(1401) + 600);
				}
				catch (InterruptedException e) {}
			} 
		}).start();

	}

	public static void setGamingStatus()
	{
		isGaming = !isGaming;
	}

	public static void setEndTime(long time)
	{
		endTime = time;
	}

	public JFrame getFrame()
	{
		return frameObject;
	}

	public static String getTimeDuration()
	{
		DecimalFormat limitation = new DecimalFormat("#.###");
		return limitation.format((endTime - startTime) / 1000.0);
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
			//reset Game variables
			isGaming = false;
			startTime = 0;
			endTime = 0;
			
			//remove all GUI
			frameObject.getContentPane().removeAll();
			frameObject.getContentPane().repaint();

			//add back the resultLabels
			frameObject.getContentPane().add(Frame.resultLabel1);
			frameObject.getContentPane().add(Frame.resultLabel2);
			Frame.resultLabel1.setText("");
			Frame.resultLabel2.setText("");
	
			//reinitialize tRex
			tRex.reset();
	
			begin();
		}
	}
	
	public static void main(String[] args)
	{
		new StartComponent();
	}
}