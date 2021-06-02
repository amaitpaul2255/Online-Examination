import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class timeopen extends JFrame implements ActionListener
{
	private JLabel heading = new JLabel();
	private JButton open = new JButton("OPEN ");
	private JButton stop = new JButton("STOP ");
	private JButton logout = new JButton("LOGOUT ");
	private JButton back = new JButton("BACK ");
	Connection conn;
	Statement stmt ;
	String question;

	public timeopen(String s)
	{
		question=s;
		this.setTitle("EXAMINATION TIME CONTROL");
        this.setBounds(20,30,720,400);
    	createopenbutton();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //constructor
        try
    	{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stmt = conn.createStatement();
    		System.out.println("connected"+conn);
    	}
        catch(Exception e3)
        {
        	e3.printStackTrace();
        }
        
        this.setVisible(true);
	}
	public void createopenbutton()
	{
		open.setBounds(290,100,130,50);
    	this.open.addActionListener(this);
		this.add(open);
		heading.setBounds(200,10,300,20);
		heading.setText("EXAM STARTED FOR  '"+question+"'  QUESTION");
		this.add(heading);
		stop.setBounds(290, 160, 130, 50);
    	this.stop.addActionListener(this);
		this.add(stop);
		//logout.setBounds(400, 100, 130,30);
    	//this.logout.addActionListener(this);
		//this.add(logout);
	}
	public void addingback()
	{
		this.setBackground(Color.GRAY);
		back.setBounds(590, 250, 100, 30);
		this.add(back);
		this.back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		if(src == open)
		{
			
		}
		else if(src == stop)
		{
			addingback();
			this.repaint();
		}
		else if(src == back)
		{
			this.setVisible(false);
			new Updateqselect();
		}
		
	}
	/*public static void main(String[] args)
	{
		new timeopen();
	}*/
	
}
