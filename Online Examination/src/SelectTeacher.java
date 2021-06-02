import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.*;
import java.sql.*;

public class SelectTeacher extends JFrame implements ActionListener
{
	private JLabel teachers = new JLabel("TEACHER'S ");
	private JComboBox<String> teacherstext = new JComboBox();
	private JPanel teacherpanel = new JPanel();
	private JButton selectb = new JButton("SELECT ");
	private JButton backb = new JButton("BACK ");
	private JButton logout = new JButton("LOGOUT ");
    private String teacher;
	Connection con;
	Statement stm ;
	ResultSet rs;
	String sub;
	public SelectTeacher(String sub)
	{
		this.sub = sub;
		this.setBounds(20,30,720,280);
		this.setTitle("TEACHER");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
		createregp();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
       try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    		String s = "select Fname from teacherreg where subject = '"+sub+"'";
    		//String t = "select subject from teacherreg where subject = '"+sub+"'";
    		rs = stm.executeQuery(s);
    		while(rs.next()) {
    			teacherstext.addItem(rs.getString(1));
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
    		 teacherpanel.add(teacherstext);
    		 this.getContentPane().add(teacherpanel);
    	        this.setVisible(true);
    		}
    	}
	private void createregp()
	{
		teacherpanel.setLayout(null);
		teacherpanel.setBounds(0,0,720,280);
		teachers.setBounds(20,30,90,20);
		teacherpanel.add(teachers);
		teacherstext.setBounds(110,30,250,20);
		teacherpanel.add(teacherstext);
		logout.setBounds(600,10,100,30);
		logout.setBackground(Color.PINK);
		this.logout.addActionListener(this);
		teacherpanel.add(logout);
		selectb.setBounds(180,60,100,30);
		teacherpanel.add(selectb);
		this.selectb.addActionListener(this);
		backb.setBounds(180,100,100,30);
		teacherpanel.add(backb);
		teacherpanel.setBackground(Color.GRAY);
		this.backb.addActionListener(this);
		this.add(teacherpanel);
	}
	
	public void actionPerformed(ActionEvent e)
    {
		Object src = e.getSource();
		
		if(src == selectb)
		{
			this.teacher=(String) teacherstext.getSelectedItem();
			System.out.println("selected teacher is "+teacher);
			this.setVisible(false);
			new SelectQuestion(teacher);
		}
		else if(src == backb)
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
	
	public String sub()
	{
		return sub;
	}
	/*public static void main(String[] args)
	{
		SelectTeacher obj = new SelectTeacher("java");
	}*/

}
