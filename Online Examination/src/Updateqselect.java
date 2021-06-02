import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.*;
import java.sql.*;

public class Updateqselect extends JFrame implements ActionListener
{
	private JButton update= new JButton("ADD ");
	private JButton select= new JButton("SELECT");
	private JButton logout= new JButton("LOGOUT");
	private JButton newcreate= new JButton("NEW  CREATE");
	private JLabel qname = new JLabel("QUESTION NAME :");
	private JButton back = new JButton("BACK");
	private JComboBox question = new JComboBox();
	Connection con;
	Statement stm ;
	ResultSet rs;
	String selectq;
	
	public Updateqselect()
	{
		this.setTitle("TEACHERS PANEL");
		this.setBounds(30,30,720,400);
		this.setLayout(null);
		this.setBackground(Color.RED);
        this.repaint();
		create();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //constructor
        try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    		String s = "select Questionname from teachersquestion";
    		rs = stm.executeQuery(s);
    		while(rs.next()) {
    			question.addItem(rs.getString(1));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR");
    	}
        this.setVisible(true);
	}
	public void create()
	{
		qname.setBounds(30,40,120,20);
		this.add(qname);
		question.setBounds(160,40,200,20);
		this.add(question);
		update.setBounds(390, 40, 80, 20);
		this.add(update);
		this.update.addActionListener(this);
		select.setBounds(480, 40, 80, 20);
		this.add(select);
		this.select.addActionListener(this);
		logout.setBounds(600, 10, 100, 30);
		this.add(logout);
		logout.setBackground(Color.PINK);
		this.logout.addActionListener(this);
		newcreate.setBounds(250, 100, 120, 40);
		this.add(newcreate);
		this.newcreate.addActionListener(this);
		back.setBounds(600, 280, 100, 30);
		this.add(back);
		this.back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		if(src == back)
		{
			this.setVisible(false);
			new SelectFirst().teacherp();
		}
		else if(src == update)
		{
			this.setVisible(false);
			this.selectq=(String) question.getSelectedItem();
			System.out.println("selected Question Is: "+selectq);
			new TeacherQuestion(selectq);
		}
		else if(src == select)
		{
			this.selectq=(String) question.getSelectedItem();
			System.out.println("selected Question Is: "+selectq);
			this.setVisible(false);
			new timeopen(selectq);
		}
		else if(src == newcreate)
		{
			/*this.setVisible(false);
			new Createquestion();*/
			//first create a new table for wroted question name
			//insert the table name/question name into 'teacerquestions' table
			//then open the 'TeacherQuestion class to inser the questions
			//the question must be 10 number
		}
		else if(src == logout)
		{
			this.setVisible(false);
			new SelectFirst().teacherp();
		}
	}
	
	/*public static void main(String[] args)
	{
		new Updateqselect();
	}*/
}
