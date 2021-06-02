import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.*;
import java.sql.*;

public class Result extends JFrame implements ActionListener
{
	private JLabel r = new JLabel();
	private JButton back = new JButton("BACK ");
	private JButton logout = new JButton("LOGOUT ");
	private JPanel rpanel = new JPanel();
	
	public Result(int mark)
	{
		this.setBounds(30,30,720,280);
		this.setTitle("RESULT");
        this.setLayout(null);
        rpanel.setLayout(null);
        rpanel.setBounds(0,0,720,280);
		r.setBounds(240,60,250,20);
		r.setText("Your Mark Of This Exam Is :  "+mark);
		rpanel.add(r);
		back.setBounds(290,130,70,30);
		back.setBackground(Color.cyan);
		rpanel.add(back);
		this.back.addActionListener(this);
		logout.setBounds(580,10,100,30);
		logout.setBackground(Color.PINK);
		rpanel.add(logout);
		this.logout.addActionListener(this);
		this.repaint();
		rpanel.setBackground(Color.GRAY);
		this.add(rpanel);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		if(src == back)
		{
			this.setVisible(false);
			new UserSubject();
		}
		else if(src == logout)
		{
			this.setVisible(false);
			new SelectFirst().userp();
		}
	}
	/*public static void main(String[] args)
	{
		new Result(7);
	}*/
	

}
