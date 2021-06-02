import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.*;

public class UserSubject extends JFrame implements ActionListener
{
	private JLabel subject = new JLabel("SUBJECT'S ");
	private JComboBox<String> subjecttext = new JComboBox();
	private JPanel subpanel = new JPanel(); 
	private JButton selectb = new JButton("SELECT ");
	private JButton backb = new JButton("BACK ");
	private JButton logout = new JButton("LOGOUT ");

	Connection con;
	Statement stm ;
	ResultSet rs;
	String sub;
	public UserSubject()
	{
		this.setBounds(20,30,720,280);
		this.setTitle("SUBJECT");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        createregp();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    		String s = "select * from subjects";
    		rs = stm.executeQuery(s);
    		while(rs.next()) {
    			subjecttext.addItem(rs.getString(1));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR");
    	}finally {
    		 try
    	        {
    	        stm.close();
    	        rs.close();
    	        con.close();
    	        }
    	        catch(Exception e)
    	        {
    	        	e.printStackTrace();
    	        	JOptionPane.showMessageDialog(null, "ERROR CLOSE");
    	        }
    		 subpanel.add(subjecttext);
    		 this.getContentPane().add(subpanel);
    		}
        this.setVisible(true);
    	}
  	private void createregp()
	{
		subpanel.setLayout(null);
		subpanel.setBounds(0,0,720,280);
		subject.setBounds(20,30,90,20);
		subpanel.add(subject);
		subjecttext.setBounds(110,30,250,20);
		subpanel.add(subjecttext);
		logout.setBounds(600,10,100,30);
		logout.setBackground(Color.PINK);
		subpanel.add(logout);
		this.logout.addActionListener(this);
		subpanel.setBackground(Color.GRAY);
		selectb.setBounds(180,60,100,30);
		subpanel.add(selectb);
		this.selectb.addActionListener(this);
		backb.setBounds(180,100,100,30);
		subpanel.add(backb);
		this.backb.addActionListener(this);
		this.add(subpanel);
	}
	public void actionPerformed(ActionEvent e)
    {
		Object src = e.getSource();
		if(src == selectb)
		{
			this.sub=(String) subjecttext.getSelectedItem();
			System.out.println("selected sub is "+sub);
			this.setVisible(false);
			new SelectTeacher(sub);
		}
		else if(src == backb)
		{
			this.setVisible(false);
			new SelectFirst().userp();
		}
		else if(src == logout)
		{
			this.setVisible(false);
			new SelectFirst().userp();
		}
    }
	/*public static void main(String[] args)
	{
		UserSubject obj = new UserSubject();
	}*/
}
