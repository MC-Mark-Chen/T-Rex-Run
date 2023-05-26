import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.KeyStroke;
import java.util.Random;

import GameComponents.Cactus;
import GameComponents.Frame;
import GameComponents.Ground;
import GameComponents.TRex;

public class Game
{
	private Frame frame;
	private TRex tRex;
	private Ground ground;

	private ArrayList<Cactus> cactusObjectList;			//to store potential cactus objects
	private ArrayList<Thread> cactusThreadList;
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

		cactusObjectList = new ArrayList<Cactus>();
		cactusThreadList = new ArrayList<Thread>();
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
		while(isGaming)
		{
			Cactus cactusObject = new Cactus();
			frame.add(cactusObject);
			cactusObjectList.add(cactusObject);
			Thread cactusThread = new Thread(cactusObject);
			cactusThreadList.add(cactusThread);
			cactusThread.start();

			if(tRex.isTouching(cactusObjectList))
			{
				if(cactusThreadList.size() / 2 == 0)
				{
					for(int i = cactusObjectList.size() / 2; i >= 0; i--)
					{
						cactusThreadList.get(i).interrupt();
					}
				}
				for(int i = cactusObjectList.size() - 1; i >= 0; i--)
				{
					cactusThreadList.get(i).interrupt();
				}
				break;
			}

			try {
				Thread.sleep(random.nextInt(1401) + 600);
			} catch (InterruptedException e) {}
		}
	}

	public class JumpAction extends AbstractAction
	{
        @Override
        public void actionPerformed(ActionEvent e) {
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