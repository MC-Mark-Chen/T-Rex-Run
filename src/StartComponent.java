import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StartComponent extends Game implements ActionListener
{
    private JLabel label;
	private JButton button;

    public StartComponent()
    {
        super();
        
        label = new JLabel("Welcome to the TRex-Run game");
		button = new JButton("Start");

        init();
    }

    private void init()
    {
        label.setLayout(null);
		label.setBounds(130,70, 740, 100);
		label.setFont(new Font("Calibri", Font.BOLD, 30));

		button.setLayout(null);
		button.setBounds(130,170, 100, 70);
		button.setFont(new Font("Calibri", Font.BOLD, 30));
        button.addActionListener(this);

        super.getFrame().add(label);
        super.getFrame().add(button);
        super.getFrame().setVisible(true);
    }

    public JLabel getLabel()
    {
        return label;
    }

    public JButton getButton()
    {
        return button;
    }

    @Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == button)
		{
            super.getFrame().getContentPane().remove(button);
            super.getFrame().getContentPane().remove(label);
            super.begin();
		}
	}
}