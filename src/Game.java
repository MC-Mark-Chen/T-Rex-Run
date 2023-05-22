import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import GameComponents.Cactus;
import GameComponents.Frame;
import GameComponents.Ground;
import GameComponents.TRex;

public class Game implements KeyListener 
{
	private final int CACTUS_INIT_X_COORDINATE = 900;
	private final int CACTUS_START_X_COORDINATE = 916;

	private Frame frame;
	private TRex tRex;
	private Cactus cactus;
	private Ground ground;

	private ArrayList<Cactus> cactusList;
	private Random random;
	private Thread thread;

	private boolean gameOn;
	private int idx;
	private int cactusCurrentX;

    Game()
	{
		frame = new Frame();
		tRex = new TRex();
		cactus = new Cactus(CACTUS_START_X_COORDINATE);
		ground = new Ground();
		cactusList = new ArrayList<Cactus>();
		random = new Random();
		gameOn = false;
		idx = -1;
		cactusCurrentX = CACTUS_START_X_COORDINATE;
		thread = new Thread(cactus);

		init();
	}

	private void init()
	{
		frame.addKeyListener(this);
		frame.add(tRex);
		frame.add(ground);
		frame.add(cactus);
		frame.setVisible(true);
	}	

	public void begin()
    {
		thread.start();
	}

    @Override
    public void keyPressed(KeyEvent e) 
	{
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {

        }
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	public static void main(String[] args)
	{
		Game game = new Game();
		game.begin();
	}
}