import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.util.Random;
import GameComponents.*;

public class Game
{
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
		tRex = new TRex();
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
				if(tRex.isColliding(frame.getCactusObjectList()))
				{
					isGaming = false;
					Thread.currentThread().interrupt();
					System.out.println("main thread interrupting...");
					frame.terminate();
				}
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