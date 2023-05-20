import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Components.Cactus;
import Components.Frame;
import Components.Ground;
import Components.TRex;

public class Game implements KeyListener 
{
	private Frame frame;
	private TRex tRex;
	private Cactus cactus;
	private Ground ground;

    Game()
	{
		frame = new Frame();
		tRex = new TRex();
		cactus = new Cactus();
		ground = new Ground();

		init();
	}

	private void init()
	{
		frame.addKeyListener(this);
		frame.add(tRex);
		frame.add(cactus);
		frame.add(ground);
		frame.setVisible(true);
	}	

	public void begin()
    {
		
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
		Game start = new Game();
		start.begin();
	}
}