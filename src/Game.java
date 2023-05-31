import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.util.Random;
import GameComponents.*;

public class Game
{
	private final static String IMAGE_PATH_TREX = "src/GameComponents/TRex.png";
    private final static ImageIcon IMAGE_TREX = new ImageIcon(IMAGE_PATH_TREX);

	private Frame frame;
	private TRex tRex;
	private Ground ground;
	private Random random;
	private Thread tRexThread;
	private Action jumpAction;
	private boolean isGaming;

    Game()
	{
		random = new Random();
		frame = new Frame();
		tRex = new TRex(IMAGE_TREX);
		ground = new Ground();
		tRexThread = new Thread(tRex);
		jumpAction = new JumpAction();
		isGaming = false;

		init();
	}

	private void init()
	{
		frame.add(tRex);
		frame.add(ground);
		frame.setVisible(true);
		tRex.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "jumpAction");
		tRex.getActionMap().put("jumpAction", jumpAction); 
	}	

	public void begin()
    {
		isGaming = true;
		try
		{
			while(isGaming)
			{
				//if(tRex.isColliding(frame.getCactusObjectList()))
				//{
					// isGaming = false;
					// Thread.currentThread().interrupt();
					// System.out.println("main thread interrupting...");
					// frame.terminate();
				//}
				frame.display();
				Thread.sleep(random.nextInt(1401) + 600);
			}
		} 
		catch (InterruptedException e) 
		{
			isGaming = false;
			System.out.println("main thread interrupted");
			return;
		}
	}

	public class JumpAction extends AbstractAction
	{
        @Override
        public void actionPerformed(ActionEvent e) 
		{
            tRexThread.start();
			tRexThread = new Thread(tRex);
        }
	}

	public static void main(String[] args)
	{
		Game game = new Game();
		game.begin();
	}
}